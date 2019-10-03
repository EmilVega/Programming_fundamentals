/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prCylinder;

// Circle class allows to create object of type circle. It has an attribute of the Point class.
public class Circle {
	
	private double radius;
	private Point centre;
	
	// Constructor to initialize the attributes
	public Circle(){
		radius=1;
		centre = new Point();
	}
	
	// Constructor to initialize the attributes through arguments that user wants.
	public Circle (Point centre, double radius){
		this.centre=centre;
		this.radius=radius;
	}
	
	public Point getCentre(){
		return centre;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public void setCentre(Point centre){
		this.centre=centre;
	}
	
	public void setRadius(double radius){
		this.radius=radius;
	}
	
	// This method move the point of the center
	public void move (double a, double b){
		centre.move(a, b);
	}
	
	// This method allows to appreciate better the status of the circle in a string
	public String toString(){
		return "Centre: "+ "("+centre+") Radius: "+radius;
	}

}
