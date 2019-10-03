/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prStatistics;

// Statistics class allows to create objects of type statistic
public class Statistics {
	private double numElementos;
	private double sumX;
	private double sumX2;
	
	// Constructor to initialize all the attribute
	public Statistics (){
		numElementos=0;
		sumX=0;
		sumX2=0;
	}
	
	/*
	 * This method adds the value d to the series. numElements, sumX and
	 * sumX2 are increased by 1, d and d 2 respectively
	 */
	public void add(double d){
		numElementos=numElementos+1; 
		sumX=sumX+d;
		sumX2=sumX2+Math.pow(d, 2);		
	}
	
	// This method adds the value d to the series n times.
	public void add(double d, int n){
		numElementos=numElementos+n; 
		sumX=sumX+n*d;
		sumX2=sumX2+(n*Math.pow(d, 2));
	}
	
	// This method returns the arithmetic mean of the values
	public double getMean(){
		return sumX/numElementos;
	}
	
	// This method returns the variance
	public double getVariance(){
		return sumX2/numElementos-Math.pow(getMean(), 2) ;
	}
	
	// This method returns square root of the variance
	public double getStandardDeviation(){
		return Math.sqrt(getVariance());
	}

}
