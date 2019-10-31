package netflixpkg;
import java.util.*;
import java.io.*;
public class NetflixRun {
	
	//This class contains a main method to run the application, as well as several methods related to the array
	//and the menu options for the user to select from.
	
	public static void main(String[] args) throws IOException{
		
		final int LIST_SIZE = 50;
		Scanner input = new Scanner(new FileReader("list.txt"));
		Scanner kb = new Scanner(System.in);
		NetflixItem[] queue = new NetflixItem[LIST_SIZE];
		int readSize = input.nextInt();
		input.nextLine();
		read(queue, input, readSize);
		print(queue);
		System.out.println();
		System.out.println("Your menu options are: ");
		String response = " ";	
		while(!response.equalsIgnoreCase("Q")) {
			System.out.println();
			System.out.println("M = add movie " + "\n" + "S = add show" + "\n" + "L = print list" 
					+ "\n" + "V = print movies" + "\n" + "W = print shows" + "\n" + "P = print priority x" 
					+ "\n" + "Q = quit" );
			response = kb.next();
			switch(response.toUpperCase()) {
			case "M":
				if(readSize != LIST_SIZE) {
					addMovie(queue, readSize);
					System.out.println("Your new queue is:");
					print(queue);
					readSize++;
					System.out.println();
					System.out.println("You have space for " + (LIST_SIZE - readSize) + " more items.");
				}else {
					System.out.println("Your queue is full.");
				}
				break;
			case "S":
				if(readSize != LIST_SIZE) {
					addShow(queue, readSize);
					System.out.println("Your new queue is: ");
					print(queue);
					readSize++;
					System.out.println();
					System.out.println("You have space for " + (LIST_SIZE - readSize) + " more items.");
				}else {
					System.out.println("Your queue is full.");
				}
				break;
			case "L":
				print(queue);
				break;
			case "V":
				printMovies(queue);
				break;
			case "W":
				printShows(queue);
				break;
			case "P":
				System.out.println("What priority (1-5) would you like to view?");
				int priority = kb.nextInt();
				printPriority(queue, priority);
			}
		}
		System.out.println();
		//printMovies(queue);
		//printShows(queue);
		
	}//end of main
	
	//adds a movie
	public static void addMovie(NetflixItem[] array, int index) {
		String newTitle, newGenre;
		int newPriority, newYear;
		Scanner kb2 = new Scanner(System.in);
		System.out.println("Enter a title.");
		newTitle = kb2.nextLine();
		System.out.println("Enter a genre.");
		newGenre = kb2.nextLine();
		System.out.println("Enter the year the film was released.");
		newYear = kb2.nextInt();
		System.out.println("Enter a priority for this film.");
		newPriority = kb2.nextInt();
		kb2.nextLine();
		array[index] = new Movie(newGenre);
		array[index].setTitle(newTitle);
		array[index].setYear(newYear);
		array[index].setPriority(newPriority);
	}
	
	/*public static void addMovie(String title, String genre, int year, int priority) {
		Movie newMovie = new Movie(genre);
		newMovie.setTitle(title);
		newMovie.setYear(year);
		newMovie.setPriority(priority);
	}*/
	
	//adds a new Show
	public static void addShow(NetflixItem[] array, int index) {
		String newTitle, newSeries;
		int newPriority, newYear, newEpNumber;
		Scanner kb2 = new Scanner(System.in);
		System.out.println("Enter the episode title.");
		newTitle = kb2.nextLine();
		System.out.println("Enter the series name.");
		newSeries = kb2.nextLine();
		System.out.println("Enter the year the show was released.");
		newYear = kb2.nextInt();
		System.out.println("What episode number is this?");
		newEpNumber = kb2.nextInt();
		System.out.println("Enter a priority for this show.");
		newPriority = kb2.nextInt();
		kb2.nextLine();
		array[index] = new Show(newTitle, newEpNumber);
		array[index].setTitle(newSeries);
		array[index].setYear(newYear);
		array[index].setPriority(newPriority);
	}
	
	//prints array of NetflixItem objects
	public static void print(NetflixItem[] array) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null)
				System.out.println(array[i].toString());
		}
	}
	
	//prints only movies
	public static void printMovies(NetflixItem[] array) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null && array[i].getClass().isAssignableFrom(Movie.class)) 
				System.out.println(array[i].toString());
		}
	}
	
	//prints only shows
		public static void printShows(NetflixItem[] array) {
			for(int i = 0; i < array.length; i++) {
				if(array[i] != null && array[i].getClass().isAssignableFrom(Show.class)) 
					System.out.println(array[i].toString());
			}
		}
		
	//prints movies and shows of a given priority 1-5
	public static void printPriority(NetflixItem[] array, int priority) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null && array[i].getPriority() == priority)
				System.out.println(array[i].toString());
		}
	}
	
	//reads in data from text file
	public static void read(NetflixItem[] array, Scanner newScan, int size) {
		for(int i = 0; i < size; i++) {
			String sorter = newScan.nextLine().toUpperCase();
			switch(sorter) {
			case "M":
			//lines commented out for debug purposes.
			//if(sorter.equalsIgnoreCase("M")) {
				array[i] = new Movie(newScan.nextLine());
				//queue[i] = new NetflixItem();
				array[i].setTitle(newScan.nextLine());
				array[i].setYear(newScan.nextInt());
				array[i].setPriority(newScan.nextInt());
				newScan.nextLine();
				//sorter = input.next();
			//}
				break;
			case "S":
			//else if(sorter.equals("S")){
				array[i] = new Show();
				Show dummy = new Show();
				dummy = (Show) array[i];
				dummy.setSeriesTitle(newScan.nextLine());
				dummy.setEpNumber(newScan.nextInt());
				newScan.nextLine();
				dummy.setTitle(newScan.nextLine());
				dummy.setYear(newScan.nextInt());
				dummy.setPriority(newScan.nextInt());
				newScan.nextLine();
			}
		}
	}

}//end of class
