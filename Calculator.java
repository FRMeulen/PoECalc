//Imports
import java.text.*;
import java.util.Date;

//Class
public class Calculator {
	//Fields
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private Date currentDate;
	private Date lastCycle;
	private boolean isNight = false;
	private long differenceInMinutes;
	private int minutesIntoCurrentCycle;
	
	//Constructor
	public Calculator(String current, String last){
		updateTimeValues(current, last);
		
		calculateDifferenceInMinutes();
	}
	
	//Methods
	public void calculateDifferenceInMinutes(){
	    if(lastCycle.getTime() > currentDate.getTime()){
			System.out.println("Error! Last cycle finished in the future. Consider checking 'Last Known Cycle.txt' for incorrect date and time.");
		}
		differenceInMinutes = (currentDate.getTime() - lastCycle.getTime()) / 60000;
	}
	
	public void updateTimeValues(String current, String last){
		try{currentDate = format.parse(current);}
		catch(ParseException e){}
		
		try{lastCycle = format.parse(last);}
		catch(ParseException ex){}
	}
	
	public String determineLastFlip(){
		calculateDifferenceInMinutes();
		long tempDifferenceInMinutes = differenceInMinutes;
		int counter = 0;
		while(tempDifferenceInMinutes >= 150){
			tempDifferenceInMinutes -= 150;
			counter++;
		}
		minutesIntoCurrentCycle = (int)tempDifferenceInMinutes;
		
		if(tempDifferenceInMinutes > 100){
			isNight = true;
		}
		else{
			isNight = false;
		}

		lastCycle.setTime(currentDate.getTime() - (tempDifferenceInMinutes * 60000));
		return format.format(lastCycle);
	}
	
	//Getters
	public int getMinutesIntoCurrentCycle(){
		return minutesIntoCurrentCycle;
	}
	
	public boolean getIsNight(){
		return isNight;
	}
}
