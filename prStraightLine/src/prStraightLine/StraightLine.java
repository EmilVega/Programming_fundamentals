/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prStraightLine;

import prCylinder.Point;
/*
 * StraightLine class allows to create objects of type StraightLine. 
 * It has an attribute of the Point class and Vector class.
 */
public class StraightLine {
	private Point pto;
	private Vector direction;
	
	// Constructor to initialize the attributes
	public StraightLine(Vector direction, Point pto){
		this.direction=direction;
		this.pto=pto;
	}
	
	// Constructor to initialize the attributes through two points.
	public StraightLine (Point pto, Point pto2){
		direction = new Vector(pto, pto2);
		this.pto = pto2;
	}
	
	// This method allows to know if the straight line go through a point
	public boolean goThrough (Point pto){
		Vector vec = new Vector(pto, this.pto);
		return vec.parallelTo(direction);
	}
	
	// This method allows to know if two straight lines are parallels 
	public boolean parallelTo(StraightLine line){
		return direction.parallelTo(line.direction);
	}
	
	// This method creates a line parallel to another.
	public StraightLine parallelTo(Point pto){
		StraightLine parallelLine = new StraightLine(direction, pto);
		return parallelLine;
	}
	
	// This method creates a perpendicular line to the straight line, given a point
	public StraightLine perpendicularThrough(Point pto){
		Vector ortVec = direction.orthogonal();
		StraightLine perpendicularLine = new StraightLine(ortVec, pto);
		return perpendicularLine;
	}
	
	// This method allows to know the point of intersection between to straight lines
	public Point intersectionWith(StraightLine line){
		double d = (line.direction.getY()*direction.getX())-(direction.getY()*line.direction.getX());
		double d1 = (direction.getX()*pto.getY())-(direction.getY()*pto.getY());
		double d2 = (line.direction.getX()*line.pto.getY())-(line.direction.getY()*line.pto.getX());
		double ox = ((d1*line.direction.getX())-(direction.getX()*d2))/d;
		double oy = -((direction.getY()*d2)-(line.direction.getY()*d1))/d;
		Point ptoInt = new Point (ox,oy);
		return ptoInt;
	}
	
	// This method allows to know the distance between a point and the straight line
	public double distanceFrom(Point pto){
		StraightLine perpendicularLine = perpendicularThrough(pto);
		Point ptoInt = intersectionWith(perpendicularLine);
		return ptoInt.distance(pto);
	}
	
	public String toString(){
		return "R("+direction+","+pto+")";
	}
}
