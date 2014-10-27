package uk.co.robertgmoss.distance.sets;

import java.util.Set;

import uk.co.robertgmoss.distance.Distance;

public class JaccardDistance implements Distance<Set<?>>{

	public double distance(Set<?> x, Set<?> y) {
		int i = Sets.intersectionSize(x, y);
		int j = Sets.unionSize(x, y);
		return 1 - i / (double) j;
	}
}
