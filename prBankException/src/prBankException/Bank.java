/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prBankException;

/**
 * Bank class allows to create objects of type Bank. It has an attribute of the Account class.
 * @author emil
 *
 */
public class Bank {
	private static final int NACCS=10;
	private static final int FREEACNUM=1001;
	private String name;
	private int ffp;
	private int facn;
	private Account [] accs;

	/**
	 * Constructor to initialize the attributes
	 * @param name
	 * It is the name of the bank
	 */
	public Bank(String name){
		this(name,NACCS);
	}

	/**
	 * Constructor to initialize the attributes with the size of accounts that user wants.
	 * @param name
	 * It is the name of the bank
	 * @param size
	 * It is the size of accounts that the bank will have
	 */
	public Bank (String name, int size){
		this.name=name;
		accs= new  Account[size];
		ffp=0;
		facn=FREEACNUM;
	}

	/**
	 * This method allows to create a new account with an amount of money.
	 * @param name
	 * It is the name of the owner
	 * @param amount
	 * It is the amount of money that the account will be opened
	 * @return
	 * It returns the number of the account.
	 */
	public int openAccount(String name, double amount){
		if (ffp>=accs.length){
			Account [] newArray= new Account[accs.length*2];
			System.arraycopy(accs,0, newArray, 0, accs.length);
			accs=newArray;
		}
		accs[ffp]= new Account (name, facn, amount);
		facn++;
		ffp++;
		return accs[ffp-1].getNumber();
	}

	/**
	 * This method allows to create a new account with the amount of money equal to zero.
	 * @param name
	 * It is the name of the owner
	 * @return
	 * It returns the number of the account.
	 */
	public int openAccount(String name){
		return openAccount(name,0);
	}

	/**
	 * This method allows close an existing account.
	 * @param number
	 * It is the number of the account that will be closed
	 * @throws BankException 
	 */
	public void closeAccount (int number) throws BankException{
		
		System.arraycopy(accs,accountPosition (number)+1, accs, accountPosition (number), accs.length-(accountPosition (number)+1));
		ffp--;
	}

	/**
	 * This method allows to know the position in the array of an account through the number.
	 * @param number
	 * It is the number of the account
	 * @return
	 * The position of the account in the array
	 * @throws BankException 
	 */
	private int accountPosition (int number) throws BankException{
		boolean found = false;
		int i=0;
		while (!found && i<ffp){
			found = (accs[i].getNumber()==number);
			i++;
		}
		if (found){
			i--;
		}else{
			throw new BankException("The account number " + number +" does not exist");
		}
		return i;
	}

	/**
	 * This method allows to deposit money in an existing account
	 * @param number
	 * It is the number of the account to deposit
	 * @param amount
	 * It is the amount of money that will be deposited
	 * @throws BankException 
	 */
	public void deposit (int number, double amount) throws BankException{
		try{
			accs[accountPosition(number)].deposit(amount);
		}catch(BankException e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method allows to withdraw money in an existing account
	 * @param number
	 * It is the number of the account
	 * @param amount
	 * It is the amount of money to withdraw
	 * @return
	 * @throws BankException 
	 */
	public double withdraw( int number, double amount) throws BankException{
		try{
			accs[accountPosition(number)].withdraw(amount);

		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}catch(BankException e){
			System.out.println(e.getMessage());
		}
		return  getBalance(number);
	}

	/**
	 * This method allows to get the balance of an account.
	 * @param number
	 * It is the number of the account
	 * @return
	 * The balance of the account
	 * @throws BankException 
	 */
	public double getBalance (int number) throws BankException{
		return accs[accountPosition(number)].getBalance();
	}

	/**
	 * This method allows to transfer money between two accounts.
	 * @param numberOrig
	 * It is the number of the origin account
	 * @param numberDest
	 * It is the number of the destination account
	 * @param amount
	 * It is the amount of money to transfer
	 * @return
	 * The number of the origin account and the amount of money transfered
	 * @throws BankException 
	 */
	public double transfer (int numberOrig, int numberDest, double amount) throws BankException{
		deposit(numberDest, amount);
		return withdraw(numberOrig, amount);
	}

	public String toString(){
		String show="Banco: "+name;;
		for (int i=0;i<ffp;i++){
			show = show + "\n"+accs[i]; 
		}
		return show;
	}

}
