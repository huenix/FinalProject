/**
 *
 * @author dstrivelli
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


// Class that represents the intro panel that 
// is displayed when application first launches
public class introPanel extends JPanel {

	JLabel titleLabel;
	JButton playButton;
	JButton instructionsButton;
	JButton hiscoresButton;
	JButton designersButton;

	public introPanel(){
		super();
		// Set background of the panel
		this.setBackground(Color.orange);
		// Define the layout of the panel
		this.setLayout(new GridLayout(0, 1));

		// Instantiate and set attributes for panel elements
		titleLabel = new JLabel("PSU48");
		titleLabel.setFont(new Font("Arial", Font.BOLD,48));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		playButton = new JButton("START HERE");
		instructionsButton = new JButton("Instructions");
		hiscoresButton = new JButton("Hi Scores");
		designersButton = new JButton("Game Designers");

		// Add panel elements into the panel
		this.add(titleLabel);
		this.add(playButton);
		this.add(instructionsButton);
		this.add(hiscoresButton);
		this.add(designersButton);
	}

}