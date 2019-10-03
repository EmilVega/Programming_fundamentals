/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prBag;

import java.util.NoSuchElementException;

/**
 * It is a test of a class Bag
 * @author emil
 *
 */
public class TestBag {
	
	
	public static void main(String[] args) {
		try {
			Bag myBag = new Bag(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

			while (myBag.getTotalBalls()>1){
				Bag.BallColor ball1 = myBag.extractBall();
				Bag.BallColor ball2 = myBag.extractBall();
				if (ball1==ball2){
					myBag.putWhite();
				}else{
					myBag.putBlack();
				}
			}
			System.out.println(myBag.extractBall());

		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Not enough arguments");
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}

	}

}
