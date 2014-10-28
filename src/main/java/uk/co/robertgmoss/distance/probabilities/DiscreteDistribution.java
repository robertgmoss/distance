package uk.co.robertgmoss.distance.probabilities;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class DiscreteDistribution<T> extends AbstractDistribution<T>{

	private Map<T, Double> v = new LinkedHashMap<T, Double>();
	
	public DiscreteDistribution(String id, Map<T, Double> data) {
		super(id);
		double sum = 0.0;
		for(Double d : data.values()){
			sum += d;
		}
		
		for(T t : data.keySet()){
			v.put(t, data.get(t) / sum);
		}
		
	}

	public double probability(T outcome) {
		return v.get(outcome);
	}

	public Set<T> sampleSpace() {
		return v.keySet();
	}
	
}
