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
public class SevenAndAHalfHand extends Hand{
	
	/**
	 * This constructor initializes a hand with limit 3 cards per hand
	 */
	public SevenAndAHalfHand(){
		super();
	}
	
	public double totalPoints(){
		double tP=0;
		for(int i=0;i<numberCards();i++){
			if(cards[i].value()>=1 && cards[i].value()<=7){
				tP+=cards[i].value();
			}
			if (cards[i].value()>=11 && cards[i].value()<=13){
				tP+=0.5;
			}
		}
		return tP;
	}
}
