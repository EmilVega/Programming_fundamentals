/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prCylinder;

// TestCylinder class is the class to test the classes: Point, Circle and Cylinder.
public class TestCylinder {
	
	/*
	 * In the main method creates three objects: a point, a circle and a cylinder.
	 * The cylinder is moved of position and show its state 
	 */
	public static void main(String[] args) {
		
		Point baseCentre = new Point(3.0, 5.0);
		Circle base = new Circle(baseCentre, 4.0);
		Cylinder myCylinder = new Cylinder(base, 10.0);
		System.out.println(myCylinder);
		myCylinder.move(2.0, 2.0);
		System.out.println(myCylinder);
		System.out.println(new Cylinder(new Circle(new Point(3.0, 5.0), 4.0), 10.0));

	}

}
