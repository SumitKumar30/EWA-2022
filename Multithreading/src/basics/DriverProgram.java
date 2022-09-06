package basics;

public class DriverProgram {

	public static void main(String[] args) throws InterruptedException {
		
		/* creating a new thread */
		MyThread thread1 = new MyThread("Harry");
		
		/* starting the new thread object */
		thread1.start();
		
		
		/* creating a thread using runnable */
		MyRunnable thread2 = new MyRunnable();
		Thread t2 = new Thread(thread2);
		
		/* start a runnable thread */
		t2.start();
		
		String name = Thread.currentThread().getName();
		
		for(int i = 0; i < 5; i++) {
			System.out.println(name+" thread executing for "+i+" times");
			Thread.sleep(3000);
		}
		
		System.out.println(name+" thread exiting.....!");
	}

}
