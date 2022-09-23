package MapPrograms;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer, String> tree = new TreeMap<>(); 
		
		tree.put(105, "John");
		tree.put(1894, "Harry");
		tree.put(547, "Harold");
		tree.put(325, "Michael");
		tree.put(987, "Virat");
		tree.put(614, "Rahul");
		tree.put(587, "Anushka");
		tree.put(101, "Kapil");
		
		System.out.println("Names inside TreeMap: "+tree);
		
		System.out.println("Smallest record : "+tree.firstEntry());
		
		// returns greatest key less than the given value
		System.out.println("Floor Entry : "+tree.floorEntry(598)); 
		
		// returns the least key greater than the given value
		System.out.println("Ceiling Entry: "+tree.ceilingEntry(598));
		
		Iterator<Entry<Integer,String>> itr = tree.entrySet().iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next()+" ");
		}
		
		// return all the keys less than the given key 
		System.out.println("Head Map of the record: "+tree.headMap(614));
		
		System.out.println("Tail Map of the record: "+tree.tailMap(614));
		
	}

}
