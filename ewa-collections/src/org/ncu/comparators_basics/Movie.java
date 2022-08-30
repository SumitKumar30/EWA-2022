package org.ncu.comparators_basics;

public class Movie implements Comparable<Movie> {
	private String name;
	private double duration;
	private String language;
	private String genre;
	private double rating;
	private int criticScore;
	public Movie(String name, double duration, String language, String genre, double rating, int criticScore) {
		super();
		this.name = name;
		this.duration = duration;
		this.language = language;
		this.genre = genre;
		this.rating = rating;
		this.criticScore = criticScore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getCriticScore() {
		return criticScore;
	}
	public void setCriticScore(int criticScore) {
		this.criticScore = criticScore;
	}
	@Override
	public String toString() {
		return "Movie [name=" + name + ", duration=" + duration + ", language=" + language + ", genre=" + genre
				+ ", rating=" + rating + ", criticScore=" + criticScore + "]";
	}
	@Override
	public int compareTo(Movie o) {
		if(this.getRating() < o.getRating()) {
			return +1;
		}
		else if(this.getRating() > o.getRating()) {
			return -1;
		}else {
			return 0;
		}
		
	}
}
