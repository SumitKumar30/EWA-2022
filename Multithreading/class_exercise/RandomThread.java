package class_exercise;

public class RandomThread implements Runnable {
	//Thread t;
	@Override
	public void run() {
		Thread.currentThread().setName("John");
		for(int i = 0; i <5; i++) {
			// generate a random value
			
			int random = (int)(Math.random()*100);
			
			System.out.println(Thread.currentThread().getName()+" has generated a random value: "+random);
			
			// if the random value is an even no.
			if(random % 2 == 0) {
				// create a new  Square thread and assign it the random value generated
				SquareThread square = new SquareThread(random);
				Thread thread = new Thread(square);
				thread.start();
			}else {
				System.out.println(Thread.currentThread().getName()+" has generated an odd no.: "+random);
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 

	}

}
