package joins;

public class SecondThread implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" running!");
		for(int i = 0; i < 10; i++) {
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
