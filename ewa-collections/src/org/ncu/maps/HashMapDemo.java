package org.ncu.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapDemo {

	public static void main(String[] args) {
		// create a hashmap object
		Map<Integer, String> map1 = new HashMap<Integer, String>();
		map1.put(1001, "Apple");
		map1.put(1002, "Microsoft");
		map1.put(1003, "Tesla");
		map1.put(1005, "Amazon");
		map1.put(1004, "Paytm");
		map1.put(1009, null);
		
		System.out.println("Values inside hashmap are: "+map1);
		
		System.out.println("Values inside hashmap in entryset: "+map1.entrySet());

		System.out.println("Keys inside hashmap in keyset: "+map1.keySet());
		
		System.out.println("Values inside hashmap are: "+map1.values());
		
		/*
		 * System.out.println("======Traversal using Iterator=====");
		 * 
		 * Iterator<Entry<Integer, String>> itr = map1.entrySet().iterator();
		 * 
		 * while(itr.hasNext()) { System.out.println(itr.next()); }
		 */
		
		
		/*
		 * Iterator<Integer> keysItr = map1.keySet().iterator();
		 * 
		 * 
		 * 
		 * while(keysItr.hasNext()) {
		 * 
		 * }
		 */
		
		System.out.println("======Traversal using for-each=====");
		
		map1.putIfAbsent(1009, "Meta");
		
		for(Entry<Integer, String> entry : map1.entrySet()) {
			System.out.println(entry);
		}
		
		
		for(int keys : map1.keySet()) {
			System.out.println(map1.get(keys));
		}
		
		
		
		/*
		 * for(String val : map1.values()) { System.out.println(val); }
		 */
		
		
	}

}
