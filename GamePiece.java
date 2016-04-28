/**
 *
 * @author dstrivelli
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.util.ArrayList;
import java.io.*;

// Class that represents a button within the
// gameplay button grid for the game
public class GamePiece extends JButton{

	// Properties include:
	public int currState;
	public int value;
	
	// Constructing the GamePiece
	public GamePiece(){
		super();

		setState(0); // Set initial state to 0
		value = 0; // Set value to 0
		setText("" + value); // Set text to 0
		// Place text centered horizontally and vertically
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);

		// Set text font to 40PT and RED
		this.setForeground(Color.RED);
		this.setFont(new Font("Arial", Font.BOLD, 40));

		// Change visual properties of the buttons
		setBorderPainted( false );
		setFocusPainted( false );
		setOpaque(true);
	}

	// Create a game piece in a specified state (doesn't get used)
	public GamePiece(int currState){
		super();
		this.currState = currState;
		value = (int)Math.pow(2, currState);
		setText("" + value);
	}

	// Given a path to an image, load that image (helps with loading files while packed in JAR)
	public Image getImage(String imagePath){
		try {
			return ImageIO.read(getClass().getClassLoader().getResource(imagePath));
		} catch (IOException exp) {
			exp.printStackTrace();
			return null;
		}
	}

	// Meat and Potatoes Function
	// Method sets the given button to a discrete state
	// which will by-effect change the text and image of the button
	public void setState(int currState){
		this.currState = currState;
		this.value = (int) Math.pow(2, currState); // Text is state's power of 2
		this.setText("" + value);
		// Initial button sizes
		int bWidth = 157;
		int bHeight = 85;
		// Resize buttons to preferred size
		if(this.getWidth() * this.getHeight() > 0){
			bWidth = this.getWidth();
			bHeight = this.getHeight();
		}
		// Sets the image and background color of each state
		Image img = null;
		ImageIcon a = null;
		switch(currState){
			default: 
				break;
			case -1:
				this.setIcon(null);
				this.setBackground(Color.green);
				this.setText("YOU LOST");
				this.setFont(new Font("Arial", Font.BOLD, 20));
				break;
			case 0:
				this.setIcon(null);
				this.setBackground(Color.white);
				this.setText(null);
				this.setFont(new Font("Arial", Font.BOLD, 40));
				break;
			case 1:
				a = new ImageIcon(getClass().getClassLoader().getResource("pics/beaverstadium3.jpg"));
				this.setBackground(new Color(255,51,51));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 2:
				a = new ImageIcon(getClass().getClassLoader().getResource("pics/creamery1.jpg"));
				this.setBackground(new Color(255,153,51));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 3:
				a = new ImageIcon(getClass().getClassLoader().getResource("pics/joepa2.jpg"));
				this.setBackground(new Color(255,255,51));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 4:
				a = new ImageIcon(getClass().getClassLoader().getResource("pics/mm1.jpg"));
				this.setBackground(new Color(153, 255, 51));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 5:
				a = new ImageIcon(getClass().getClassLoader().getResource("pics/nittanylion2.jpg"));
				this.setBackground(new Color(51, 255, 51));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 6:
				a = new ImageIcon(getClass().getClassLoader().getResource("pics/oldmain.jpg"));
				this.setBackground(new Color(51, 255, 153));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 7:
				a = new ImageIcon(getClass().getClassLoader().getResource("pics/THON2.jpg"));
				this.setBackground(new Color(51, 255, 255));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 8:
				a = new ImageIcon(getClass().getClassLoader().getResource("pics/bb1.jpg"));
				this.setBackground(new Color(51, 153, 255));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 9:
				a = new ImageIcon(getClass().getClassLoader().getResource("pics/nittanylion1.jpg"));
				this.setBackground(new Color(51, 51, 255));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 10:
				a = new ImageIcon(getClass().getClassLoader().getResource("pics/weare1.png"));
				this.setBackground(new Color(153, 51, 255));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 11:
				a = new ImageIcon(getClass().getClassLoader().getResource("pics/ist1.jpg"));
				this.setBackground(new Color(255, 51, 255));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				// Call win function maybe pop dialog with message
				break;
		}
	}

	
	// Returns the current state of the button
	public int getState(){
		return currState;
	}

}
	