import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;

public class ButtonPanel extends JPanel implements KeyListener{
	
	private final int ROWS = 10;
	private final int COLS = 1
	private final int PAD = 3;

	private final int NORTH = 0;
	private final int WEST = 1;
	private final int EAST = 2;
	private final int SOUTH = 3;

	ArrayList<GamePiece> buttons;
	private int score;
	

	public ButtonPanel()
	{   
		super();
		this.score = 0;
		buttons = new ArrayList<>();
		this.setLayout(new GridLayout(ROWS, COLS, PAD, PAD));
		for(int x = 0; x < ROWS* COLS; x++){
			GamePiece a = new GamePiece();
			a.addKeyListener(this);
			a.setText("" + x);
			buttons.add(a);
			this.add(a);
		}
		for(int y = 0; y < ROWS*COLS; y++){
			this.getNeighbors(y);
		}
		addTestButtons();
		//buttons.get((int) Math.floor(Math.random() * ROWS * COLS)).setState(1);
		this.addKeyListener(this);
	}

	public void reset(){
		for(GamePiece g : buttons){
			g.setState(0);
		}
		//buttons.get((int) Math.floor(Math.random() * ROWS * COLS)).setState(1);
		this.score = 0;
	}

	public int [] getNeighbors(int buttonIndex){
		if(buttonIndex < 0 || buttonIndex > buttons.size()-1){
			System.out.println("Trying to show neighbors for a dead button: " + buttonIndex);
			int[] noNeighbors = {-1, -1, -1, -1};

			return noNeighbors;
		}

		//System.out.println("---NEIGHBORS FOR: " + buttonIndex);
		int[] neighbors = new int[4];
		
		// Check for out of bounds on top 
		if (buttonIndex - COLS >= 0 ){
			neighbors[0] = buttonIndex-COLS;
		}
		else{
			neighbors[0] = -1;
		}

		// Check for out of bounds on left
		if(buttonIndex % COLS - 1 >= 0){
			neighbors[1] = buttonIndex-1;
		}
		else{
			neighbors[1] = -1;
		}
		
		// Check for out of bounds on right 
		if(buttonIndex % COLS + 1 < COLS){
			neighbors[2] = buttonIndex + 1;
		}
		else{
			neighbors[2] = -1;
		}

		// Check for out of bounds on bottom
		if (buttonIndex + COLS < ROWS * COLS ){
			neighbors[3] = buttonIndex+COLS;
		}
		else{
			neighbors[3] = -1;
		}

		return neighbors;
	}

	/** Handle the key typed event from the text field. */

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
			actuateUp();
			addRandomTile();
			break;
			case KeyEvent.VK_DOWN:
			actuateDown();
			addRandomTile();
			break;
			case KeyEvent.VK_LEFT:
			actuateLeft();
			addRandomTile();
			break;
			case KeyEvent.VK_RIGHT:
			actuateRight();
			addRandomTile();
			break;
			default:
			System.out.println("Not supported Key");
			break;
		}
	}

	public void actuateUp(){
		for(int c = 0; c < COLS; c++){
			for(int r = 0; r < ROWS; r++){
				int thisIndex = r*COLS + c;
				int thisState = buttons.get(thisIndex).getState();
				buttons.get(thisIndex).setState(0);
				int []myNeighbors = getNeighbors(thisIndex);
				while(isBlankSpace(myNeighbors[NORTH])){
					thisIndex -= COLS;
					myNeighbors = getNeighbors(thisIndex);
				}
				//myNeighbors = getNeighbors(thisIndex);
				buttons.get(thisIndex).setState(thisState);

				if(myNeighbors[NORTH] != -1 && buttons.get(myNeighbors[NORTH]).getState() == thisState){
					buttons.get(thisIndex).setState(0);
					buttons.get(myNeighbors[NORTH]).setState(thisState+1);
				}

			}
		}
	}

	public void actuateDown(){
		for(int c = 0; c < COLS; c++){
			for(int r = ROWS-1; r >= 0; r--){
				int thisIndex = r*COLS + c;
				int thisState = buttons.get(thisIndex).getState();
				buttons.get(thisIndex).setState(0);
				int []myNeighbors = getNeighbors(thisIndex);
				while(isBlankSpace(myNeighbors[SOUTH])){
					thisIndex += COLS;
					myNeighbors = getNeighbors(thisIndex);
				}
				buttons.get(thisIndex).setState(thisState);
				if(myNeighbors[SOUTH] != -1 && buttons.get(myNeighbors[SOUTH]).getState() == thisState){
					buttons.get(thisIndex).setState(0);
					buttons.get(myNeighbors[SOUTH]).setState(thisState+1);
				}
			}
		}
	}


	public void actuateRight(){
		for(int r = 0; r < ROWS; r++){
			for(int c = ROWS-1; c >= 0; c--){
				int thisIndex = r*COLS + c;
				int thisState = buttons.get(thisIndex).getState();
				buttons.get(thisIndex).setState(0);
				int []myNeighbors = getNeighbors(thisIndex);
				while(isBlankSpace(myNeighbors[EAST])){
					thisIndex += 1;
					myNeighbors = getNeighbors(thisIndex);
				}
				buttons.get(thisIndex).setState(thisState);
				if(myNeighbors[EAST] != -1 && buttons.get(myNeighbors[EAST]).getState() == thisState){
					buttons.get(thisIndex).setState(0);
					buttons.get(myNeighbors[EAST]).setState(thisState+1);
				}
			}
		}
	}

	public void actuateLeft(){
		for(int r = 0; r < ROWS; r++){
			for(int c = 0; c < COLS; c++){
				int thisIndex = r*COLS + c;
				int thisState = buttons.get(thisIndex).getState();
				buttons.get(thisIndex).setState(0);
				int []myNeighbors = getNeighbors(thisIndex);
				while(isBlankSpace(myNeighbors[WEST])){
					thisIndex -= 1;
					myNeighbors = getNeighbors(thisIndex);
				}
				buttons.get(thisIndex).setState(thisState);
				if(myNeighbors[WEST] != -1 && buttons.get(myNeighbors[WEST]).getState() == thisState){
					buttons.get(thisIndex).setState(0);
					buttons.get(myNeighbors[WEST]).setState(thisState+1);
				}
			}
		}
	}

	public void addTestButtons(){
		reset();
		buttons.get(5).setState(1);
		buttons.get(10).setState(2);
		buttons.get(13).setState(1);
	}

	public boolean isBlankSpace(int buttonIndex){
		if(buttonIndex < 0 || buttonIndex > buttons.size()-1)
			return false;

		return (buttons.get(buttonIndex).getState() == 0);
	}

	public void printGrid(){
		for(int a = 0; a < ROWS; a++){
			for(int b = 1; b <= COLS; b++){
				int index = a * COLS + b - 1;
				System.out.print("" + buttons.get(index).getText());
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public void keyReleased(KeyEvent e) {        
	}

	public void addRandomTile(){
		int two_or_four = (int) Math.floor(Math.random() * 2) + 1;
		int randomIndex = 0;
		int count = 0;
		while(randomIndex != -1){
			randomIndex = (int) Math.floor(Math.random() * ROWS * COLS);
			if(isBlankSpace(randomIndex)){
				buttons.get(randomIndex).setState(two_or_four);
				randomIndex = -1;
			}

			if(count < ROWS * COLS){
				count++;
			}
			else{
				reset();
				randomIndex = -1;
			}

		}
	}

	public void actuate(String phrase){
		for(JButton b : buttons){
			if(phrase.equals("UP"))
				b.setBackground(Color.white);
			else if(phrase.equals("DOWN"))
				b.setBackground(Color.black);
			else if(phrase.equals("LEFT"))
				b.setBackground(Color.green);
			else if(phrase.equals("RIGHT"))
				b.setBackground(Color.blue);
		}
	}
}
