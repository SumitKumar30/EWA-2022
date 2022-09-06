package basics;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		Thread.currentThread().setName("John");
			for(int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+" generating random number: "+(int)(Math.random()*100));
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Exiting the "+Thread.currentThread().getName()+" thread!");

	}

}
