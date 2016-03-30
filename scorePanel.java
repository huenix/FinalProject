import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

// Class that defines the upper panel of the timer game
public class scorePanel extends JPanel {
	
	// Initialize components and variables
	// that will be used in the panel
	int score;
	JLabel scoreLabel;
	JButton startButton;
	JButton resetButton;
	JSlider delaySlider;

	// Constructor that configures scorePanel
	public scorePanel(){	

		// Instantiate new variables
		score = 0;
		scoreLabel = new JLabel("Score: " + score);
		startButton = new JButton("START");
		resetButton = new JButton("RESET");

		// Instantiate the slider such that it will range
		// from -100 to 100 and have major tick marks on every multiple
		// of 25
		delaySlider = new JSlider(JSlider.HORIZONTAL, 100, 2000, 1000);
	    delaySlider.setBorder(BorderFactory.createTitledBorder("Delay"));
    	delaySlider.setMajorTickSpacing(500);
    	delaySlider.setPaintTicks(true);
   		delaySlider.setPaintLabels(true);

		// Add components to panel
		this.add(scoreLabel);
		this.add(startButton);
		this.add(resetButton);
		this.add(delaySlider);
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
}