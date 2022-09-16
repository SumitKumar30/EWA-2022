package synchronization;

public class RyanAndMonica implements Runnable {
	private BankAccount bankAccount;
	
	public RyanAndMonica(BankAccount account) {
		this.bankAccount = account;
	}
	
	@Override
	public void run() {
		
		for(int i = 0; i < 2; i++) {
			try {
				  // critical section
				  synchronized(bankAccount){
				  		makeWithdrawl(50);
				  }
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println(Thread.currentThread().getName()+" is going for shopping!");
			if (this.bankAccount.getBalance() < 0) {
				System.out.println("overdrawn");
				break;
		}		
	 }
	}
	
	public void makeWithdrawl(int amount) throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+" is going to withdraw "+amount);
		if(this.bankAccount.getBalance() >= amount) {
			
			System.out.println(Thread.currentThread().getName()+" is going to sleep!!!");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+" woke up...");
			bankAccount.withdraw(amount);
			
			System.out.println(Thread.currentThread().getName()+" has withdrawn "+amount+" dollars");
			//System.out.println("Updated balance is: "+bankAccount.getBalance());
			
		} else {
			System.out.println("Insufficient Balance!");
		}
	}
}
