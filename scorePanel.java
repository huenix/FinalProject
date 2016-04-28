import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

// Class that defines the upper panel of the timer game
public class scorePanel extends JPanel {
	
	// Initialize components and variables
	// that will be used in the panel
	int score;
	String name;
	JLabel scoreLabel;
	JLabel nameLabel;
	JButton startButton;
	JButton resetButton;

	// Constructor that configures scorePanel
	public scorePanel(){	

		this.setBackground(new Color(19, 84, 184));

		// Instantiate new variables
		score = 0;
		name = "John Doe";
		scoreLabel = new JLabel("Score: " + score);
		scoreLabel.setForeground(Color.white);
		nameLabel = new JLabel("Name: " + name);
		nameLabel.setForeground(Color.white);
		startButton = new JButton("START");
		resetButton = new JButton("RESET");


		// Add components to panel
		this.add(scoreLabel);
		this.add(nameLabel);
		this.add(startButton);
		this.add(resetButton);
	}

	// Method that sets score label to new score
	public void setScore(int newScore){
		score = newScore;
		scoreLabel.setText("Score: " + score);
	}

	// Accessor method for current score
	public int getScore(){
		return score;
	}

	// Method that sets name label to new name
	public void setName(String newName){
		name = newName;
		nameLabel.setText("Name: " + name);
		System.out.println(newName);
	}

	// Accessor method for current name
	public String getName(){
		return name;
	}
}