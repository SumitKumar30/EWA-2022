package communication;

public class InterThreadDemo {

	public static void main(String[] args) {
		ProducerConsumer p = new ProducerConsumer();
		Thread t1 = new Thread(p, "Ryan");
		Thread t2 = new Thread(p, "Monica");
		t1.start();
		t2.start();
	}

}
