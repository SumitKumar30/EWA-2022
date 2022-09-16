package joins;

public class ReverseHello extends Thread{
	private int count;
	
	public ReverseHello(int count) {
		this.count = count;
	}
	
	public void run() {
		count++;
		if(count <= 50) {
			ReverseHello reverse = new ReverseHello(count);
			reverse.start();
			try {
				reverse.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Hello from "+Thread.currentThread().getName());
	}
}
