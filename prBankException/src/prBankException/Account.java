/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prBankException;

/**
 * It creates accounts
 * @author emil
 *
 */
public class Account {
	private String  owner;
	private int number;
	private double balance;
	
	/**
	 * Constructor to initialize the attributes with three arguments given for the user.
	 * @param owner
	 * It is the name of the owner of the account
	 * @param number
	 * It is the number of the account
	 * @param balance
	 * It is the balance of the account
	 */
	public Account(String owner, int number, double balance){
		this.owner=owner;
		this.number=number;
		this.balance=balance;
	}
	
	/**
	 * Constructor to initialize the attributes with two arguments given for the user.
	 * @param owner
	 * It is the name of the owner of the account
	 * @param number
	 * It is the number of the account
	 */
	public Account (String owner, int number){
		this(owner, number,0);
	}
	
	/**
	 * This method allows to deposit money in an existing account
	 * @param amount
	 * It is the amount to deposit
	 * @throws BankException 
	 */
	public void deposit (double amount) throws BankException{
		if (amount<0){
			throw new BankException("The money must to be greater than zero");
		}
		balance+=amount;
	}
	
	/**
	 * This method allows to withdraw money in an existing account
	 * @param amount
	 * It is the amount to withdraw
	 * @throws BankException 
	 */
	public void withdraw (double amount) throws BankException{
		if (amount<0){
			throw new BankException("The money must to be greater than zero");
		}
		if (amount>balance){
			throw new IllegalArgumentException("The balance can not be negative");
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
