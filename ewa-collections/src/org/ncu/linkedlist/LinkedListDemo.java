/*1. Insertion
2. Deletion
3. Traversal
4. Updation
5. Search*/

package org.ncu.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		List<String> list = new LinkedList<String>();
		list.add("POI");
		list.add("GOT");
		list.add("Money Heist");
		list.add("Stranger Things");
		list.add("Friends");
		list.add("Big Bang Theory");
		
		System.out.println("List of web series: "+list);
		
		list.add(1, "Sherlock Holmes");
		
		System.out.println("Contains GOT "+list.contains("GOT"));
		
		System.out.println("Element deleted: "+list.remove(1));
		
		/*
		 * LinkedListDemo listDemo = new LinkedListDemo();
		 * 
		 * listDemo.setName("John Reese"); listDemo.setRoll(1001);
		 * 
		 * System.out.println("Linked List Demo: "+listDemo);
		 */
		Iterator<String> itr = list.iterator();
		
		itr.next();
		itr.next();
		/*
		 * while(itr.hasNext()){ System.out.print(itr.next()+" "); }
		 */
		
		itr.remove();
		
		System.out.println("Updated list: "+list);
		
		ListIterator<String> listItr = list.listIterator();
		
	}

}
