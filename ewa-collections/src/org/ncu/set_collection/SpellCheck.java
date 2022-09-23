package SetPrograms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class SpellCheck {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashSet<String> dictionary = new HashSet<>();
		File file = new File("C:\\Users\\lenovo\\eclipse-workspace\\CollectionsFramework\\src\\SetPrograms\\","dictionary.txt");
		Scanner sc = new Scanner(file);
		while( sc.hasNext() ) { 
				dictionary.add(sc.next());
		}
//		sc.close();
		File file2 = new File("C:\\Users\\lenovo\\eclipse-workspace\\CollectionsFramework\\src\\SetPrograms\\","words.txt");
		sc = new Scanner(file2);
		
		System.out.println("Mispelled Words are: ");
		
		while(sc.hasNext()) {
			String token = sc.nextLine();
			if(token.length() > 1 && !dictionary.contains(token.toLowerCase()))
					System.out.println(token);
		}
				
		
//		while( sc.hasNextLine() )
//		{
//			String[] tokens = sc.nextLine().split("\\W");
//			for(String token : tokens)
//			   if (token.length() > 1 && !dictionary.contains(token.toLowerCase()))
//			      System.out.println(token);
//		}

	
	}

}
