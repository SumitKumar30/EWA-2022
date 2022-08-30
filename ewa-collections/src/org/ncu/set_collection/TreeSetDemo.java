package SetPrograms;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> tree1 = new TreeSet<>();
		
		tree1.add(8);
		tree1.add(5);
		tree1.add(12);
		tree1.add(3);
		tree1.add(16);
		tree1.add(6);
		tree1.add(25);
		tree1.add(4);
		tree1.add(2);
		tree1.add(7);
		
		System.out.println("Elements inside TreeSet are: "+tree1);
		
		Iterator<Integer> itr = tree1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		tree1.remove(5);
		
		System.out.println("Updated tree is: "+tree1);
		
	}

}
