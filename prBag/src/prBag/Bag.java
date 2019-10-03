/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prBag;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * It has objects that contain white and black balls
 * @author emil
 *
 */
public class Bag {
	public enum BallColor{WHITE, BLACK}
	private static Random randv = new Random();
	private int blacks;
	private int whites;
	
	/**
	 * It creates a new object bag with a specific quantity of black and white balls 
	 * @param blacks
	 * It is the number of black balls
	 * @param whites
	 * It is the number of white balls
	 */
	public Bag (int blacks, int whites){
		if (blacks<0 || whites <0){
			throw new IllegalArgumentException ("A negative number of balls are not allowed");
		}
		this.blacks=blacks;
		this.whites=whites;
	}
	
	/**
	 * It allows to get the total number of balls in the bag
	 * @return a number
	 */
	public int getTotalBalls(){
		return blacks + whites;
	}
	
	/**
	 * It allows to extract a ball from the bag and check its color
	 * @return
	 * The color of the ball extracted
	 */
	public BallColor extractBall(){
		if(getTotalBalls()==0){
			throw new NoSuchElementException("The bag is empty");
		}
		int r = 1+ randv.nextInt(getTotalBalls()); //rnd.nextInt(HASTA-DESDE+1)+DESDE
		if (r<=whites){
			whites--;
			return BallColor.WHITE;
		}else{
			blacks--;
			return BallColor.BLACK;
		}
	}
	
	/**
	 * It puts a white ball in the bag
	 */
	public void putWhite(){
		whites++;
	}
	
	/**
	 * It puts a black ball in the bag
	 */
	public void putBlack(){
		blacks++;
	}
	
}
