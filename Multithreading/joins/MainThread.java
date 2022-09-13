package joins;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {
		// creating thread objects
		
		FirstThread first = new FirstThread();
		SecondThread second = new SecondThread();
		
		Thread t1 = new Thread(first);
		Thread t2 = new Thread(second);
		
		// start the threads
		t1.start();
		
		// join will ensure thread t1 executes for 1 second before starting the second thread t2
		t1.join(1000);
		
		t2.start();
		
		t2.join();
		
		System.out.println("Main thread exiting...");

	}

}
