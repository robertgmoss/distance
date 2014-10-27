package uk.co.robertgmoss.distance.sets;

import java.util.HashSet;
import java.util.Set;

public final class Sets {
	
	private Sets() {}

	public static int intersectionSize(Set<?> x, Set<?> y) {
		Set<Object> intersection = new HashSet<Object>(x);
		intersection.retainAll(y);
		return intersection.size();
	}
	
	public static int unionSize(Set<?> x, Set<?> y) {
		Set<Object> union = new HashSet<Object>(x);
		union.addAll(y);
		return union.size();
	}

}
