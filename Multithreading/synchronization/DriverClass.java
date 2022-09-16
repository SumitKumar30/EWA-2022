package synchronization;

public class DriverClass {

	public static void main(String[] args) {
		// create threads for Ryan and Monika
		
		BankAccount account = new BankAccount();
		
		RyanAndMonica ryan = new RyanAndMonica(account);
		RyanAndMonica monika = new RyanAndMonica(account);
		
		Thread t1 = new Thread(ryan, "Ryan");
		Thread t2 = new Thread(monika, "Monica");
		
		// start the threads
		t1.start();
		t2.start();
	}

}
