package communication;

public class ProducerConsumer implements Runnable {
	private BankAccount bankAccount;
	
	public ProducerConsumer() {
		bankAccount = new BankAccount(10000);
	}
	
	@Override
	public void run() {
		/*
		 * Ryan - Consumer thread 
		 * Monica - Producer thread
		 */
		if(Thread.currentThread().getName() == "Ryan") {
			bankAccount.makeWithdrawl(15000);
		}else if(Thread.currentThread().getName() == "Monica") {
			bankAccount.makeDeposit(10000);
		}
	}

}
