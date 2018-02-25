//Class
public class Main {
	public static void main(String[] args){
		Handler handler = new Handler();
		handler.updateLastFlip();
		GuiBody gui = new GuiBody(handler.getCalculator().getMinutesIntoCurrentCycle(), handler.getCalculator().getIsNight());
		
		while(true){
			try{
				Thread.sleep(10000);
				handler.updateLastFlip();
				gui.refreshGui(handler.getCalculator().getMinutesIntoCurrentCycle(), handler.getCalculator().getIsNight());
			}
			catch(InterruptedException e){}
		}
		
	}
}