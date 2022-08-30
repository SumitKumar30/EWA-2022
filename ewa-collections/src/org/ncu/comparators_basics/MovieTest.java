package org.ncu.comparators_basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieTest {

	public static void main(String[] args) {
		Movie m1 = new Movie("Avengers", 3, "English", "Sci-Fi", 8, 80);
		Movie m2 = new Movie("Sholay", 2, "hindi", "Action", 9, 90);
		Movie m3 = new Movie("KGF", 3.5, "Telugu", "Action", 7, 95);
		Movie m4 = new Movie("Spiderman", 1.5, "English", "superhero", 9, 60);
		Movie m5 = new Movie("Gadar", 2, "Hindi", "Fantasy", 6, 50);
		Movie m6 = new Movie("Ms Dhoni", 2.5, "Hindi", "Documentary", 8, 70);
		Movie m7 = new Movie("RRR", 3.5, "Telugu", "Action", 9, 90);
		
		List<Movie> movieList = new ArrayList<>();
		movieList.add(m1);
		movieList.add(m2);
		movieList.add(m3);
		movieList.add(m4);
		movieList.add(m5);
		movieList.add(m6);
		movieList.add(m7);
		
		System.out.println("List of movies: "+movieList);
		
		List<String> list = new ArrayList<String>();
		list.add("John");
		list.add("Raman");
		list.add("James");
		list.add("Harold");
		list.add("Carter");
		
		System.out.println("List of names: "+list);
		
		Collections.sort(list);
		
		System.out.println("Sorted list: "+list);
		
		Collections.sort(movieList);
		
		System.out.println("Sorted list of movies: "+movieList);
 		
	}

}
