package basics;

public class ArrayDemo {

	public static void main(String[] args) throws InterruptedException {
		String[] arr = new String[5];
		
		Thread.currentThread().setName("John");
		
		System.out.println("Name of the main thread is: "+Thread.currentThread().getName());
		
		
		
		arr[0] = "Amazon";
		arr[1] = "Facebook";
		arr[2] = "flipkart";
		arr[3] = "Microsoft";
		arr[4] = "IBM";
		//arr[5] = "Apple";
 		
		for(String val : arr) {
			Thread.sleep(2000);
			System.out.println(val);
		}

	}

}
