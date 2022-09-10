package class_exercise;

public class SquareThread implements Runnable {
	int random;
	//Thread t;
	
	public SquareThread(int random) {
		this.random = random;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName("Carl");
		System.out.println(Thread.currentThread().getName()+" is printing the Square of the random value: "+(this.random * this.random));
	}

}
