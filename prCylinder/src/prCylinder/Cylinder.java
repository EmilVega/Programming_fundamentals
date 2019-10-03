/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prCylinder;

/*
 * Cylinder class allows to create object of type cylinder. 
 * It has an attribute of the Circle class.
 */
public class Cylinder {
	
	private double height;
	private Circle base;
	
	// Constructor to initialize all the attribute
	public Cylinder(){
		height=1;
		base=new Circle ();
	}
	
	// Constructor to initialize the attributes through arguments that user wants.
	public Cylinder (Circle base, double height){
		this.base=base;
		this.height=height;
	}
	
	public Circle getBase(){
		return base;
	}
	
	public double getHeight(){
		return height;
	}
	
	public void setBase(Circle base){
		this.base=base;
	}
	
	public void setHeight(double height){
		this.height=height;
	}
	
	// This method move the center of the base
	public void move (double a, double b){
		base.move(a, b);
	}
	
	// This method allows to appreciate better the status of the cylinder in a string
	public String toString(){
		return "Base: "+ "("+base+") Height: "+height;
	}
}
