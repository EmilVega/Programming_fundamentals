/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prMarks;

public class Student {
	private String name;
	private String dni;
	private double mark;
	
	public Student (String dni, String name, double mark) throws StudentException{
		if (mark<0){
			throw new StudentException ("ERROR. Negative Mark: ");
		}
		this.name=name;
		this.dni=dni.toUpperCase();
		this.mark=mark;
	}
	
	public Student (String name, String dni) throws StudentException{
		this(name, dni, 0);
	}
	
	public String getName(){
		return name;
	}
	
	public String getDni(){
		return dni.toUpperCase();
	}
	
	public double getMark(){
		return mark;
	}
	
	public boolean equals(Object o){
		return (o instanceof Student) && (((Student)o).name.equals(name) && ((Student)o).dni.equals(dni));
	}
	
	public String toString (){
		return "DNI: "+dni+" Name: "+name;
	}
	
	public int hashCode(){
		return name.hashCode() + dni.hashCode();
	}

}
