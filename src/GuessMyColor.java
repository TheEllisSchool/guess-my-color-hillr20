import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class GuessMyColor extends JFrame{
	private JPanel targetPanel = new JPanel();
	private JPanel myColorPanel = new JPanel();
	
	private int targetRed = 0;
	private int targetGreen = 0;
	private int targetBlue = 0;
	

	public GuessMyColor(){	
		
		initGUI();
		
		setTitle("Guess My Color");
		setSize(200, 100); //pixels
		setResizable(true);
		//can change to false to change size
		pack();
		setLocationRelativeTo(null); //centers on screen, do this after packing but before visible

			
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public void initGUI(){
		//added, for the panels part
		JPanel titlePanel = new JPanel();
		add(titlePanel, BorderLayout.PAGE_START);
		//also change background
		titlePanel.setBackground(Color.BLACK);
		JLabel titleLabel = new JLabel("Guess My Color");
		//JLab = class; titleLabel = instance of the class
		//once you create it, you have to add it to the frame (see below)
		add(titleLabel);
		titlePanel.add(titleLabel);
		titleLabel.setHorizontalAlignment(JLabel.CENTER); //left or right
		Font titlefont = new Font("Georgia", Font.BOLD, 18);
		titleLabel.setForeground(Color.GREEN);
		titleLabel.setFont(titlefont);
		//add panels for different sections
		//center, title, and bottom panels
		
		
		//center panel for color blocks
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setBackground(Color.WHITE);
		
		//target color
		Dimension size = new Dimension (50, 50);
		generateColor();
		
		//JPanel targetPanel = new JPanel();
		centerPanel.add(targetPanel);
		//targetPanel.setBackground(Color.RED);
		
		//targetPanel.setSize(new Dimension(40, 40));
		targetPanel.setPreferredSize(size);
		targetPanel.setSize(getPreferredSize());
		
		
		//my color
		//JPanel myColorPanel = new JPanel();
		centerPanel.add(myColorPanel);
		myColorPanel.setBackground(Color.BLUE);
		myColorPanel.setPreferredSize(size);
		myColorPanel.setSize(getPreferredSize());
		
		
		//bottom panel for buttons
		JPanel bottomPanel = new JPanel();
		add(bottomPanel, BorderLayout.PAGE_END);
		bottomPanel.setBackground(Color.BLACK);
		
		//buttons
		Font buttonFont = new Font ("Roboto", Font.PLAIN, 16);
		
		JButton plusRed = new JButton("+");
		plusRed.setFont(buttonFont);
		plusRed.setBackground(Color.RED);
		bottomPanel.add(plusRed);
		
		JButton lessRed = new JButton("-");
		lessRed.setFont(buttonFont);
		lessRed.setBackground(Color.RED);
		bottomPanel.add(lessRed);
		
		JButton plusGreen = new JButton("+");
		plusGreen.setFont(buttonFont);
		plusGreen.setBackground(Color.GREEN);
		bottomPanel.add(plusGreen);
		
		JButton lessGreen = new JButton("-");
		lessGreen.setFont(buttonFont);
		lessGreen.setBackground(Color.GREEN);
		bottomPanel.add(lessGreen);
		
		JButton plusBlue = new JButton("+");
		plusBlue.setFont(buttonFont);
		plusBlue.setBackground(Color.BLUE);
		bottomPanel.add(plusBlue);
		
		JButton lessBlue = new JButton("-");
		lessBlue.setFont(buttonFont);
		lessBlue.setBackground(Color.BLUE);
		bottomPanel.add(lessBlue);	
		
	}
	
	public void generateColor() {
		targetRed = (int) ((Math.random() * 17) * 15); //just * 17 generates random number between 0 and 15
		targetGreen = (int) ((Math.random() * 17) * 15); //math.random() generates # btwn 0 and 1
		targetBlue = (int) ((Math.random() * 17) * 15);
		
		Color targetColor = new Color (targetRed, targetGreen, targetBlue);
		targetPanel.setBackground(targetColor);
	}

	public static void main(String[] args) {
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new GuessMyColor();
            }   
        });

	}

} //Homework... 
