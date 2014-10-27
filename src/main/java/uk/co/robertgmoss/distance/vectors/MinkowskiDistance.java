package uk.co.robertgmoss.distance.vectors;

import uk.co.robertgmoss.distance.Distance;

public class MinkowskiDistance implements Distance<Vector>{
	
	public static Distance<Vector> manhattanDistance(){
		return new MinkowskiDistance(1.0);
	}
	
	public static Distance<Vector> euclideanDistance(){
		return new MinkowskiDistance(2.0);
	}
	
	public static Distance<Vector> chebychevDistance(){
		return new MinkowskiDistance(Double.POSITIVE_INFINITY);
	}
	
	private final double p;

	public MinkowskiDistance(double p) {
		if(p < 1) throw new IllegalArgumentException("Argument must be >= 1");
		this.p = p;
	}

	public double distance(Vector x, Vector y) {
		if(x.dimensionality() != y.dimensionality())
			throw new RuntimeException("vectors have different dimensionalities");
		if(p == Double.POSITIVE_INFINITY) return chebyshev(x, y);
		
		double sum = 0.0;
		for(int i = 0; i < x.dimensionality(); i++){
			sum += Math.pow(Math.abs(x.get(i) - y.get(i)), p); 
		}
		return Math.pow(sum, 1 / p);
	}

	private double chebyshev(Vector x, Vector y) {
		double max = 0;
		for(int i = 0; i < x.dimensionality(); i++){
			max = Math.max(max, Math.abs(x.get(i) - y.get(i))); 
		}
		return max;
	}

}
