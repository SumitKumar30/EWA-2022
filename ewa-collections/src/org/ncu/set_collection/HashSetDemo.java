package org.ncu.set_collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {
//		 1. Create a hashset object
		Set<String> set1 = new HashSet<String>();
		set1.add("Tesla");
		set1.add("Suzuki");
		set1.add("Mahindra");
		set1.add("Tata");
		set1.add("Hyundai");
		set1.add("Toyota");
		set1.add("Honda");
		set1.add("Tata");
		
		System.out.println("Set of cars: "+set1);
		
		Set<String> set2 = new HashSet<String>();
		set2.add("Ducati");
		set2.add("Kawasaki");
		set2.add("Harley Davidson");
		set2.add("Royal Enfield");
		set2.add("TVS");
		set2.add("Bajaj");
		set2.add("Hero");
		set2.add("Suzuki");
		set2.add("Honda");
		
		System.out.println("Set of bikes: "+set2);
		
		/* union of two sets */
		/*
		 * set1.addAll(set2);
		 * 
		 * System.out.println("Union of two sets: "+set1);
		 */
		
		/* intersection of two sets */
		
		/*
		 * set1.retainAll(set2);
		 * 
		 * System.out.println("Intersection of two sets: "+set1);
		 */
		/*set1.removeAll(set2);
		
		System.out.println("Difference of two sets: "+set1);*/
		
		// System.out.println("Hashcode for set1 is: "+set1.hashCode());

	}

}
