/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prCardGame;

/**
 * This class is inherited of Hand
 * @author emil
 *
 */
public class BaccaratHand extends Hand {
	
	/**
	 * This constructor initializes a hand with limit 3 cards per hand
	 */
	public BaccaratHand(){
		super(3);
	}
	
	public double totalPoints(){
		double tP=0;
		for(int i=0;i<numberCards();i++){
			if(cards[i].value()>=1 && cards[i].value()<=9){
				tP+=cards[i].value();
			}
		}
		return tP/10;
	}
	
	/**
	 * This method allows to know if the total point is natural or not
	 * @return a boolean value
	 */
	public boolean isNatural(){
		return (totalPoints()==8 || totalPoints()==9);
	}
		
}
