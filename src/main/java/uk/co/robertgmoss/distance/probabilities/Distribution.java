package uk.co.robertgmoss.distance.probabilities;

import java.util.Set;

public interface Distribution<E> {
	
	double probability(E outcome);
	
	Set<E> sampleSpace();
}
