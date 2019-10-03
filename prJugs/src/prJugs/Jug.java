/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */


package prJugs;

// Jug class allows to create objects of type jug. 
public class Jug {
	private int content;
	private final int capacity;

	// Constructor of Jug; it has a condition to control the capacity.
	public Jug (int cap){
		if (cap<=0){
			throw new RuntimeException("La capacidad de una jarra debe ser un numero mayor que cero");
		}
		content=0;
		capacity=cap;
	}
	
	public int getCapacity () {
		return capacity;
	}
	
	public int getContent () {
		return content;
	}
	
	public void fill(){
		content=capacity;
	}
	
	public void empty (){
		content=0;
	}
	
	/* 
	 * This method allow pour the content of a jug to another. 
	 * Use a function to get the minimum of the content that should be poured.
	 */
	public void pourFrom (Jug jugB){
		int minQuantity = Math.min(capacity-content, jugB.content);
		content = content + minQuantity;
		jugB.content=jugB.content - minQuantity;
	}
	
	public String toString(){
		return "(" + content + "," + capacity + ")";
	}
	
}
