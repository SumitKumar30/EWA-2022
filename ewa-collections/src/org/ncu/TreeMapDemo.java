package MapPrograms;

import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeMap<Integer,String> tree = new TreeMap<>();
		tree.put(5, "Play");
		tree.put(2, "Study");
		tree.put(4, "Walk");
		tree.put(6, "Sleep");
		tree.put(1, "Exercise");
		tree.put(3, "Shopping");
		
		System.out.println("Vlaues inside TreeMap are: "+tree);
		
		System.out.println("First Key inside TreeMap is: "+tree.firstKey());
		
		System.out.println("Last Key inside TreeMap is: "+tree.lastKey());
		
		System.out.println("First Entry inside TreeMap is: "+tree.firstEntry());
		
		System.out.println("Last Entry inside TreeMap is: "+tree.lastEntry());
		
//		System.out.println("Poll first Entry inside TreeMap: "+tree.pollFirstEntry());
//		
//		System.out.println("Poll last Entry inside TreeMap: "+tree.pollLastEntry());
//		
//		System.out.println("Updated Tree Map is: "+tree.entrySet());
//		
		// use the following methods: 
		// 1. ceilingkey()
		// 2. floorkey()
		// 3. higherKey()
		// 4. higherEntry()
		// 5. lowerKey()
		// 6. lowerEntry()
		// 7. floorEntry()
		// 8. ceilingEntry()
		
		System.out.println("Values inside ceiling key are: "+tree.ceilingKey(2));
		System.out.println("Values inside lower key are: "+tree.lowerKey(5));
		System.out.println("Values inside floor key are: "+tree.floorKey(2));
		System.out.println("Values inside higher key are: "+tree.higherKey(5));
		
	}

}
