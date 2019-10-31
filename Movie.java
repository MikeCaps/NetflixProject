package netflixpkg;
import java.util.*;
import java.io.*;

public class Movie extends NetflixItem{
	
	//variables
	private String genre;
	
	//constructors
	public Movie(String newGenre) {
		super();
		genre = newGenre;
	}
	
	public Movie() {
		
	}

	//methods
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getTitle() {
		return super.getTitle();
	}
	
	public int getYear() {
		return super.getYear();
	}
	
	public int getPriority() {
		return super.getPriority();
	}

	@Override
	public String toString() {
		return "Movie [Priority: " + super.getPriority() + ""
				+ "\t" + "Year: " + super.getYear() + "\t" + "Genre: " + genre + "\t " + "Title: " 
				+ super.getTitle() + "]";
	}
	
	

}
