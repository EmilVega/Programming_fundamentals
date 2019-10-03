/*
 * Esteban J. Palomo Ferrer
 * Paralelo X
 * 1234567890
 */
package prCardGame;
import prCardGame.Pack;
import prCardGame.SevenAndAHalfHand;

/**
 * Simple version of the game Seven And A Half
 */
public class SevenAndAHalf {
	public static void main(String[] args) {
		//The pack, and the players are created
		Pack pack = new Pack();
		SevenAndAHalfHand player = new SevenAndAHalfHand();
		SevenAndAHalfHand dealer = new SevenAndAHalfHand();
		
		//The initial cards are dealt: one Player and one to Banker
		player.addCard(pack.dealCard());
		dealer.addCard(pack.dealCard());
		
		//Player asks for cards according to his/her strategy
		while(player.totalPoints()<=5){
			System.out.println("The player asks for an extra card");
			player.addCard(pack.dealCard());
		}
		
		//Dealer stays if player's total exceeds 7.5 (he has busted); otherwise he/she asks for cards
		if(player.totalPoints()<=7.5){ //the player does not exceed 7.5
			while(dealer.totalPoints()<7.5 && dealer.totalPoints()<player.totalPoints()){
				System.out.println("The dealer asks for an extra card");
				dealer.addCard(pack.dealCard());
			}
		}
		//The totals are computed and the winner is announced
		double pointsP = player.totalPoints();
		double pointsD = dealer.totalPoints();
		
		if(pointsP<=7.5 && (pointsD>7.5 || pointsP>pointsD)){
			System.out.println("The player wins with "+player+" ("+ pointsP+" points). The dealer has "+ dealer+" ("+pointsD+" points)");
		}else if (pointsD<=7.5){
			System.out.println("The dealer wins with "+dealer+" ("+ pointsD+" points). The player has "+ player+" ("+pointsP+" points)");
		}else{
			System.out.println("It is a match: player "+ player+" ("+pointsP+" points) and dealer "+ dealer +" ("+pointsD+" points) have busted!!");
		}
	}
}
