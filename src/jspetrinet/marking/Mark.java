package jspetrinet.marking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jspetrinet.JSPetriNet;
import jspetrinet.graph.Arc;
import jspetrinet.petri.Net;

public final class Mark extends jspetrinet.graph.Node implements Comparable<Mark> {

	private final Net net;
	private final byte[] vec;
	private MarkGroup markGroup;

	public Mark(Net net, int size) {
		this.net = net;
		this.vec = new byte [size];
		markGroup = null;
	}

	public Mark(Mark m) {
		this.net = m.net;
		this.vec = Arrays.copyOf(m.vec, m.vec.length);
		markGroup = null;
	}

	public final int get(int i) {
		return vec[i];
	}
	
	@Override
	public String toString() {
		return JSPetriNet.markToString(net, this);
	}

	public final void set(int i, int v) {
		vec[i] = (byte) v;
	}

	public final List<Mark> next() {
		List<Mark> next = new ArrayList<Mark>();
		for (Arc a: getOutArc()) {
			next.add((Mark) a.getDest());
		}
		return next;
	}
	
	public final MarkGroup getMarkGroup() {
		return markGroup;
	}
	
	public final void setMarkGroup(MarkGroup mg) {
		mg.add(this);
		markGroup = mg;
	}
	
	@Override
	public final int hashCode() {
		return Arrays.hashCode(vec);
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mark other = (Mark) obj;
		if (!Arrays.equals(vec, other.vec))
			return false;
		return true;
	}

	@Override
	public int compareTo(Mark other) {
		if (vec.length < other.vec.length) {
			return -1;
		}
		if (vec.length > other.vec.length) {
			return 1;
		}
		for (int i=vec.length-1; i>=0; i--) {
			if (vec[i] < other.vec[i]) {
				return -1;
			}
			if (vec[i] > other.vec[i]) {
				return 1;
			}
		}
		return 0;
	}
}
