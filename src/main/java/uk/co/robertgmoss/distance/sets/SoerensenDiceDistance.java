package uk.co.robertgmoss.distance.sets;

import java.util.Set;

import uk.co.robertgmoss.distance.Distance;

public class SoerensenDiceDistance  implements Distance<Set<?>>{

	public double distance(Set<?> x, Set<?> y) {
		int i = 2 * Sets.intersectionSize(x, y);
		int j = x.size() + y.size();
		return 1 - i / j;
	}


}
