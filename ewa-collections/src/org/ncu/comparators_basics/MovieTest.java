package org.ncu.comparators_basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieTest {

	public static void main(String[] args) {
		Movie m1 = new Movie("Avengers", 3, "English", "Sci-Fi", 8, 80);
		Movie m2 = new Movie("Sholay", 2, "hindi", "Action", 9, 90);
		Movie m3 = new Movie("KGF", 3.5, "Telugu", "Action", 7, 95);
		Movie m4 = new Movie("Spiderman", 1.5, "English", "superhero", 9.5, 60);
		Movie m5 = new Movie("Gadar", 2, "Hindi", "Fantasy", 6, 50);
		Movie m6 = new Movie("Ms Dhoni", 2.5, "Hindi", "Documentary", 7.5, 70);
		Movie m7 = new Movie("RRR", 3.5, "Telugu", "Action", 10, 90);
		
		List<Movie> movieList = new ArrayList<>();
		movieList.add(m1);
		movieList.add(m2);
		movieList.add(m3);
		movieList.add(m4);
		movieList.add(m5);
		movieList.add(m6);
		movieList.add(m7);
		
		System.out.println("List of movies: "+movieList);
		
		/*
		 * List<String> list = new ArrayList<String>(); list.add("John");
		 * list.add("Raman"); list.add("James"); list.add("Harold"); list.add("Carter");
		 * 
		 * System.out.println("List of names: "+list);
		 * 
		 * Collections.sort(list);
		 * 
		 * System.out.println("Sorted list: "+list);
		 */
		
		RatingComparator rating = new RatingComparator();
		NameComparator name = new NameComparator();
		
		/* using anonymous comparator class inside Collections.sort() */
		Collections.sort(movieList, new Comparator<Movie>() {
			public int compare(Movie o1, Movie o2) {
				if(o1.getDuration() < o2.getDuration()) {
					return -1;
				}else if(o1.getDuration() > o2.getDuration()) {
					return +1;
				}else 
					return 0;
			}
		});
		
		//Collections.sort(movieList, name);
		
		//System.out.println("Sorted list of movies: "+movieList);
		for(Movie movie : movieList) {
			System.out.println(movie);
		}
 		
	}

}
