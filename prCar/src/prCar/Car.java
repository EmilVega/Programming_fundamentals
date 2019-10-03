/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prCar;

/**
 * This class is a car
 * @author emil
 *
 */
public class Car {
	private String name;
	private double price;
	private static double VAT;
	
	/**
	 * Constructor to initialize the attributes given two parameters
	 * @param name
	 * This is the name of a car
	 * @param price
	 * This is the price of a car
	 */
	public Car (String name, double price){
		this.name=name;
		this.price=price;
		VAT=0.16;
	}
	
	/*
	 * Setter of VAT 
	 */
	public static void setVAT (double valor){
		VAT=valor;
	}
	
	/**
	 * This method allow to compute the total price of a car
	 * @return the value of price
	 */
	public double totalPrice(){
		return price+(price*VAT);
	}
	
	public String toString(){
		return name + " -> "+totalPrice();
	}
	
}
