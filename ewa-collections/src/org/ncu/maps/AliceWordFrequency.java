package MapPrograms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//import java.util.TreeMap;

public class AliceWordFrequency {

	public static void main(String[] args)throws FileNotFoundException {
		// TODO Auto-generated method stub
		Map<String, Integer> frequencies = new HashMap<>();
		File file = new File("C:\\Users\\lenovo\\eclipse-workspace\\CollectionsFramework\\src\\MapPrograms\\","alice_in_wonderland.txt");
		Scanner sc = new Scanner(file);
		while( sc.hasNext() ) { 
				String word = sc.next().toLowerCase();
				
				String w = "";
				
				for(int i = 0; i < word.length(); i++) {
					char c = word.charAt(i);
					if(Character.isLetter(c))
							w = w + c;
				}
				Integer count = null;
				// Get the old frequency count mapped to given key
				if(frequencies.containsKey(w)) {
					 count = frequencies.get(w);
					
					// If there was none put 1; otherwise, increment the count
					if (count == null) { count = 1; }
					else { count = count + 1; }
					frequencies.put(w, count);
				}else {
					count = 1;
					frequencies.put(w, count);
				}
									
		}
		// Print all words and counts
		for (String key : frequencies.keySet()) {
			System.out.printf("%-20s%10d\n", key, frequencies.get(key));
		}
		sc.close();
	}

}
