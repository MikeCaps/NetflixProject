package netflixpkg;
import java.util.*;
import java.io.*;
public class Show extends NetflixItem{
	
	//variables
	private String seriesTitle;
	private int epNumber;
	
	//constructors
	public Show(String newTitle, int newNumber) {
		super( );
		seriesTitle = newTitle;
		epNumber = newNumber;
	}
	
	public Show() {
		super();
	}

	//methods
	public String getSeriesTitle() {
		return seriesTitle;
	}

	public void setSeriesTitle(String seriesTitle) {
		this.seriesTitle = seriesTitle;
	}

	public int getEpNumber() {
		return epNumber;
	}

	public void setEpNumber(int epNumber) {
		this.epNumber = epNumber;
	}

	public int getPriority() {
		return super.getPriority();
	}
	
	@Override
	public String toString() {
		return "Show  [Priority: " + super.getPriority() + ""
				+ "\t" + "Year: " + super.getYear() + "\t" + "Episode No: " + epNumber + "\t " + "Title: " 
				+ seriesTitle + "\t" + "Series Title: " + super.getTitle() + "]";
	}

	
}