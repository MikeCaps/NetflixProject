package netflixpkg;

public class NetflixItem {
	
	//variables
	private String title;
	private int year, priority;
	
	//constructors
	
	public NetflixItem(String newTitle, int newYear, int newPriority) {
		title = newTitle;
		year = newYear;
		priority = priority;
	}
	
	public NetflixItem() {
		
	}
	
	//methods
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "NetflixItem [title=" + title + ", year=" + year + ", priority=" + priority + "]";
	}
	
	
	
	//methods
	

}
