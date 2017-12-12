//Imports
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.io.IOException;

//Class
public class CurrentTimeTracker {
	//Fields
	private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	//Format for dates
	private LocalDateTime currentTime = LocalDateTime.now();	//Set current time in variable
	private String currentTimeString = dateFormat.format(currentTime);	//Format current time into a string	//Create string list
	
	//Methods
	public void printCurrentTime(){
		System.out.println(currentTimeString);
	}
	
	public void updateCurrentTimeString(){
		currentTime = LocalDateTime.now();
		currentTimeString = dateFormat.format(currentTime);
	}
	
	//Getters
	public String getCurrentTimeString(){
		return currentTimeString;
	}
	
}