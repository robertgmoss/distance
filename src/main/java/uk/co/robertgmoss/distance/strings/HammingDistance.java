package uk.co.robertgmoss.distance.strings;

import uk.co.robertgmoss.distance.Distance;

public class HammingDistance implements Distance<String>{

	public double distance(String x, String y) {
		if(x.length() != y.length()) 
			throw new RuntimeException("Strings are not of equal length: " + x + ", " + y);

		return distance(x.toCharArray(), y.toCharArray());
	}

	private double distance(char[] x, char[] y) {
		int count = 0;
		assert x.length == y.length;
		for(int i = 0; i < x.length; i++){
			if (x[i] != y[i]) count++;
		}
		return count;
	}

}
