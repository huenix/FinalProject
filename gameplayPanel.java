/**
 *
 * @author dstrivelli
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// This class represents a panel that holds both the button
// area of gameplay as well as the scoring panel associated with it
public class gameplayPanel extends JPanel implements KeyListener, ActionListener {
	
	scorePanel score_panel;
	ButtonPanel button_panel;
	Timer gameTimer;
	int interval = 4000;

	// Constructing the gameplay panel
	public gameplayPanel(){
		super();
		// Set the layout
		this.setLayout(new BorderLayout());
		// Instantiate inner panels
		score_panel = new scorePanel();
		button_panel = new ButtonPanel();
		// Add the panels to correct locations
		this.add(score_panel, "North");
		this.add(button_panel, "Center");
		// Set some options to enable proper focus on buttons
		// And add action listeners to both panels
		this.setFocusable(true);
		this.addKeyListener(this);
		button_panel.setFocusable(true);
		button_panel.addKeyListener(this);
		score_panel.setFocusable(true);
		score_panel.addKeyListener(this);
		score_panel.resetButton.addActionListener(this);

        // Start the timer
		gameTimer = new Timer(interval, this);


		// Add KEY Listener to every button in the button grid
		for(GamePiece g : button_panel.buttons){
			g.addKeyListener(this);
		}
	}

	// Action performed manages button clicks and timer events
	public void actionPerformed(ActionEvent e){
		// Reset the gameboard and score
		if(e.getSource() == score_panel.resetButton){
			button_panel.reset();
			score_panel.setScore(0);
		}
		// When the timer clicks, add a random tile
		// and restart the timer
		if (e.getSource() == gameTimer) {                    

			button_panel.addRandomTile();
			gameTimer.restart();
		}
	}

	/** Handle the key typed event from the text field. */
	public void keyTyped(KeyEvent e) {

	}

	// Method that runs when the arrow keys are pressed
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
			// Actuate up, if statement checks if actuation occured
			if(button_panel.actuateUp())
				button_panel.addRandomTile();
			gameTimer.restart();
			score_panel.setScore(button_panel.score);
			break;
			case KeyEvent.VK_DOWN:
			// Actuate down, if statement checks if actuation occured
			if(button_panel.actuateDown())
				button_panel.addRandomTile();
			gameTimer.restart();
			score_panel.setScore(button_panel.score);
			break;
			case KeyEvent.VK_LEFT:
			// Actuate left, if statement checks if actuation occured
			if(button_panel.actuateLeft())
				button_panel.addRandomTile();
			gameTimer.restart();
			score_panel.setScore(button_panel.score);
			break;
			case KeyEvent.VK_RIGHT:
			// Actuate right, if statement checks if actuation occured
			if(button_panel.actuateRight())
				button_panel.addRandomTile();
			gameTimer.restart();
			score_panel.setScore(button_panel.score);
			break;
			default:
			System.out.println("Not supported Key");
			break;
		}
	}

	/** Handle the key-released event from the text field. */
	public void keyReleased(KeyEvent e) {

	}

	// Set timer delay
	public void setTimer(int i) {
		gameTimer.setDelay(i);
		gameTimer.restart();
		System.out.println("Set Timer value to " + i);
	}

	// Set timer delay (default to 4s)
	public void setTimer() {
		gameTimer.setDelay(4000);
	}

	// Start the timer
	public void startTimer(){
		gameTimer.start();
	}

	// Start the timer with delay d
	public void startTimer(int d) {
		gameTimer.setDelay(d);
		System.out.println("Started timer with delay " + d);
		gameTimer.start();
	}
	
	// Stop the timer
	public void stopTimer() {
		gameTimer.stop();
	}
}