package joins;

public class FirstThread implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" running!");
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+" executing for "+i+" times...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
