package jspetrinet.sim;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jspetrinet.JSPetriNet;
import jspetrinet.ast.ASTree;
import jspetrinet.dist.*;
import jspetrinet.exception.*;
import jspetrinet.marking.Mark;
import jspetrinet.marking.MarkingArc;
import jspetrinet.marking.PetriAnalysis;
import jspetrinet.petri.ExpTrans;
import jspetrinet.petri.GenTrans;
import jspetrinet.petri.ImmTrans;
import jspetrinet.petri.Net;
import jspetrinet.petri.Trans;

public class MCSimulation {

	protected Net net;
	protected Random rnd;
	protected final Map<Mark, Mark> markSet;//結果表示用に通ったマーキングを保存
	protected final Map<PairMark, PairMark> arcSet;
	protected final Map<Trans, Double> remainingTime;//一般発火トランジションの残り時間

	public MCSimulation(Net net) {
		this.net = net;
		markSet = new HashMap<Mark, Mark>();
		arcSet = new HashMap<PairMark, PairMark>();
		remainingTime = new HashMap<Trans, Double>();
		for (Trans tr : net.getGenTransSet()) {
			remainingTime.put(tr, 0.0);
		}
	}
	
	private double nextTime(Net net, ExpTrans tr, Random rnd) throws ASTException {
		try {
			double rate = Utility.convertObjctToDouble(tr.getRate().eval(net));
			return rnd.nextExp(rate);
		} catch (TypeMismatch e) {
			System.err.println("Did not get a rate of ExpTrans " + tr.getLabel() + " " + tr.getRate().eval(net));
			throw e;
		}
	}

	private double nextTime(Net net, GenTrans tr, Random rnd) throws ASTException {
		ASTree v = tr.getDist();
		if (v instanceof ASTVariable) {
			v = ((ASTVariable) v).getObject(net);
		}
		if (v instanceof ConstDist) {
			ConstDist dist = (ConstDist) v;
			return Utility.convertObjctToDouble(dist.getConstValue().eval(net));
		} else if (v instanceof UnifDist) {
			UnifDist dist = (UnifDist) v;
			double lower = Utility.convertObjctToDouble(dist.getLower().eval(net));
			double upper = Utility.convertObjctToDouble(dist.getUpper().eval(net));
			return rnd.nextUnif(lower, upper);
		} else if (v instanceof ExpDist) {
			ExpDist dist = (ExpDist) v;
			double rate = Utility.convertObjctToDouble(dist.getRate());
			return rnd.nextExp(rate);
		} else {
			throw new TypeMismatch();
		}
	}

	private void updateRemainingTime(Trans selTrans, double elapsedTime) throws ASTException{
		for (Trans tr : net.getGenTransSet()) {
			switch (PetriAnalysis.isEnable(net, tr)) {
			case ENABLE:
				if(tr.equals(selTrans)){//発火したことがわかるよう残り時間を0に
					remainingTime.put(tr, 0.0);
				}else{//発火可能だったものの発火しなかったトランジションは残り時間を更新
					remainingTime.put(tr, remainingTime.get(tr)-elapsedTime);
				}
				break;
			default:
			}
		}
	}

	public List<EventValue> runSimulation(Mark initMarking, double startTime, double endTime, int limitFiring, Random rnd) throws ASTException {
		List<EventValue> eventValues = new ArrayList<EventValue>();
		int firingcount = 0;
		double currentTime = startTime;
		Mark currentMarking = initMarking;
		if(!markSet.containsValue(currentMarking)){
			markSet.put(currentMarking, currentMarking);
		}else{
			currentMarking = markSet.get(currentMarking);
		}
		eventValues.add(new EventValue(initMarking, currentTime));
		while (true) {
			net.setCurrentMark(currentMarking);
			if(firingcount>=limitFiring){
				//上限推移数で終了したことを伝える
				break;
			}
			for (Trans tr : net.getGenTransSet()) {
				switch (PetriAnalysis.isEnableGenTrans(net, tr)) {
				case ENABLE:
					if(remainingTime.get(tr)==0){//残り時間0とは前回がDISABLE,もしくは発火したことを示すので残り時間を初期化
						remainingTime.put(tr, this.nextTime(net, (GenTrans) tr, rnd));
					}//それ以外は残り時間継続
					break;
				case PREEMPTION:
					//ガードがあり、PolicyがPRSのため残り時間は減らない
					break;
				case DISABLE:
					remainingTime.put(tr, 0.0);
					break;
				default:
				}
			}
			Trans selTrans = null;
			double mindt = 0;
			double totalWeight = 0;
			for (Trans tr : net.getImmTransSet()) {
				switch (PetriAnalysis.isEnable(net, tr)) {
				case ENABLE:
					double weight = Utility.convertObjctToDouble(((ImmTrans)tr).getWeight().eval(net));
					if(weight>=(rnd.nextUnif01()*(weight+totalWeight))){
						selTrans = tr;
					}
					totalWeight += weight;
					break;
				default:
				}
			}
			if(totalWeight==0){
				mindt = Double.POSITIVE_INFINITY;
				for (Trans tr : net.getGenTransSet()) {
					switch (PetriAnalysis.isEnable(net, tr)) {
					case ENABLE:
						double dt = remainingTime.get(tr);
						if(dt < mindt){
							mindt = dt;
							selTrans = tr;
						}
						break;
					default:
					}
				}
				for (Trans tr : net.getExpTransSet()) {
					switch (PetriAnalysis.isEnable(net, tr)) {
					case ENABLE:
						double dt = this.nextTime(net, (ExpTrans) tr, rnd);
						if(dt < mindt){
							mindt = dt;
							selTrans = tr;
						}
						break;
					default:
					}
				}
			}
			if(selTrans==null){
				System.out.println("aaa");
				//終了したことを記録
				break;
			}
			//一般発火トランジションの残り時間再セット
			updateRemainingTime(selTrans, mindt);
			currentTime += mindt;
			if(currentTime>endTime){
				System.out.println("aaa");
				break;
			}
			//発火処理
			Mark previousMarking = currentMarking;
			currentMarking = PetriAnalysis.doFiring(net, selTrans);
			if(!markSet.containsValue(currentMarking)){//発火先がmarkSetになければ追加
				markSet.put(currentMarking, currentMarking);
			}else{//発火先がmarkSetにある場合、
				currentMarking = markSet.get(currentMarking);
			}
 			PairMark pairMark = new PairMark(previousMarking, currentMarking);
			if(!arcSet.containsValue(pairMark)){
				arcSet.put(pairMark, pairMark);
				new MarkingArc(previousMarking, currentMarking, selTrans);

			}
			eventValues.add(new EventValue(currentMarking, currentTime));
			firingcount++;
		}
		return eventValues;
	}

	public List<EventValue> runSimulation(Mark initMarking, double startTime, double endTime, ASTree stopCondition, int limitFiring, Random rnd) throws ASTException {
		List<EventValue> eventValues = new ArrayList<EventValue>();
		int firingcount = 0;
		double currentTime = startTime;
		Mark currentMarking = initMarking;
		if(!markSet.containsValue(currentMarking)){
			markSet.put(currentMarking, currentMarking);
		}else{
			currentMarking = markSet.get(currentMarking);
		}
		eventValues.add(new EventValue(initMarking, currentTime));
		while (true) {
			net.setCurrentMark(currentMarking);
			if (Utility.convertObjctToBoolean(stopCondition.eval(net))) {
				break;
			}
			if(firingcount>=limitFiring){
				//上限推移数で終了したことを伝える
				break;
			}
			for (Trans tr : net.getGenTransSet()) {
				switch (PetriAnalysis.isEnableGenTrans(net, tr)) {
				case ENABLE:
					if(remainingTime.get(tr)==0){//残り時間0とは前回がDISABLE,もしくは発火したことを示すので残り時間を初期化
						remainingTime.put(tr, this.nextTime(net, (GenTrans) tr, rnd));
					}//それ以外は残り時間継続
					break;
				case PREEMPTION:
					//ガードがあり、PolicyがPRSのため残り時間は減らない
					break;
				case DISABLE:
					remainingTime.put(tr, 0.0);
					break;
				default:
				}
			}
			Trans selTrans = null;
			double totalWeight = 0;
			for (Trans tr : net.getImmTransSet()) {
				switch (PetriAnalysis.isEnable(net, tr)) {
				case ENABLE:
					double weight = Utility.convertObjctToDouble(((ImmTrans)tr).getWeight().eval(net));
					if(weight>=(rnd.nextUnif01()*(weight+totalWeight))){
						selTrans = tr;
					}
					totalWeight += weight;
					break;
				default:
				}
			}
			double mindt = Double.POSITIVE_INFINITY;
			if(totalWeight==0){
				for (Trans tr : net.getGenTransSet()) {
					switch (PetriAnalysis.isEnable(net, tr)) {
					case ENABLE:
						double dt = remainingTime.get(tr);
						if(dt < mindt){
							mindt = dt;
							selTrans = tr;
						}
						break;
					default:
					}
				}
				for (Trans tr : net.getExpTransSet()) {
					switch (PetriAnalysis.isEnable(net, tr)) {
					case ENABLE:
						double dt = this.nextTime(net, (ExpTrans) tr, rnd);
						if(dt < mindt){
							mindt = dt;
							selTrans = tr;
						}
						break;
					default:
					}
				}
			}
			if(selTrans==null){
				//終了したことを記録
				break;
			}
			//一般発火トランジションの残り時間再セット
			updateRemainingTime(selTrans, mindt);
			currentTime += mindt;
			if(currentTime>endTime){
				break;
			}
			//発火処理
			Mark previousMarking = currentMarking;
			currentMarking = PetriAnalysis.doFiring(net, selTrans);
			if(!markSet.containsValue(currentMarking)){//発火先がmarkSetになければ追加
				markSet.put(currentMarking, currentMarking);
			}else{//発火先がmarkSetにある場合、
				currentMarking = markSet.get(currentMarking);
			}
 			PairMark pairMark = new PairMark(previousMarking, currentMarking);
			if(!arcSet.containsValue(pairMark)){
				arcSet.put(pairMark, pairMark);
				new MarkingArc(previousMarking, currentMarking, selTrans);

			}
			eventValues.add(new EventValue(currentMarking, currentTime));
			firingcount++;
		}
		return eventValues;
	}
	
	private double evalReward(Net net, ASTree reward) throws ASTException {
		return Utility.convertObjctToDouble(reward.eval(net));
	}

	public double resultReward(Net net, List<EventValue> simResult, ASTree reward, double startTime, double endTime) throws ASTException {
		double totalReward = 0;
		for(int i=0;i<simResult.size();i++){
			net.setCurrentMark(simResult.get(i).getEventMarking());
			if(startTime<=simResult.get(i).getEventTime()){
				if(i==simResult.size()-1){
					totalReward += (endTime - simResult.get(i).getEventTime()) * evalReward(net, reward);
					break;
				}else{
					if(endTime>=simResult.get(i+1).getEventTime()){
						totalReward += (simResult.get(i+1).getEventTime() - simResult.get(i).getEventTime()) * evalReward(net, reward);
					}else{
						totalReward += (endTime - simResult.get(i).getEventTime()) * evalReward(net, reward);
						break;
					}
				}
			}else if(i==simResult.size()-1){
				totalReward += (endTime - startTime) * evalReward(net, reward);
			}else if(startTime<=simResult.get(i+1).getEventTime()){
				totalReward += (simResult.get(i+1).getEventTime() - startTime) * evalReward(net, reward);
			}
		}
		return totalReward;
	}

	public void resultEvent(PrintWriter pw, List<EventValue> eventValues){
		for (EventValue ev : eventValues) {
			pw.print(String.format("%.2f", ev.getEventTime())+" : ");
			pw.println(JSPetriNet.markToString(net, ev.getEventMarking()));
		}
	}
}