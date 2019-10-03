/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prCar;

/**
 * This class is inherited of Car
 * @author emil
 *
 */
public class ImportedCar extends Car {
	private double approval;
	
	
	/**
	 * Constructor to initialize the attributes given three parameters
	 * @param name 
	 * This is the name of the imported car
	 * @param price
	 * This is the normal price of the car
	 * @param approval
	 * This is the approval for a imported car
	 */
	public ImportedCar(String name, double price, double approval){
		super(name,price);
		this.approval=approval;
	}
	
	// This method allow to compute the total price of a imported car
	public double totalPrice(){
		return super.totalPrice()+approval;
	}
}
