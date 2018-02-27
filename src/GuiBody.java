//Imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;

//Class
public class GuiBody extends JFrame {
	
	//Fields
	private JPanel contentPane;

	private JLabel labelDayOrNight = new JLabel("Default: DAY");
    private JLabel dividerLabel = new JLabel("____________________________________________________________");
    private JLabel labelWhatToDo = new JLabel("Default: Start teralyst hunt? YES");
	private JLabel labelTimeRemaining = new JLabel("Default: xxx minutes until day");
	
	//Constructor
	public GuiBody(int minutesIntoCurrentCycle, boolean isNight) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Specify what to do on program closure
		setBounds(100, 100, 375, 225);	//Set bounds for GUI
			
		contentPane = new JPanel();	//Create content pane
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));	//Set borders
		setContentPane(contentPane);	//Assign content pane as GUI's contentPane
		contentPane.setLayout(new GridLayout(4, 1));	//Set layout for content pane
			
		//Day or night label
		labelDayOrNight.setFont(new Font("Arial Black", Font.PLAIN, 40));	//Set font
		contentPane.add(labelDayOrNight);	//Add to content pane

        //Divider label
        contentPane.add(dividerLabel); //Label to divide screen

		//Time for hunt label
		labelWhatToDo.setFont(new Font("Arial Black", Font.PLAIN, 20)); //Set font
		contentPane.add(labelWhatToDo);	//Add to content pane

		//Time remaining label
		labelTimeRemaining.setFont(new Font("Arial Black", Font.PLAIN, 20));	//Set font
		contentPane.add(labelTimeRemaining);	//Add to content pane

		this.refreshGui(minutesIntoCurrentCycle, isNight);
		this.setVisible(true);
	}
	
	//Methods
	public void refreshGui(int minutesIntoCurrentCycle, boolean isNight){
		this.invalidate();

		int minutesUntilDay = 150 - minutesIntoCurrentCycle;
		int minutesUntilNight = 100 - minutesIntoCurrentCycle;

		if(isNight){
			labelDayOrNight.setText("NIGHT");
			labelDayOrNight.setForeground(Color.WHITE);
			contentPane.setBackground(Color.BLACK);

			if(minutesUntilDay < 10){
				labelWhatToDo.setText("Time to search wisps");
			}
			else if(minutesUntilDay > 10 && minutesUntilDay < 20){
				labelWhatToDo.setText("Time to pwn TERALYST");
            }
            else if(minutesUntilDay > 20 && minutesUntilDay < 30){
				labelWhatToDo.setText("Time to pwn GANTULYST");
            }
			else{
				labelWhatToDo.setText("Time to pwn HYDROLYST");
			}
			labelWhatToDo.setForeground(Color.WHITE);
			labelTimeRemaining.setText(minutesUntilDay + " minutes until day");
			labelTimeRemaining.setForeground(Color.WHITE);
		}
		else{
			labelDayOrNight.setText("DAY");
			labelDayOrNight.setForeground(Color.BLACK);
			contentPane.setBackground(Color.WHITE);

			labelWhatToDo.setText("Bounty time!");
			labelWhatToDo.setForeground(Color.BLACK);
			labelTimeRemaining.setText(minutesUntilNight + " minutes until night");
			labelTimeRemaining.setForeground(Color.BLACK);
		}
		this.revalidate();
		this.repaint();
	}
}
