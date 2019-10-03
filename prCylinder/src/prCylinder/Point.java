/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prCylinder;

// Point class allows to create object of type point
public class Point {
	private double x;
	private double y;
	
	// Constructor to initialize all the attribute
	public Point (){
		x=0;
		y=0;
	}
	
	// Constructor to initialize the attributes through arguments that user wants.
	public Point (double x, double y){
		this.x=x;
		this.y=y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	// This method to compute the eucludian distance.
	public double distance (Point pto){
		return Math.sqrt((Math.pow(pto.x-x, 2))+(Math.pow(pto.y - y, 2)));
	}
	
	public void setX(double x){
		this.x=x;
	}
	
	public void setY(double y){
		this.y=y;
	}
	
	// This method move the abscissa and ordinate of the point.
	public void move (double a, double b){
		x=x+a;
		y=y+b;
	}
	
	// This method allows to appreciate better the status of the point in a string
	public String toString(){
		return "P("+x+","+y+")";
	}
}
