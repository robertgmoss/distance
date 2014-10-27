package uk.co.robertgmoss.distance.sets;

import java.util.Set;

import uk.co.robertgmoss.distance.Distance;

public class OverlapDistance implements Distance<Set<?>> {

	public double distance(Set<?> x, Set<?> y) {
		int i = Sets.intersectionSize(x, y);
		int j = Math.min(x.size(), y.size());
		return 1 - i / j;
	}

	

}
