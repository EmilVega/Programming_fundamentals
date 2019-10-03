/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prBank;

//Account class allows to create objects of type Account.
public class Account {
	private String  owner;
	private int number;
	private double balance;
	
	// Constructor to initialize the attributes with three arguments given for the user.
	public Account(String owner, int number, double balance){
		this.owner=owner;
		this.number=number;
		this.balance=balance;
	}
	
	// Constructor to initialize the attributes with two arguments given for the user.
	public Account (String owner, int number){
		this(owner, number,0);
	}
	
	// This method allows to deposit money in an existing account
	public void deposit (double amount){
		if (amount<0){
			throw new RuntimeException("The money must to be greater than zero");
		}
		balance+=amount;
	}
	
	// This method allows to withdraw money in an existing account
	public void withdraw (double amount){
		if (amount<0){
			throw new RuntimeException("The money must to be greater than zero");
		}
		if (amount>balance){
			balance=0;
		}else {
			balance-=amount;
		}
		
	}
	
	public String getOwner(){
		return owner;
	}
	
	public int getNumber(){
		return number;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public String toString (){
		return "["+owner+"/"+number+" -> "+balance+"]";
	}

}
