package org.ncu.priorityqueue;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		
		Queue<Integer> pqueue = new PriorityQueue<Integer>();
		
		// Adding elements into priority - queue
		pqueue.add(564);
		pqueue.add(789);
		pqueue.add(118);
		pqueue.add(86);
		pqueue.add(876);
		pqueue.add(56);
		pqueue.add(457);
		
		//System.out.println("element with highest priority: "+pqueue.remove());
		
		System.out.println("Elements inside updated Integer queue: "+pqueue);
		
		Queue<String> squeue = new PriorityQueue<String>();
		
		squeue.add("Iron Man");
		squeue.add("Spiderman");
		squeue.add("Batman");
		squeue.add("Captain America");
		squeue.add("Superman");
		squeue.add("Thor");
		squeue.add("Deadpool");
		squeue.add("Dr. Strange");
		
		System.out.println("-----------Superheroes in prioriry queueu-------- ");
		
		Iterator<String> itr = squeue.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("Element at the top is: "+squeue.peek());
		
		squeue.offer("Black Panther");
		
		System.out.println("Updated queue : "+squeue);
		
		System.out.println("Element removed from PQ: "+squeue.poll());
		
		System.out.println("Updated queue after removing root element: "+squeue);

	}

}
