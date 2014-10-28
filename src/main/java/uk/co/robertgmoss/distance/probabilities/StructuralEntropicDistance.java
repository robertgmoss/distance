package uk.co.robertgmoss.distance.probabilities;

import uk.co.robertgmoss.distance.Distance;

public class StructuralEntropicDistance<T> implements Distance<Distribution<T>> {

	public double distance(Distribution<T> distributionX,
			Distribution<T> distributionY) {
		return Math.pow(2, JensenShannonDistance.jensenShannonDivergence(
				distributionX, distributionY)) - 1;
	}

}
