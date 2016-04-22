import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class introPanel extends JPanel {

	JLabel titleLabel;
	JButton playButton;
	JButton instructionsButton;
	JButton hiscoresButton;
	JButton designersButton;

	public introPanel(){
		super();

		this.setBackground(Color.orange);
		this.setLayout(new GridLayout(0, 1));

		titleLabel = new JLabel("IST GAME NAME");
		titleLabel.setFont(new Font("Arial", Font.BOLD,48));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		playButton = new JButton("Play Game");
		instructionsButton = new JButton("Instructions");
		hiscoresButton = new JButton("Hi Scores");
		designersButton = new JButton("Game Designers");

		this.add(titleLabel);
		this.add(playButton);
		this.add(instructionsButton);
		this.add(hiscoresButton);
		this.add(designersButton);
	}

}