/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prCardGame;

/**
 * This class is abstract, allows to create a hand of cards
 * @author emil
 *
 */
abstract public  class Hand {
	protected int numCards;
	private static final int LIMIT = 20;
	protected Card [] cards;
	
	/**
	 * This constructor creates a hand of cards where the limit of cards s 20
	 */
	public Hand (){
		this(LIMIT);
	}
	
	/**
	 * This constructor creates a hand of cards where the limit is given by a parameter
	 * @param newLimit 
	 * This is the limit of cards in a hand given by the user
	 */
	public Hand (int newLimit){
		numCards=0;
		cards= new Card[newLimit];
	}
	
	/**
	 * This method discard all cards
	 */
	public void discardAll(){
		numCards=0;
	}

	/**
	 * This method adds a card given by a parameter
	 * @param newCard 
	 * This is the new card to add.
	 */
	public void addCard(Card newCard){
		if (cards.length==numCards){
			throw new RuntimeException ("The hand is full");
		}
		cards[numCards]= newCard;
		numCards++;
	}
	
	/**
	 * @return the number of cards in a hand
	 */
	public int numberCards(){
		return numCards;
	}
	
	/**
	 * Is an abstract method
	 * @return the total of points in a hand
	 */
	abstract public double totalPoints();

	public String toString(){
		String content="";
		for(int i=0;i<numCards;i++){
			content+=cards[i]+" ";
		}
		return "("+numCards+","+content+")";
	}
}
