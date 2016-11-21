package jspetrinet.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import jspetrinet.ast.*;
import jspetrinet.dist.ConstDist;
import jspetrinet.dist.ExpDist;
import jspetrinet.dist.UnifDist;
import jspetrinet.exception.*;
import jspetrinet.petri.*;

public class JSPetriNetParser extends JSPNLBaseListener {
	
	private Net env;
	private final LinkedList<AST> stack;
	private final LinkedList<Exception> errorStack;
	
	private Net currentEnv;
	private Net options;
	
	private List<AST> args;
	private Map<Place,AST> placelist;

	private final JSPNLLexer lexer;
	private final JSPNLParser parser;
	private final ANTLRInputStream is;

	public JSPetriNetParser(InputStream in) throws IOException {
		stack = new LinkedList<AST>();
		errorStack = new LinkedList<Exception>();
		is = new ANTLRInputStream(in);
		lexer = new JSPNLLexer(is);
		parser = new JSPNLParser(new CommonTokenStream(lexer));
		parser.addParseListener(this);
	}
	
	public JSPetriNetParser(String text) {
		stack = new LinkedList<AST>();
		errorStack = new LinkedList<Exception>();
		is = new ANTLRInputStream(text);
		lexer = new JSPNLLexer(is);
		parser = new JSPNLParser(new CommonTokenStream(lexer));
		parser.addParseListener(this);
	}

//	public JSPetriNetParser(Net env) {
//		this.env = env;
//		currentEnv = env;
//	}
	
	public void setNet(Net net) {
		this.env = net;
		this.currentEnv = env;
	}

	public void makeNet() {
		parser.prog();
	}

	public AST getAST() {
		parser.expression();
		return stack.pop();
	}
	
	private void unaryExpression(String op) {
		AST expr = stack.pop();
		stack.push(new ASTUnary(expr, op));
	}

	private void binaryExpression(String op) {
		AST expr2 = stack.pop();
		AST expr1 = stack.pop();
		switch(op) {
		case "*":
		case "/":
		case "%":
		case "+":
		case "-":
			stack.push(new ASTArithmetic(expr1, expr2, op));
			break;
		case "<":
		case "<=":
		case ">":
		case ">=":
		case "==":
		case "!=":
			stack.push(new ASTComparator(expr1, expr2, op));
			break;
		case "&&":
		case "||":
			stack.push(new ASTLogical(expr1, expr2, op));
			break;
		default:
		}
	}

	private void ternaryExpression(String op) {
		AST expr3 = stack.pop();
		AST expr2 = stack.pop();
		AST expr1 = stack.pop();
		stack.push(new ASTTernary(expr1, expr2, expr3, "ite"));
	}
		
	private void defineIArc(Place src, Trans dest, AST multi, AST firing) {
		ArcBase a;
		try {
			a = env.createNormalInArc(src, dest, multi);
		} catch (JSPNException e) {
			System.err.println("Arc already exist" + e.getMessage());
			return;
		}
		
		if (firing != null) {
			a.setFiring(firing);
		}
	}

	private void defineOArc(Trans src, Place dest, AST multi, AST firing) {
		ArcBase a;
		try {
			a = env.createNormalOutArc(src, dest, multi);
		} catch (JSPNException e) {
			System.err.println("Arc already exist" + e.getMessage());
			return;
		}
		
		if (firing != null) {
			a.setFiring(firing);
		}
	}

	private void defineHArc(Place src, Trans dest, AST multi) {
		try {
			env.createInhibitArc(src, dest, multi);
		} catch (JSPNException e) {
			System.err.println("Arc already exist" + e.getMessage());
			return;
		}
	}
	
	private void definePlace(String name) throws JSPNException {
		int pmax = Place.DefaultMax;
		for (Map.Entry<String,Object> entry : options.entrySet()) {
			switch (entry.getKey()) {
			case "max":
				Object obj = ((AST) entry.getValue()).eval(currentEnv);
				if (obj instanceof Integer) {
					pmax = (Integer) obj;
				} else {
			          throw new JSPNException(JSPNExceptionType.TYPE_MISMATCH, "Error in the definition of place " + name + ". The max attribute should be an integer.");
				}
				break;
			default:
				throw new UnknownOption(entry.getKey());
			}
		}
		currentEnv.createPlace(name, pmax);
	}

	private void defineImmTrans(String name) throws JSPNException {
		ImmTrans tr = currentEnv.createImmTrans(name, new ASTVariable(name + ".weight"));
		tr.setGuard(new ASTVariable(name + ".guard"));
		currentEnv.put(name + ".guard", new ASTValue(true));
		tr.setPriority(0);
		tr.setVanishable(true);
		for (Map.Entry<String,Object> entry : options.entrySet()) {
			switch (entry.getKey()) {
			case "weight":
				currentEnv.put(name + ".weight", entry.getValue());
				break;
			case "guard":
				currentEnv.put(name + ".guard", entry.getValue());
				break;
			case "priority": {
				Object obj = ((AST) entry.getValue()).eval(currentEnv);
				if (obj instanceof Integer) {
					tr.setPriority((Integer) obj);
				} else {
			          throw new JSPNException(JSPNExceptionType.TYPE_MISMATCH, "Error in the definition of imm " + name + ". The priority attribute should be an integer.");
				}
				break;
			}
			case "vanishing": {
				Object obj = ((AST) entry.getValue()).eval(currentEnv);
				if (obj instanceof Boolean) {
					tr.setVanishable((Boolean) obj);
				} else {
			          throw new JSPNException(JSPNExceptionType.TYPE_MISMATCH, "Error in the definition of imm " + name + ". The vanishing attribute should be a boolean.");
				}
				break;
			}
			case "update":
				tr.setUpdate(placelist);
				break;
			default:
				throw new UnknownOption(entry.getKey());
			}
		}
	}

	private void defineExpTrans(String name) throws JSPNException {
		ExpTrans tr = currentEnv.createExpTrans(name, new ASTVariable(name + ".rate"));
		tr.setGuard(new ASTVariable(name + ".guard"));
		currentEnv.put(name + ".guard", new ASTValue(true));
		for (Map.Entry<String,Object> entry : options.entrySet()) {
			switch (entry.getKey()) {
			case "rate":
				currentEnv.put(name + ".rate", entry.getValue());
				break;
			case "guard":
				currentEnv.put(name + ".guard", entry.getValue());
				break;
			case "update":
				tr.setUpdate(placelist);
				break;
			default:
				throw new UnknownOption(entry.getKey());
			}
		}
	}

	private void defineGenTrans(String name) throws JSPNException {
		GenTrans tr = currentEnv.createGenTrans(name, new ASTVariable(name + ".dist"), GenTrans.DefaultPolicy);
		tr.setGuard(new ASTVariable(name + ".guard"));
		currentEnv.put(name + ".guard", new ASTValue(true));
		for (Map.Entry<String,Object> entry : options.entrySet()) {
			switch (entry.getKey()) {
			case "dist":
				currentEnv.put(name + ".dist", entry.getValue());
				break;
			case "guard":
				currentEnv.put(name + ".guard", entry.getValue());
				break;
			case "update":
				tr.setUpdate(placelist);
				break;
			default:
				throw new UnknownOption(entry.getKey());
			}
		}
	}

	@Override public void enterNode_declaration(JSPNLParser.Node_declarationContext ctx) {
		this.options = new Net("options");
		this.placelist = new HashMap<Place,AST>();
	}

	@Override
	public void exitNode_declaration(JSPNLParser.Node_declarationContext ctx) {
		try {
			switch (ctx.type.getText()) {
			case "place":
				this.definePlace(ctx.id.getText());
				break;
			case "imm":
				this.defineImmTrans(ctx.id.getText());
				break;
			case "exp":
				this.defineExpTrans(ctx.id.getText());
				break;
			case "gen":
				this.defineGenTrans(ctx.id.getText());
				break;
			default:
			}
		} catch (JSPNException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}

	@Override public void enterArc_declaration(JSPNLParser.Arc_declarationContext ctx) {
		this.options = new Net("options");
	}

	@Override
	public void exitArc_declaration(JSPNLParser.Arc_declarationContext ctx) {
		Object src, dest;
		try {
			src = env.get(ctx.srcName.getText());
			dest = env.get(ctx.destName.getText());
		} catch (JSPNException e) {
			System.err.println("src, dest is undefined" + e.getMessage());
			e.printStackTrace();
			return;
		}

		AST multi;
		if (options.contains("multi")) {
			try {
				multi = (AST) options.get("multi");
			} catch (Exception e) {
				System.err.println("Wrong definition of multi attribute" + e.getMessage());
				return;
			}
		} else {
			multi = new ASTValue(1);
		}

		AST firing = null;
		if (options.contains("firing")) {
			try {
				firing = (AST) options.get("firing");
			} catch (Exception e) {
				System.err.println("Wrong definition of firing attribute" + e.getMessage());
				return;
			}
		}

		try {
			switch (ctx.type.getText()) {
			case "arc":
				if (src instanceof Place && dest instanceof Trans) {
					this.defineIArc((Place) src, (Trans) dest, multi, firing);					
				} else if (src instanceof Trans && dest instanceof Place) {
					this.defineOArc((Trans) src, (Place) dest, multi, firing);					
				} else {
					throw new Exception();
				}
				break;
			case "iarc":
				this.defineIArc((Place) src, (Trans) dest, multi, firing);
				break;
			case "oarc":
				this.defineOArc((Trans) src, (Place) dest, multi, firing);
				break;
			case "harc":
				this.defineHArc((Place) src, (Trans) dest, multi);
				break;
			default:
			}
		} catch (Exception e) {
			System.err.println("The definition of src, dest is wrong" + e.getMessage());
			e.printStackTrace();
			return;
		}
	}

	@Override
	public void enterOption_list(JSPNLParser.Option_listContext ctx) {
		currentEnv = options;
	}

	@Override
	public void exitOption_list(JSPNLParser.Option_listContext ctx) {
		currentEnv = env;
	}

	@Override
	public void exitAssign_expression(JSPNLParser.Assign_expressionContext ctx) {
		AST right = stack.pop();
		switch (ctx.type) {
		case 1:
		case 2:
			currentEnv.put(ctx.id.getText(), right);
			break;
		default:
		}
	}

	@Override
	public void exitExpression(JSPNLParser.ExpressionContext ctx) {
		switch (ctx.type) {
		case 1:
			unaryExpression(ctx.op.getText());
			break;
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
			binaryExpression(ctx.op.getText());
			break;
		case 8:
			ternaryExpression(ctx.op.getText());
			break;
		case 12:
			try {
				Object tmp = env.get(ctx.id.getText());
				if (tmp instanceof AST) {
					stack.push((AST) tmp);
				} else if (tmp instanceof Integer) {
					stack.push(new ASTValue((Integer) tmp));
				} else if (tmp instanceof Double) {
					stack.push(new ASTValue((Double) tmp));
				} else if (tmp instanceof Boolean) {
					stack.push(new ASTValue((Boolean) tmp));					
				} else {
					
				}
			} catch (JSPNException e) {
//				errorStack.push(e);
//				System.err.println("Error: " + e.getMessage());
//				stack.push(new ASTValue(ctx.id.getText()));
				stack.push(new ASTVariable(ctx.id.getText()));
			}
			// get AST
			break;
		case 9:
		case 10:
		case 11:
		case 13:
		case 14:
		case 15:
			// nop
			break;
		default:
		}
	}

	@Override
	public void enterFunction_expression(JSPNLParser.Function_expressionContext ctx) {
		args = new ArrayList<AST>();
	}

	private void defineConstDist(List<AST> args) throws JSPNException {
		if (args.size() == 1) {
			AST value = args.iterator().next();
			stack.push(new ConstDist(value));
		} else {
			stack.push(new ASTValue(ConstDist.dname + "(value)"));
			throw new JSPNException(JSPNExceptionType.TYPE_MISMATCH, "Wrong definition of args of const dist");
		}
	}
	
	private void defineUnifDist(List<AST> args) throws JSPNException {
		if (args.size() == 2) {
			Iterator<AST> it = args.iterator();
			AST lower = it.next();
			AST upper = it.next();
			stack.push(new UnifDist(lower, upper));
		} else {
			stack.push(new ASTValue(ConstDist.dname + "(lower,upper)"));
			throw new JSPNException(JSPNExceptionType.TYPE_MISMATCH, "Wrong definition of args of unif dist");
		}
	}

	private void defineExpDist(List<AST> args) throws JSPNException {
		if (args.size() == 1) {
			Iterator<AST> it = args.iterator();
			AST rate = it.next();
			stack.push(new ExpDist(rate));
		} else {
			stack.push(new ASTValue(ExpDist.dname + "(rate)"));
			throw new JSPNException(JSPNExceptionType.TYPE_MISMATCH, "Wrong definition of args of exp dist");
		}
	}

	@Override
	public void exitFunction_expression(JSPNLParser.Function_expressionContext ctx) {
		try {
			switch (ctx.id.getText()) {
			case ConstDist.dname:
				this.defineConstDist(args);
				break;
			case UnifDist.dname:
				this.defineUnifDist(args);
				break;
			case ExpDist.dname:
				this.defineExpDist(args);
				break;
			default:
			}
		} catch (JSPNException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void exitArg_value(JSPNLParser.Arg_valueContext ctx) {
		args.add(stack.pop());
	}

	@Override
	public void exitPlace_value(JSPNLParser.Place_valueContext ctx) {
		try {
			AST val = stack.pop();
			ASTNumOfToken id = (ASTNumOfToken) stack.pop();
			Place p = id.getPlace();
			placelist.put(p, val);
			stack.push(new ASTValue("placeList"));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void exitNtoken_expression(JSPNLParser.Ntoken_expressionContext ctx) {
		try {
			Place p = (Place) env.get(ctx.id.getText());
			stack.push(new ASTNumOfToken(p));
		} catch (JSPNException e) {
			errorStack.push(e);
			System.err.println("Error: " + e.getMessage());
			stack.push(new ASTValue("#" + ctx.id.getText()));
		} catch (ClassCastException e) {
			errorStack.push(e);
			System.err.println("Error: " + e.getMessage());
			stack.push(new ASTValue("#" + ctx.id.getText()));
		}
	}

	@Override
	public void exitEnable_expression(JSPNLParser.Enable_expressionContext ctx) {
		try {
			Trans tr = (Trans) env.get(ctx.id.getText());
			stack.push(new ASTEnableCond(tr));
		} catch (JSPNException e) {
			errorStack.push(e);
			System.err.println("Error: " + e.getMessage());
			stack.push(new ASTValue("?" + ctx.id.getText()));
		} catch (ClassCastException e) {
			errorStack.push(e);
			System.err.println("Error: " + e.getMessage());
			stack.push(new ASTValue("?" + ctx.id.getText()));
		}
	}

	@Override
	public void exitLiteral_expression(JSPNLParser.Literal_expressionContext ctx) {
		switch (ctx.type) {
		case 1: // integer
			stack.push(new ASTValue(Integer.parseInt(ctx.val.getText())));
			break;
		case 2: // float
			stack.push(new ASTValue(Double.parseDouble(ctx.val.getText())));
			break;
		case 3: // logical
			stack.push(new ASTValue(Boolean.parseBoolean(ctx.val.getText())));
			break;
		case 4: // string
			stack.push(new ASTValue(ctx.val.getText()));
			break;
		default:
		}
	}
}
