package uk.co.robertgmoss.distance.probabilities;

import java.util.HashSet;
import java.util.Set;

import uk.co.robertgmoss.distance.Distance;

public class JensenShannonDistance<T> implements Distance<Distribution<T>> {

	private static final double LOG2 = Math.log(2);

	public static <T> double jensenShannonDivergence(Distribution<T> distributionX,
			Distribution<T> distributionY) {
		Set<T> sampleSpace = union(distributionX, distributionY);
		double d = 0.0;
		for (T outcome : sampleSpace) {
			double x = distributionX.probability(outcome);
			if(x == 0.0) continue;
			double y = distributionY.probability(outcome);
			if(y == 0.0) continue;
			d += x * log2(x) + y * log2(y) - (x + y) * log2(x + y);
		}
		return 1 + 0.5 * d;
	}

	private static <T> Set<T> union(Distribution<T> distributionX,
			Distribution<T> distributionY) {
		Set<T> sampleSpace = new HashSet<T>(distributionX.sampleSpace());
		sampleSpace.addAll(distributionY.sampleSpace());
		return sampleSpace;
	}

	private static double log2(double x) {
		return x == 0 ? 0 : Math.log(x) / LOG2;
	}

	public double distance(Distribution<T> distributionX,
			Distribution<T> distributionY) {
		return Math.sqrt(jensenShannonDivergence(distributionX, distributionY));
	}

}
