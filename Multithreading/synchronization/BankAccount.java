package synchronization;

public class BankAccount {
	private int balance;
	
	public BankAccount() {
		this.balance = 100;		// initial balance
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int amount) {
		this.balance = amount;
	} 
	
	public void withdraw(int amount) {
		balance = balance - amount;
	}
	
	
}
