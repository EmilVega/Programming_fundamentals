package prBankException;

public class TestBank {

	public static void main(String[] args) {

		try{
			Bank b = new Bank("TubbiesBank", 5);
			int nPo = b.openAccount("Po", 500);
			int nDixy = b.openAccount("Dixy", 500);
			int nTinkyWinky = b.openAccount("Tinky Winky", 500);
			int nLala = b.openAccount("Lala", 500);
			System.out.println(b);
			b.deposit(nPo, 100);
			b.withdraw(nDixy, 100);
			b.transfer(nTinkyWinky, nLala, 100);
			System.out.println(b);
			b.closeAccount(nPo);
			b.deposit(nDixy,200);
			System.out.println(b);
		}catch(BankException e){
			System.out.println(e.getMessage());
		}

	}

}
