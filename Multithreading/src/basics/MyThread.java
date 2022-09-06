package basics;

public class MyThread extends Thread{
	String threadName;

	public MyThread(String threadName) {
		//super();
		this.threadName = threadName;
	}
	
	
	 public void run(){
		 Thread.currentThread().setName(threadName);
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" thread executing for "+i+" times");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Exiting the "+Thread.currentThread().getName()+" thread!");
	}
	
}
