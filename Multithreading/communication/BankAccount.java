package communication;

public class BankAccount {
	private int balance;
	
	public BankAccount(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	synchronized void makeWithdrawl(int amount) {
		System.out.println("Available Balance: "+this.getBalance()+"$");
		System.out.println(Thread.currentThread().getName()+" is going to withdraw "+amount+"$");
		while(this.getBalance() < amount) {
			System.out.println("Insufficient balance!! waiting for deposit...");
			try {
				// thread goes into the waiting state
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.balance = this.getBalance() - amount;
		System.out.println(amount+"$ withdrawn successfully by "+Thread.currentThread().getName());
		System.out.println("Updated Balance amount after withdraw: "+this.getBalance()+"$");
	}
	
	synchronized void makeDeposit(int amount) {
		System.out.println(Thread.currentThread().getName()+" is going to deposit "+amount+"$");
		this.balance = this.getBalance() + amount;
		System.out.println(amount+"$ Deposited Successfully!!");
		System.out.println("Updated Balance amount after deposit: "+this.getBalance()+"$");
		// notify the waiting thread to resume withdraw operation
		notify();
	}
}
