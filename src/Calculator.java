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
		lastCycle.setTime(currentDate.getTime() - (tempDifferenceInMinutes * 60000));
		//System.out.println("A total of "+differenceInMinutes+" minutes between last known cycle and current time.");
		//System.out.println("That means "+counter+" cycle(s) completed between last known cycle and current time.");
		
		if(isNight){
			//System.out.println("That means it is night with "+ (150-tempDifferenceInMinutes)+" minutes until day.");
		}
		
		else{
			//System.out.println("That means it is day with "+ (100-tempDifferenceInMinutes)+" minutes until night.");
		}
		
		//System.out.println("The last cycle started: "+format.format(lastCycle));
		return format.format(lastCycle);
	}
	
	public void testCalculator(){
		System.out.println(format.format(currentDate));
		System.out.println(format.format(lastCycle));
		System.out.println(differenceInMinutes);
	}
	
	//Getters
	public long getDifferenceInMinutes(){
		return differenceInMinutes;
	}
	
	public int getMinutesIntoCurrentCycle(){
		return minutesIntoCurrentCycle;
	}
	
	public boolean getIsNight(){
		return isNight;
	}
}
