/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prBank;

// Bank class allows to create objects of type Bank. It has an attribute of the Account class.
public class Bank {
	private static final int NACCS=10;
	private static final int FREEACNUM=1001;
	private String name;
	private int ffp;
	private int facn;
	private Account [] accs;
	
	// Constructor to initialize the attributes
	public Bank(String name){
		this(name,NACCS);
	}
	
	// Constructor to initialize the attributes with the size of accounts that user wants.
	public Bank (String name, int size){
		this.name=name;
		accs= new  Account[size];
		ffp=0;
		facn=FREEACNUM;
	}
	
	// This method allows to create a new account with an amount of money. It returns the number of the account.
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
	
	// This method allows to create a new account with the amount of money equal to zero.
	public int openAccount(String name){
		return openAccount(name,0);
	}
	
	// This method allows close an existing account.
	public void closeAccount (int number){
		System.arraycopy(accs,accountPosition (number)+1, accs, accountPosition (number), accs.length-(accountPosition (number)+1));
		ffp--;
	}
	
	// This method allows to know the position in the array of an account through the number.
	private int accountPosition (int number){
		boolean found = false;
		int i=0;
		while (!found && i<ffp){
			found = (accs[i].getNumber()==number);
			i++;
		}
		if (found){
			i--;
		}else{
			throw new RuntimeException("The given account does not exist");
		}
		return i;
	}
	
	// This method allows to deposit money in an existing account
	public void deposit (int number, double amount){
		accs[accountPosition(number)].deposit(amount);
	}
	
	// This method allows to withdraw money in an existing account
	public double withdraw( int number, double amount){
		accs[accountPosition(number)].withdraw(amount);
		return  getBalance(number);
	}
	
	// This method allows to get the balance of an account.
	public double getBalance (int number){
		return accs[accountPosition(number)].getBalance();
	}
	
	// This method allows to transfer money between two accounts.
	public double transfer (int numberOrig, int numberDest, double amount){
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
