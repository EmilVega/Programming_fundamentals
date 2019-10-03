/*
 * Esteban J. Palomo Ferrer
 * Paralelo X
 * 1234567890
 */
package prCardGame;
import prCardGame.BaccaratHand;
import prCardGame.Pack;

/**
 * Simple version of Baccarat
 */
public class Baccarat {
	public static void main(String[] args) {
		Pack p = new Pack();
		BaccaratHand player = new BaccaratHand();
		BaccaratHand dealer = new BaccaratHand();

		// Two cards for the player
		player.addCard(p.dealCard());
		player.addCard(p.dealCard());
		// Two cards for the dealer
		dealer.addCard(p.dealCard());
		dealer.addCard(p.dealCard());

		if (player.isNatural()) {
			System.out.println("The player wins with a natural hand");
		} else if (dealer.isNatural()) {
			System.out.println("The dealer wins with a natural hand");
		} else {
			// The player plays
			if (!stayPlayer(player)) {
				System.out.println("The player asks for an extra card");
				player.addCard(p.dealCard());
			}
			// The dealer plays
			if (!stayDealer(dealer, player)) {
				System.out.println("The dealer asks for a card");
				dealer.addCard(p.dealCard());
			}
			// The total points are computed and the winner is announced
			double pointsJ = player.totalPoints();
			double pointsB = dealer.totalPoints();
			if (pointsJ == pointsB) {
				System.out.println("It is a match!! : " + pointsJ + " points: "
						+ player + " vs. " + dealer);
			} else if (pointsJ > pointsB) {
				System.out.println("The player wins with " + player + " ("
						+ pointsJ + " points). The dealer has " + dealer + " ("
						+ pointsB + " points)");
			} else {
				System.out.println("The dealer wins with " + dealer + " ("
						+ pointsB + " points). The player has " + player + " ("
						+ pointsJ + " points)");
			}
		}
	}

	/**
	 * The player's strategy
	 */
	private static boolean stayPlayer(BaccaratHand p) {
		return (p.totalPoints() > 5);
	}

	/**
	 * The dealer's strategy
	 */
	private static boolean stayDealer(BaccaratHand d, BaccaratHand p) {
		double pointsP = p.totalPoints();
		double pointsD = d.totalPoints();
		return (pointsD >= pointsP || pointsD == 9);
	}
}
