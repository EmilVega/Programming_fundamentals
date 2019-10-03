package prStraightLine;

import prCylinder.Point;

// TestStraightLine class is the class to test the classes: Point, Vector and StraightLine.
public class TestStraightLine {

	public static void main(String[] args) {
		// Compute the área of a triangle given by three points
		Point p1 = new Point(0,0);
		Point p2 = new Point(4,0);
		Point p3 = new Point(2,3);
		// Compute the distance between p1 and p2
		double base = p1.distance(p2);
		// Compute the line that goes through p1 and p2
		StraightLine r1 = new StraightLine(p1,p2);
		// Compute the distance between p3 and r1
		double height = r1.distanceFrom(p3);
		// The area is base* height /2
		double area = base* height /2;
		System.out.printf ("Points %s %s %s\n",p1,p2,p3);
		System.out.println ("Area = "+area);
		// The perpendicular to r1 through p3
		StraightLine r2 = r1.perpendicularThrough(p3);
		System.out.println("The perpendicular to " + r1 + " through " +
		p3 + " is: " + r2);
		// The intersection of r2 the parallel line to r1 that goes through p3
		System.out.println("The intersection is: "+r2.intersectionWith(r1.parallelTo(p3)));
	}

}
