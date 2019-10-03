/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prCardGame;

/**
 * This class is a card of a French pack of cards
 * @author emil
 *
 */
public class Card {
	public enum CardSuit {SPADES, CLUBS, DIAMONDS, HEARTS}
	private CardSuit suit;
	private String [] name = {"ACE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN","J","Q","K"};
	private int value;
	
	
	/**
	 * This constructor initializes the attributes with two parameters
	 * @param value 
	 * This is the value of a card
	 * @param suit 
	 * This is the suit that belong a card (SPADES, CLUBS, DIAMONDS, HEARTS)
	 */
	public Card (int value, CardSuit suit){
		this.value=value;
		this.suit=suit;
	}
	
	/**
	 * This method allows to know the suit that belong a card
	 * @return the suit of a card
	 */
	public CardSuit  suit(){
		return suit;
	}
	
	/**
	 * @return the value of a card
	 */
	public int value(){
		return value;
	}
	
	/**
	 * @return the name of a card
	 */
	public String name(){
		return name[value-1];
	}
	
	public String toString(){
		return "("+name()+","+suit+","+value+")";
	}
}
