package uk.co.robertgmoss.distance.vectors;

import uk.co.robertgmoss.distance.Distance;

public class JaccardVectorDistance implements Distance<Vector> {

	public double distance(Vector x, Vector y) {
		if (x.dimensionality() != y.dimensionality())
			throw new RuntimeException("vectors have different dimensionalities");
		
		double sumMin = 0.0;
		double sumMax = 0.0;
		for(int i = 0; i < x.dimensionality(); i++){
			double xi = x.get(i); 
			double yi = y.get(i);
			sumMin += Math.min(xi, yi);
			sumMax += Math.max(xi, yi);
		}
		return 1 - sumMin / sumMax;
	}

}
