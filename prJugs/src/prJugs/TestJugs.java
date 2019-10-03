/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */


package prJugs;

// TestJugs class is the class to test the Jug class.
public class TestJugs {

	// In the main method creates two jugs to fill and empty until have one liter in one jug.
	public static void main(String[] args) {
		Jug jugA = new Jug(5);
		Jug jugB = new Jug(7);
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
	}

}
