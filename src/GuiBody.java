//Imports
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import java.awt.Color;

//Class
public class GuiBody extends JFrame {
	
	//Fields
	private JPanel contentPane;
	
	private JPanel centerPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	
	private JLabel labelDayOrNight = new JLabel("Default: DAY");
	private JLabel labelTimeRemaining = new JLabel("Default: xxx minutes until day");
	
	//Constructor
	public GuiBody(int minutesIntoCurrentCycle, boolean isNight) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Specify what to do on program closure
			setBounds(100, 100, 450, 300);	//Set bounds for GUI
			
			contentPane = new JPanel();	//Create content pane
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));	//Set borders
			setContentPane(contentPane);	//Assign content pane as GUI's contentPane
			contentPane.setLayout(new BorderLayout(0, 0));	//Set layout for content pane
			
			//Center panel
			contentPane.add(centerPanel, BorderLayout.CENTER);	//Add to content pane
			centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));	//Set layout
			
			//Day or night label
			labelDayOrNight.setFont(new Font("Arial Black", Font.PLAIN, 40));	//Set font
			centerPanel.add(labelDayOrNight);	//Add to center panel
			
			//Bottom panel
			contentPane.add(bottomPanel, BorderLayout.SOUTH);	//Add to content pane
			
			//Time remaining label
			labelTimeRemaining.setFont(new Font("Arial Black", Font.PLAIN, 20));	//Set font
			bottomPanel.add(labelTimeRemaining);	//Add to bottom panel
		
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
			centerPanel.setBackground(Color.BLACK);
			
			labelTimeRemaining.setText(minutesUntilDay + " minutes until day");
			labelTimeRemaining.setForeground(Color.WHITE);
			bottomPanel.setBackground(Color.BLACK);
		}
		else{
			labelDayOrNight.setText("DAY");
			labelDayOrNight.setForeground(Color.BLACK);
			centerPanel.setBackground(Color.WHITE);
			
			labelTimeRemaining.setText(minutesUntilNight + " minutes until night");
			labelTimeRemaining.setForeground(Color.BLACK);
			bottomPanel.setBackground(Color.WHITE);
		}
		this.revalidate();
		this.repaint();
	}
}
