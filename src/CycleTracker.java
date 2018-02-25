//Imports
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.*;

//Class
public class CycleTracker {
	//Fields
	private List<String> lines;
	private String stringLastCycle;
	private BufferedWriter bufferedWriter = null;
	private FileWriter fileWriter= null;
	
	//Constructor
	public CycleTracker(){
		try{
			readLastCycleFromFile();
		} catch(IOException e){}
	}
	
	//Methods
	public void updateLastCycleString(){
		try{
			readLastCycleFromFile();
		}
		catch(IOException e){}
	}
	
	public void readLastCycleFromFile() throws IOException{
		lines = Files.readAllLines(Paths.get("Last Known Cycle.txt"), Charset.defaultCharset());
		stringLastCycle = String.join("", lines);
	}
	
	public void writeNewCycleToFile(String newCycle){
		String cycleToWrite = newCycle;
		try{
			fileWriter = new FileWriter("Last Known Cycle.txt");
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(cycleToWrite);
			bufferedWriter.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void printLastFlip(){
		System.out.println(stringLastCycle);
	}
	
	//Getters
	public String getStringLastFlip(){
		return stringLastCycle;
	}
}
