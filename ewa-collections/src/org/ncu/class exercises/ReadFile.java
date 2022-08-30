package ArraylistPrograms;
import java.util.ArrayList;
import java.util.ListIterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class ReadFile {

	public static void main(String[] args)throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> words = new ArrayList<>();
		File file = new File("C:\\Users\\lenovo\\eclipse-workspace\\CollectionsFramework\\src","dummy.txt");
		System.out.println("File path is: "+file.getCanonicalPath());
//		String path = file.getCanonicalPath();
		Scanner sc = new Scanner(file);
		while(sc.hasNext()) {
			String str = sc.next();
			words.add(str);
		}
		
		System.out.println(words);
		
		System.out.println("Size of the list is: "+words.size());
		
		ListIterator<String> itr = words.listIterator(words.size());
		while(itr.hasPrevious()) {
			System.out.print(itr.previous()+" ");
		}
		System.out.println();
		System.out.println("------List with all the plurals---------");
		while(itr.hasNext()) {
			String plural = itr.next();
			if(plural.endsWith("s"))
				System.out.println(plural);
		}
		
		System.out.println("-------List after removing plurals-----");
		while(itr.hasPrevious()) {
			String plural = itr.previous();
			if(plural.endsWith("s")) {
				itr.remove();
			}
			
		}
		System.out.println("Size of the list is: "+words.size());
		sc.close();
		
	}

}
