/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prCar;

public class Example2 {

	public static void main(String[] args) {
		Car[] cs = { new Car("Seat Panda", 15000),
		new ImportedCar("Ferrari T-R", 65000, 8000),
		new Car("Seat Toledo", 21000),
		new ImportedCar("Jaguar XK", 41000, 6000),
		new ImportedCar("Porche GT3", 44000, 7000) };
		for(Car c : cs) {
			System.out.println(c);
		}
		// The VAT is changed for all cars
		Car.setVAT(0.18);
		System.out.println("VAT is now 18%");
		for(Car c : cs) {
			System.out.println(c);
		}
	}

}
