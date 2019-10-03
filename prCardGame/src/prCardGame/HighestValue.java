/*
 * Esteban J. Palomo Ferrer
 * Paralelo X
 * 1234567890
 */
package prCardGame;
import prCardGame.Card;
import prCardGame.Pack;

public class HighestValue {

	public static void main(String[] args) {
		int winsA = 0;
		int winsB = 0;
		int valueA,valueB;
		Card playerA, playerB;
		
		Pack pack = new Pack();
		pack.shuffle();
		
		for (int round = 1; round <= 3; round ++){
			playerA = pack.dealCard();
			playerB = pack.dealCard();
			valueA = playerA.value();
			valueB = playerB.value();
			
			if (valueA > valueB){
				winsA++;
			}
			if (valueA < valueB){
				winsB++;
			}
			System.out.println("Round " + round + ": A has " + valueA + " and B has " + valueB);
		}
		if (winsA > winsB){
			System.out.println("Player A won");
		}else if (winsA < winsB){
			System.out.println("Player B won");
		}else
			System.out.println("It is a match");
		
	}

}
