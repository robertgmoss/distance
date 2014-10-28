package uk.co.robertgmoss.distance.probabilities;

import java.util.Iterator;
import java.util.Set;

public abstract class AbstractDistribution<T> implements Distribution<T> {

	private String id;

	public AbstractDistribution(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		Set<T> sampleSpace = sampleSpace();
		result = prime * result + sampleSpace.hashCode();
		for (T t : sampleSpace) {
			result = prime * result + Double.valueOf(probability(t)).hashCode();
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		try {
			Distribution<T> other = (Distribution<T>) obj;
			if (this.sampleSpace().equals(other.sampleSpace()))
				return false;
			for (T t : sampleSpace()) {
				if (this.probability(t) != other.probability(t))
					return false;
			}
		} catch (ClassCastException e) {
			return false;
		}

		return true;
	}

	public String id() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Iterator<T> it = sampleSpace().iterator();
		while (it.hasNext()) {
			T t = it.next();
			sb.append(t.toString() + " -> " + probability(t));
			if (it.hasNext())
				sb.append(", ");
		}
		sb.append("]");
		if (id() == null || id().equals(""))
			return sb.toString();
		return String.format("%15s = %s", this.id(), sb.toString());
	}

}
