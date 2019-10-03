/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prCardGame;

import java.util.Random;

/**
 * Class Pack of cards
 * @author emil
 *
 */
public class Pack {
	private static Random randv = new Random();
	private int numCards;
	private Card [] pack;
	
	/**
	 * This creates a full French Pack of cards
	 */
	public Pack(){
		numCards=0;
		pack= new Card[52];
		for (Card.CardSuit suit: Card.CardSuit.values()){
			for (int i=1;i<=13;i++){
				pack[numCards]=new Card(i,suit);
				numCards++;
			}
		}
		shuffle();
	}
	
	/**
	 * This methods allows to shuffle the cards
	 */
	public void shuffle (){
		for (int i=0;i<numCards;i++){
			int r = randv.nextInt(numCards); //rnd.nextInt(HASTA-DESDE+1)+DESDE
			Card c = pack[r];
			pack[r] = pack[i];
			pack[i] = c;
		}		
	}
	
	/**
	 * @return the number of cards in a pack
	 */
	public int numberCards(){
		return numCards;
	}
	
	/**
	 * This method allows to deal the cards 
	 * @return a card from a pack of cards
	 */
	public Card dealCard(){
		if(numCards==0){
			throw new RuntimeException("The pack is empty");
		}
		numCards--;
		return pack[numCards];
	}
}
