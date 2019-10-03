/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prStatistics;

//TestStatistics class is the class to test the Statistics class.
public class TestStatistics {

	public static void main(String[] args) {
		Statistics est = new Statistics();
		java.util.Random ran = new java.util.Random();
		for (int i = 0; i < 100000 ; i++) {
		est.add(ran.nextGaussian());
		}
		System.out.println("Mean = "+est.getMean());
		System.out.println("Standard deviation = "+est.getStandardDeviation());

	}

}
