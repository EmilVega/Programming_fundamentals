/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */


package prJugException;

/**
 * This class allows to test de class jug
 * @author emil
 *
 */
public class TestJugs {

	// In the main method creates two jugs to fill and empty until have one liter in one jug.
	public static void main(String[] args) {
		try {
			Jug jugA = new Jug(Integer.parseInt(args[0]));
			Jug jugB = new Jug(Integer.parseInt(args[1]));
			jugA.fill();
			System.out.println("Estado de jarra A: " + jugA+" Estado de jarra B: " + jugB);
			jugB.pourFrom(jugA);
			System.out.println("Estado de jarra A: " + jugA+" Estado de jarra B: " + jugB);
			jugA.fill();
			System.out.println("Estado de jarra A: " + jugA+" Estado de jarra B: " + jugB);
			jugB.pourFrom(jugA);
			System.out.println("Estado de jarra A: " + jugA+" Estado de jarra B: " + jugB);
			jugB.empty();
			System.out.println("Estado de jarra A: " + jugA+" Estado de jarra B: " + jugB);
			jugB.pourFrom(jugA);
			System.out.println("Estado de jarra A: " + jugA+" Estado de jarra B: " + jugB);
			jugA.fill();
			System.out.println("Estado de jarra A: " + jugA+" Estado de jarra B: " + jugB);
			jugB.pourFrom(jugA);
			System.out.println("Estado de jarra A: " + jugA+" Estado de jarra B: " + jugB);
			
		}catch(NumberFormatException e){
			System.out.println("ERROR. Some parameter is not a number");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ERROR. Use: TestJug initialCapacityJug1 initialCapacityJug2");
		}catch(JugCapacityException e){
			System.out.println(e.getMessage());
		}
		
		
	}

}
