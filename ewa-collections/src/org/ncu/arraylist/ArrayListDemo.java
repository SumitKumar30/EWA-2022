/* 1. Traverse  
 * 2. Add/Insert
 * 3. Delete/Remove
 * 4. Update
 * 5. Search
 * 6. Size/length
 *  */

package org.ncu.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("Microsoft");
		list.add("Amazon");
		list.add("flipkart");
		list.add("Paytm");
		list.add("Tesla");
		list.add("Netflix");
		list.size();
		
		list.add(1, "Apple");
		
		System.out.println("List of companies: "+list);
		
		list.remove(1);
		
		System.out.println("updated list of companies: "+list);
		
		System.out.println("company at index 5 is: "+list.get(5));
		
		list.set(5, "Amazon Prime");
		
		System.out.println("Updated list: "+list);
		
		
		// 1. using simple for loop
		/*
		 * for(int i = 0; i < list.size(); i++) { System.out.println(list.get(i)); }
		 */
		
		// 2. using for-each loop
		for(String str : list) {
			System.out.println(str);
		}
		
		/*
		 * list.clear();
		 * 
		 * System.out.println("List is emptied: "+list);
		 */
		
		System.out.println("List contains Tesla: "+list.contains("Netflix"));
		
		ArrayList<String> list2 = new ArrayList<>();
		
		list2 = (ArrayList<String>) list.clone();
		
		list.add("Tata");
		
		System.out.println("Cloned list is: "+list2);
		
		System.out.println("====== Traversal through Iterator =====");
		
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			System.out.print(itr.next()+" , ");
		}
		
		System.out.println();
		
		System.out.println("====== Traversal in Reverse Direction =======");
		
		ListIterator<String> listItr = list.listIterator(list.size());
		
		while(listItr.hasPrevious()) {
			System.out.print(listItr.previous()+" ");
		}
	}

}
