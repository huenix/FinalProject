/**
 *
 * @author dstrivelli
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.Set;

public class ButtonPanel extends JPanel {//implements KeyListener{
	
	private final int ROWS = 4;  // Number of Rows in Game Board
	private final int COLS = 4;  // Number of Columns in Game Board
	private final int PAD = 4;   // Number of pixels padding each grid item

	// Constants for directionality
	private final int NORTH = 0; 
	private final int WEST = 1;
	private final int EAST = 2;
	private final int SOUTH = 3;

	// ArrayList of GamePiece Buttons that will be played with
	public ArrayList<GamePiece> buttons;
	int score;  // Score of this given panel
	
	// Constructor of the Button Panel
	public ButtonPanel()
	{   
		super();
		this.score = 0;  // Set starting score to 0
		this.setBackground(Color.orange);
		buttons = new ArrayList<>();
		// Define the GridLayout
		this.setLayout(new GridLayout(ROWS, COLS, PAD, PAD));
		// Instantiate the Game Buttons and add them into the 
		// button grid
		for(int x = 0; x < ROWS* COLS; x++){
			GamePiece a = new GamePiece();
			buttons.add(a);
			this.add(a);
		}
		// Then call reset to get Board ready to play
		reset();
	}


	// Reset method sets all buttons to state 0
	// resets the score to 0, and also adds two random tiles
	public void reset(){
		for(GamePiece g : buttons){
			g.setState(0);
		}
		
		this.score = 0;
		addRandomTile();
		addRandomTile();
	}


	// Method that maps linear ArrayList indices to Button Grid Positions
	// And returns an integer array of indices of each buttonIndex's neighbors
	public int [] getNeighbors(int buttonIndex){

		// There are no neighbors for false buttons
		if(buttonIndex < 0 || buttonIndex > buttons.size()-1){
			System.out.println("Trying to show neighbors for a dead button: " + buttonIndex);
			int[] noNeighbors = {-1, -1, -1, -1};

			return noNeighbors;
		}

		// Create the array to hold the neighbors
		int[] neighbors = new int[4];
		
		// Check for out of bounds on top
		// If one button up (-COLS positions away linearly) exists
		// set that as north neighbor
		if (buttonIndex - COLS >= 0 ){
			neighbors[0] = buttonIndex-COLS;
		}
		else{
			neighbors[0] = -1;
		}

		// Check for out of bounds on left
		// If one button left (-1 positions away linearly) exists
		// set that as west neighbor
		if(buttonIndex % COLS - 1 >= 0){
			neighbors[1] = buttonIndex-1;
		}
		else{
			neighbors[1] = -1;
		}
		
		// Check for out of bounds on right 
		// If one button right (+1 positions away linearly) exists
		// set that as east neighbor
		if(buttonIndex % COLS + 1 < COLS){
			neighbors[2] = buttonIndex + 1;
		}
		else{
			neighbors[2] = -1;
		}

		// Check for out of bounds on bottom
		// If one button down (+COLS positions away linearly) exists
		// set that as southneighbor
		if (buttonIndex + COLS < ROWS * COLS ){
			neighbors[3] = buttonIndex+COLS;
		}
		else{
			neighbors[3] = -1;
		}

		return neighbors;
	}


	// Method that gets called when up arrow is 
	// pressed within the gameplay window
	public boolean actuateUp(){
		boolean goOn = false; // Lets us know if we made any changes during actuation
		// Loop through each button in button grid
		// Starting from the top left position, going down first , then across
		for(int c = 0; c < COLS; c++){
			for(int r = 0; r < ROWS; r++){
				int thisIndex = r*COLS + c;
				int thisState = buttons.get(thisIndex).getState();
				buttons.get(thisIndex).setState(0);
				int []myNeighbors = getNeighbors(thisIndex); // Find neighbors for current position
				// Check to see if neighbor is a blank space
				while(isBlankSpace(myNeighbors[NORTH])){
					thisIndex -= COLS;
					myNeighbors = getNeighbors(thisIndex);
					goOn = true;
				}
				// Then move this button to the furthest position
				buttons.get(thisIndex).setState(thisState);

				// Check if the neighbor against it has the same state value
				// as itself, and if so merge the two into a larger state.
				if(myNeighbors[NORTH] != -1 && buttons.get(myNeighbors[NORTH]).getState() == thisState){
					buttons.get(thisIndex).setState(0);
					buttons.get(myNeighbors[NORTH]).setState(thisState+1);
					if(thisState+1 >= 2){
						this.score += (int) Math.pow(2, thisState+1);
					}
					goOn = true;
				}

			}
		}
		return goOn; // Returning this bool tells our parent function if we actuated
	}

	// Method that gets called when down arrow is 
	// pressed within the gameplay window
	public boolean actuateDown(){
		boolean goOn = false;
		// Loop through each button in button grid
		// Starting from the bottom left position, going up first , then across
		for(int c = 0; c < COLS; c++){
			for(int r = ROWS-1; r >= 0; r--){
				int thisIndex = r*COLS + c;
				int thisState = buttons.get(thisIndex).getState();
				buttons.get(thisIndex).setState(0);
				int []myNeighbors = getNeighbors(thisIndex);// Find neighbors for current position
				// Check to see if neighbor is a blank space
				while(isBlankSpace(myNeighbors[SOUTH])){
					thisIndex += COLS;
					myNeighbors = getNeighbors(thisIndex);
					goOn = true;
				}
				buttons.get(thisIndex).setState(thisState);

				// Check if the neighbor against it has the same state value
				// as itself, and if so merge the two into a larger state.
				if(myNeighbors[SOUTH] != -1 && buttons.get(myNeighbors[SOUTH]).getState() == thisState){
					buttons.get(thisIndex).setState(0);
					buttons.get(myNeighbors[SOUTH]).setState(thisState+1);
					if(thisState+1 >= 2){
						this.score += (int) Math.pow(2, thisState+1);
					}
					goOn = true;
				}
			}
		}
		return goOn; // Returning this bool tells our parent function if we actuated
	}


	public boolean actuateRight(){
		boolean goOn = false;
		// Loop through each button in button grid
		// Starting from the top right position, going across first, then down
		for(int r = 0; r < ROWS; r++){
			for(int c = ROWS-1; c >= 0; c--){
				int thisIndex = r*COLS + c;
				int thisState = buttons.get(thisIndex).getState();
				buttons.get(thisIndex).setState(0);
				int []myNeighbors = getNeighbors(thisIndex);
				while(isBlankSpace(myNeighbors[EAST])){
					thisIndex += 1;
					myNeighbors = getNeighbors(thisIndex);
					goOn = true;
				}
				buttons.get(thisIndex).setState(thisState);

				// Check if the neighbor against it has the same state value
				// as itself, and if so merge the two into a larger state.
				if(myNeighbors[EAST] != -1 && buttons.get(myNeighbors[EAST]).getState() == thisState){
					buttons.get(thisIndex).setState(0);
					buttons.get(myNeighbors[EAST]).setState(thisState+1);
					if(thisState+1 >= 2){
						this.score += (int) Math.pow(2, thisState+1);
					}
					goOn = true;
				}
			}
		}
		return goOn; // Returning this bool tells our parent function if we actuated
	}

	public boolean actuateLeft(){
		boolean goOn = false;
		// Loop through each button in button grid
		// Starting from the top left position, going down first, then across
		for(int r = 0; r < ROWS; r++){
			for(int c = 0; c < COLS; c++){
				int thisIndex = r*COLS + c;
				int thisState = buttons.get(thisIndex).getState();
				buttons.get(thisIndex).setState(0);
				int []myNeighbors = getNeighbors(thisIndex);
				while(isBlankSpace(myNeighbors[WEST])){
					thisIndex -= 1;
					myNeighbors = getNeighbors(thisIndex);
					goOn = true;
				}
				buttons.get(thisIndex).setState(thisState);

				// Check if the neighbor against it has the same state value
				// as itself, and if so merge the two into a larger state.
				if(myNeighbors[WEST] != -1 && buttons.get(myNeighbors[WEST]).getState() == thisState){
					buttons.get(thisIndex).setState(0);
					buttons.get(myNeighbors[WEST]).setState(thisState+1);
					if(thisState+1 >= 2){
						this.score += (int) Math.pow(2, thisState+1);
					}
					goOn = true;
				}
			}
		}
		return goOn; // Returning this bool tells our parent function if we actuated
	}


	// Check to see if a button at a given index
	// Is a blank space, as represented by state 0
	public boolean isBlankSpace(int buttonIndex){
		if(buttonIndex < 0 || buttonIndex > buttons.size()-1)
			return false;

		return (buttons.get(buttonIndex).getState() == 0);
	}

	// Method that adds a random tile to the button grid
	// in either the first or second states, choosing from the
	// area of blank spaces
	public void addRandomTile(){
		// Determine parity of random tile
		int two_or_four = (int) Math.floor(Math.random() * 2) + 1;
		int randomIndex = 0;
		int count = 0; 	// Keep number of attempts so you dont 
						// loop infinitely looking for a slot
		// While index hasn't yet been found
		while(randomIndex != -1){
			// Look for a random index
			randomIndex = (int) Math.floor(Math.random() * ROWS * COLS);
			// Check its blank-ness
			if(isBlankSpace(randomIndex)){
				buttons.get(randomIndex).setState(two_or_four);
				randomIndex = -1;
			}
			// If we're still in range of our grid, we're still playing
			if(count < ROWS * COLS){
				count++;
			}
			// Otherwise user has lost because there is no more space
			else{
				youLost();
				randomIndex = -1;
			}

		}
	}

	// Method to set game state for losing buttons
	public void youLost(){

		for(GamePiece g : buttons){
			g.setState(-1);
		}
			
	}


	public String getGameBoard()
	{
        //Going through the ArrayList and creating a 16 character string to account for 
        //each of the values of the board pieces, and writing it to an XML file
		StringBuilder StrBld = new StringBuilder();
		String gameBoard;
		for (GamePiece g : buttons){
			if(g.getState()== 10)
				StrBld.append("A");
			else if(g.getState()==11)
				StrBld.append("B");
			else
				StrBld.append(g.getState());
		}
		gameBoard = StrBld.toString();
		return gameBoard;
		
	}

	public void setGameBoard(String gb)
	{
       //Grab the 16 character string from the XML file, for each character
       //convert to numeric value to assign to buttons ArrayList state.
		int chnum;
		char a = 'A';
		char b = 'B';
		for(int i = 0; i < gb.length(); i++){
			char ch = gb.charAt(i);
			if(ch == a)
				chnum = 10;
			else if(ch == b)
				chnum = 11;
			else
				chnum = Character.getNumericValue(ch);
			System.out.println(chnum);
			buttons.get(i).setState(chnum);
			
		}
	}
}

