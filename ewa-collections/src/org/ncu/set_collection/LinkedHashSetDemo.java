package org.ncu.set_collection;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
		
		// create a linked hashset object
		Set<Integer> linkSet = new LinkedHashSet<Integer>();
		
		linkSet.add(125);
		linkSet.add(45);
		linkSet.add(68);
		linkSet.add(87);
		linkSet.add(12);
		linkSet.add(96);
		linkSet.add(52);
		
		System.out.println("Elments inside linked set are: "+linkSet);
		
		linkSet.forEach((Integer values) ->{
			System.out.println(values);
		});
		
		System.out.println("Set contains element: "+linkSet.contains(87));

	}

}
