//Imports


//Class
public class Handler {
	//Fields
	private CurrentTimeTracker currentTimeTracker = new CurrentTimeTracker();
	private CycleTracker cycleTracker = new CycleTracker();
	private String currentTime = currentTimeTracker.getCurrentTimeString();
	private String lastFlip = cycleTracker.getStringLastFlip();
	private Calculator calculator = new Calculator(currentTime, lastFlip);
	
	//Methods
	public void updateLastFlip(){
		currentTimeTracker.updateCurrentTimeString();
		cycleTracker.updateLastCycleString();
		calculator.updateTimeValues(currentTimeTracker.getCurrentTimeString(), cycleTracker.getStringLastFlip());
		cycleTracker.writeNewCycleToFile(calculator.determineLastFlip());
	}
	
	//Getters
	public CurrentTimeTracker getCurrentTimeTracker(){
		return currentTimeTracker;
	}
	
	public CycleTracker getCycleTracker(){
		return cycleTracker;
	}
	
	public Calculator getCalculator(){
		return calculator;
	}
	
	//Setters
	public void setCalculator(Calculator newCalculator){
		calculator = newCalculator;
	}
}
