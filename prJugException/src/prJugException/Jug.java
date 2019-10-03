/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */


package prJugException;

/**
 * This class create a jug with a capacity 
 * @author emil
 *
 */
public class Jug {
	private int content;
	private final int capacity;

	/**
	 * It allows to create a jug with a limit of capacity
	 * @param cap
	 * It is the capacity of a jug
	 * @throws JugCapacityException
	 */
	public Jug (int cap) throws JugCapacityException{
		if (cap<=0){
			throw new JugCapacityException("The capacity should be a number greater than zero");
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
	
	/**
	 * It allows to fill a jug
	 */
	public void fill(){
		content=capacity;
	}
	
	public void empty (){
		content=0;
	}
	
	
	/**
	 * It allows pour the content of a jug to another.
	 * Use a function to get the minimum of the content that should be poured.
	 * @param jugB
	 * It is a second jug
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
