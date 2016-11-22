// Generated from JSPNL.g4 by ANTLR 4.5.3

package jspetrinet.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JSPNLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		LOGICAL=32, ID=33, INT=34, FLOAT=35, STRING=36, NEWLINE=37, WS=38, LINE_COMMENT=39, 
		BLOCK_COMMENT=40;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "LOGICAL", "ID", 
		"INT", "FLOAT", "STRING", "NEWLINE", "WS", "LINE_COMMENT", "BLOCK_COMMENT", 
		"DIGIT", "EXPONENT", "CHAR", "TRUE", "FALSE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'place'", "'imm'", "'exp'", "'gen'", "'('", "')'", "'arc'", "'iarc'", 
		"'oarc'", "'harc'", "'to'", "','", "'='", "':='", "'!'", "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", 
		"'||'", "'ifelse'", "'#'", "'?'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "LOGICAL", "ID", "INT", 
		"FLOAT", "STRING", "NEWLINE", "WS", "LINE_COMMENT", "BLOCK_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public JSPNLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JSPNL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2*\u0147\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\5!\u00c0\n!\3\"\3\"\6\"\u00c4\n"+
		"\"\r\"\16\"\u00c5\3\"\6\"\u00c9\n\"\r\"\16\"\u00ca\3\"\7\"\u00ce\n\"\f"+
		"\"\16\"\u00d1\13\"\3#\6#\u00d4\n#\r#\16#\u00d5\3$\6$\u00d9\n$\r$\16$\u00da"+
		"\3$\3$\6$\u00df\n$\r$\16$\u00e0\5$\u00e3\n$\3$\5$\u00e6\n$\3$\3$\6$\u00ea"+
		"\n$\r$\16$\u00eb\5$\u00ee\n$\3$\5$\u00f1\n$\3$\6$\u00f4\n$\r$\16$\u00f5"+
		"\3$\3$\5$\u00fa\n$\3%\3%\3%\3%\3%\3%\7%\u0102\n%\f%\16%\u0105\13%\3%\3"+
		"%\3&\6&\u010a\n&\r&\16&\u010b\3\'\6\'\u010f\n\'\r\'\16\'\u0110\3\'\3\'"+
		"\3(\3(\3(\3(\7(\u0119\n(\f(\16(\u011c\13(\3(\3(\3)\3)\3)\3)\7)\u0124\n"+
		")\f)\16)\u0127\13)\3)\3)\3)\3)\3)\3*\3*\3+\3+\5+\u0132\n+\3+\6+\u0135"+
		"\n+\r+\16+\u0136\5+\u0139\n+\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3"+
		"\u0125\2/\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S\2U\2W\2Y\2[\2\3\2\20\5\2\f\f\17\17"+
		"==\4\2\13\13\"\"\4\2\f\f\17\17\3\2\62;\4\2GGgg\4\2--//\5\2C\\aac|\4\2"+
		"VVvv\4\2TTtt\4\2WWww\4\2HHhh\4\2CCcc\4\2NNnn\4\2UUuu\u015a\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3]\3\2\2\2\5c\3\2\2\2\7g"+
		"\3\2\2\2\tk\3\2\2\2\13o\3\2\2\2\rq\3\2\2\2\17s\3\2\2\2\21w\3\2\2\2\23"+
		"|\3\2\2\2\25\u0081\3\2\2\2\27\u0086\3\2\2\2\31\u0089\3\2\2\2\33\u008b"+
		"\3\2\2\2\35\u008d\3\2\2\2\37\u0090\3\2\2\2!\u0092\3\2\2\2#\u0094\3\2\2"+
		"\2%\u0096\3\2\2\2\'\u0098\3\2\2\2)\u009a\3\2\2\2+\u009c\3\2\2\2-\u009e"+
		"\3\2\2\2/\u00a1\3\2\2\2\61\u00a3\3\2\2\2\63\u00a6\3\2\2\2\65\u00a9\3\2"+
		"\2\2\67\u00ac\3\2\2\29\u00af\3\2\2\2;\u00b2\3\2\2\2=\u00b9\3\2\2\2?\u00bb"+
		"\3\2\2\2A\u00bf\3\2\2\2C\u00c1\3\2\2\2E\u00d3\3\2\2\2G\u00f9\3\2\2\2I"+
		"\u00fb\3\2\2\2K\u0109\3\2\2\2M\u010e\3\2\2\2O\u0114\3\2\2\2Q\u011f\3\2"+
		"\2\2S\u012d\3\2\2\2U\u012f\3\2\2\2W\u013a\3\2\2\2Y\u013c\3\2\2\2[\u0141"+
		"\3\2\2\2]^\7r\2\2^_\7n\2\2_`\7c\2\2`a\7e\2\2ab\7g\2\2b\4\3\2\2\2cd\7k"+
		"\2\2de\7o\2\2ef\7o\2\2f\6\3\2\2\2gh\7g\2\2hi\7z\2\2ij\7r\2\2j\b\3\2\2"+
		"\2kl\7i\2\2lm\7g\2\2mn\7p\2\2n\n\3\2\2\2op\7*\2\2p\f\3\2\2\2qr\7+\2\2"+
		"r\16\3\2\2\2st\7c\2\2tu\7t\2\2uv\7e\2\2v\20\3\2\2\2wx\7k\2\2xy\7c\2\2"+
		"yz\7t\2\2z{\7e\2\2{\22\3\2\2\2|}\7q\2\2}~\7c\2\2~\177\7t\2\2\177\u0080"+
		"\7e\2\2\u0080\24\3\2\2\2\u0081\u0082\7j\2\2\u0082\u0083\7c\2\2\u0083\u0084"+
		"\7t\2\2\u0084\u0085\7e\2\2\u0085\26\3\2\2\2\u0086\u0087\7v\2\2\u0087\u0088"+
		"\7q\2\2\u0088\30\3\2\2\2\u0089\u008a\7.\2\2\u008a\32\3\2\2\2\u008b\u008c"+
		"\7?\2\2\u008c\34\3\2\2\2\u008d\u008e\7<\2\2\u008e\u008f\7?\2\2\u008f\36"+
		"\3\2\2\2\u0090\u0091\7#\2\2\u0091 \3\2\2\2\u0092\u0093\7-\2\2\u0093\""+
		"\3\2\2\2\u0094\u0095\7/\2\2\u0095$\3\2\2\2\u0096\u0097\7,\2\2\u0097&\3"+
		"\2\2\2\u0098\u0099\7\61\2\2\u0099(\3\2\2\2\u009a\u009b\7\'\2\2\u009b*"+
		"\3\2\2\2\u009c\u009d\7>\2\2\u009d,\3\2\2\2\u009e\u009f\7>\2\2\u009f\u00a0"+
		"\7?\2\2\u00a0.\3\2\2\2\u00a1\u00a2\7@\2\2\u00a2\60\3\2\2\2\u00a3\u00a4"+
		"\7@\2\2\u00a4\u00a5\7?\2\2\u00a5\62\3\2\2\2\u00a6\u00a7\7?\2\2\u00a7\u00a8"+
		"\7?\2\2\u00a8\64\3\2\2\2\u00a9\u00aa\7#\2\2\u00aa\u00ab\7?\2\2\u00ab\66"+
		"\3\2\2\2\u00ac\u00ad\7(\2\2\u00ad\u00ae\7(\2\2\u00ae8\3\2\2\2\u00af\u00b0"+
		"\7~\2\2\u00b0\u00b1\7~\2\2\u00b1:\3\2\2\2\u00b2\u00b3\7k\2\2\u00b3\u00b4"+
		"\7h\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7n\2\2\u00b6\u00b7\7u\2\2\u00b7"+
		"\u00b8\7g\2\2\u00b8<\3\2\2\2\u00b9\u00ba\7%\2\2\u00ba>\3\2\2\2\u00bb\u00bc"+
		"\7A\2\2\u00bc@\3\2\2\2\u00bd\u00c0\5Y-\2\u00be\u00c0\5[.\2\u00bf\u00bd"+
		"\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0B\3\2\2\2\u00c1\u00cf\5W,\2\u00c2\u00c4"+
		"\5S*\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00ce\3\2\2\2\u00c7\u00c9\5W,\2\u00c8\u00c7\3\2\2"+
		"\2\u00c9\u00ca\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00ce"+
		"\3\2\2\2\u00cc\u00ce\7\60\2\2\u00cd\u00c3\3\2\2\2\u00cd\u00c8\3\2\2\2"+
		"\u00cd\u00cc\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0"+
		"\3\2\2\2\u00d0D\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d4\5S*\2\u00d3\u00d2"+
		"\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"F\3\2\2\2\u00d7\u00d9\5S*\2\u00d8\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00e2\7\60"+
		"\2\2\u00dd\u00df\5S*\2\u00de\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00de"+
		"\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00de\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e6\5U+\2\u00e5\u00e4\3\2\2"+
		"\2\u00e5\u00e6\3\2\2\2\u00e6\u00fa\3\2\2\2\u00e7\u00ed\7\60\2\2\u00e8"+
		"\u00ea\5S*\2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3\2\2"+
		"\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00e9\3\2\2\2\u00ed\u00ee"+
		"\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00f1\5U+\2\u00f0\u00ef\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00fa\3\2\2\2\u00f2\u00f4\5S*\2\u00f3\u00f2\3\2\2"+
		"\2\u00f4\u00f5\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7"+
		"\3\2\2\2\u00f7\u00f8\5U+\2\u00f8\u00fa\3\2\2\2\u00f9\u00d8\3\2\2\2\u00f9"+
		"\u00e7\3\2\2\2\u00f9\u00f3\3\2\2\2\u00faH\3\2\2\2\u00fb\u0103\7$\2\2\u00fc"+
		"\u00fd\7\u0080\2\2\u00fd\u00fe\7]\2\2\u00fe\u00ff\7\17\2\2\u00ff\u0100"+
		"\7\f\2\2\u0100\u0102\7_\2\2\u0101\u00fc\3\2\2\2\u0102\u0105\3\2\2\2\u0103"+
		"\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0106\3\2\2\2\u0105\u0103\3\2"+
		"\2\2\u0106\u0107\7$\2\2\u0107J\3\2\2\2\u0108\u010a\t\2\2\2\u0109\u0108"+
		"\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c"+
		"L\3\2\2\2\u010d\u010f\t\3\2\2\u010e\u010d\3\2\2\2\u010f\u0110\3\2\2\2"+
		"\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113"+
		"\b\'\2\2\u0113N\3\2\2\2\u0114\u0115\7\61\2\2\u0115\u0116\7\61\2\2\u0116"+
		"\u011a\3\2\2\2\u0117\u0119\n\4\2\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2"+
		"\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c"+
		"\u011a\3\2\2\2\u011d\u011e\b(\3\2\u011eP\3\2\2\2\u011f\u0120\7\61\2\2"+
		"\u0120\u0121\7,\2\2\u0121\u0125\3\2\2\2\u0122\u0124\13\2\2\2\u0123\u0122"+
		"\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0126\3\2\2\2\u0125\u0123\3\2\2\2\u0126"+
		"\u0128\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129\7,\2\2\u0129\u012a\7\61"+
		"\2\2\u012a\u012b\3\2\2\2\u012b\u012c\b)\3\2\u012cR\3\2\2\2\u012d\u012e"+
		"\t\5\2\2\u012eT\3\2\2\2\u012f\u0131\t\6\2\2\u0130\u0132\t\7\2\2\u0131"+
		"\u0130\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0138\3\2\2\2\u0133\u0135\5S"+
		"*\2\u0134\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0134\3\2\2\2\u0136"+
		"\u0137\3\2\2\2\u0137\u0139\3\2\2\2\u0138\u0134\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139V\3\2\2\2\u013a\u013b\t\b\2\2\u013bX\3\2\2\2\u013c\u013d\t\t"+
		"\2\2\u013d\u013e\t\n\2\2\u013e\u013f\t\13\2\2\u013f\u0140\t\6\2\2\u0140"+
		"Z\3\2\2\2\u0141\u0142\t\f\2\2\u0142\u0143\t\r\2\2\u0143\u0144\t\16\2\2"+
		"\u0144\u0145\t\17\2\2\u0145\u0146\t\6\2\2\u0146\\\3\2\2\2\32\2\u00bf\u00c5"+
		"\u00ca\u00cd\u00cf\u00d5\u00da\u00e0\u00e2\u00e5\u00eb\u00ed\u00f0\u00f5"+
		"\u00f9\u0103\u010b\u0110\u011a\u0125\u0131\u0136\u0138\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}