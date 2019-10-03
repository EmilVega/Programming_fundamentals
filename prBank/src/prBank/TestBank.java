/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prBank;

//TestBank class is the class to test the classes: Account and Bank.
public class TestBank {
	
	/*
	 * In the main method creates an object Bank which initially will have four accounts.
	 * Deposits, withdraws and transfers in these accounts will be made. 
	 * One of these accounts will be closed.
	 * The state of this Bank with its accounts will be showed. 
	 */
	public static void main(String[] args) {
		
		Bank b = new Bank("TubbiesBank", 5);
		int nPo = b.openAccount("Po", 500);
		int nDixy = b.openAccount("Dixy", 500);
		int nTinkyWinky = b.openAccount("Tinky Winky", 500);
		int nLala = b. openAccount ("Lala", 500);
		System.out.println(b);
		b.deposit(nPo, 100);
		b.withdraw(nDixy, 100);
		b.transfer(nTinkyWinky, nLala, 100);
		System.out.println(b);
		b.closeAccount(nPo);
		b.deposit(nDixy,200);
		System.out.println(b);

	}

}
