package org.ncu.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.add("Apple");
		queue.add("Asus");
		queue.add("Samsung");
		queue.add("OnePlus");
		queue.add("Nokia");
		queue.add("Vivo");
		queue.add("Nothing");
		
		System.out.println("Elements inside queue are: "+queue);
		
		System.out.println("Element at the head of this queue: "+queue.element());

		queue.offer("Xiaomi");
		
		System.out.println("Updated queue is: "+queue);
		
		System.out.println("Element deleted from the front: "+queue.poll());
		
		queue.remove();
	}

}
