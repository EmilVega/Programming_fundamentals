/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prStraightLine;

import prCylinder.Point;

/*
 *Vector class allows to create objects of type Vector. 
 * It has an attribute of the Point class.
 */
public class Vector {
	private Point end;
	
	// Constructor to initialize the attribute
	public Vector (double x, double y){
		end = new Point(x,y);
	}
	
	// Constructor to initialize the attribute with a given point
	public Vector (Point end){
		this.end=end;
	}
	
	/* 
	 * Constructor to initialize the attribute.
	 * Given two points to make an end point equivalent with the origin in the origin of coordinates
	 */
	public Vector (Point pto1, Point pto2){
		end = new Point(pto2.getX()-pto1.getX(), pto2.getY()-pto1.getY());
	}
	
	public double getX(){
		return end.getX();
	}
	
	public double getY(){
		return end.getY();
	}
	
	// This method allows to compute the module of a vector
	public double modulus(){
		return Math.sqrt((Math.pow(end.getX(), 2))+(Math.pow(end.getY(), 2)));
	}
	
	// This method creates a orthogonal vector from this vector 
	public Vector orthogonal(){
		Vector vecOrt = new Vector(-end.getY(),end.getX());
		return vecOrt;
	}
	
	// This method allow to know if two vectors are parallels
	public boolean parallelTo(Vector vec){
		boolean bandera=false;
		if ((end.getX()*vec.getY()) == (end.getY()*vec.getX())){
			bandera=true;
		}
		return bandera;
	}
	
	// Given a point, this method creates a new end point 
	public Point endFrom(Point org){
		Point end = new Point(getX()+org.getX(), getY()+org.getY());
		return end;
	}
	
	public String toString(){
		return "V"+end;
	}
}
