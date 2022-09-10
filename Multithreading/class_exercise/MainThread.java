package class_exercise;

public class MainThread {

	public static void main(String[] args) {
		RandomThread random = new RandomThread();
		Thread thread = new Thread(random);
		
		thread.start();

	}

}
