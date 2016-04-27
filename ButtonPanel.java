import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.Set;

public class ButtonPanel extends JPanel {//implements KeyListener{
	
	private final int ROWS = 4;
	private final int COLS = 4;
	private final int PAD = 3;

	private final int NORTH = 0;
	private final int WEST = 1;
	private final int EAST = 2;
	private final int SOUTH = 3;

	public ArrayList<GamePiece> buttons;
	int score;
	

	public ButtonPanel()
	{   
		super();
		this.score = 0;
		this.setBackground(Color.orange);
		buttons = new ArrayList<>();
		this.setLayout(new GridLayout(ROWS, COLS, PAD, PAD));
		for(int x = 0; x < ROWS* COLS; x++){
			GamePiece a = new GamePiece();
			//a.addKeyListener(this);
			a.setText("" + x);
			buttons.add(a);
			this.add(a);
		}
		reset();
		//buttons.get((int) Math.floor(Math.random() * ROWS * COLS)).setState(1);
	}

	public void reset(){
		for(GamePiece g : buttons){
			g.setState(0);
		}
		//buttons.get((int) Math.floor(Math.random() * ROWS * COLS)).setState(1);
		this.score = 0;
		addRandomTile();
		addRandomTile();
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

	public boolean actuateUp(){
		boolean goOn = false;
		for(int c = 0; c < COLS; c++){
			for(int r = 0; r < ROWS; r++){
				int thisIndex = r*COLS + c;
				int thisState = buttons.get(thisIndex).getState();
				buttons.get(thisIndex).setState(0);
				int []myNeighbors = getNeighbors(thisIndex);
				while(isBlankSpace(myNeighbors[NORTH])){
					thisIndex -= COLS;
					myNeighbors = getNeighbors(thisIndex);
					goOn = true;
				}
				//myNeighbors = getNeighbors(thisIndex);
				buttons.get(thisIndex).setState(thisState);

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
		return goOn;
	}

	public boolean actuateDown(){
		boolean goOn = false;
		for(int c = 0; c < COLS; c++){
			for(int r = ROWS-1; r >= 0; r--){
				int thisIndex = r*COLS + c;
				int thisState = buttons.get(thisIndex).getState();
				buttons.get(thisIndex).setState(0);
				int []myNeighbors = getNeighbors(thisIndex);
				while(isBlankSpace(myNeighbors[SOUTH])){
					thisIndex += COLS;
					myNeighbors = getNeighbors(thisIndex);
					goOn = true;
				}
				buttons.get(thisIndex).setState(thisState);
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
		return goOn;
	}


	public boolean actuateRight(){
		boolean goOn = false;
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
		return goOn;
	}

	public boolean actuateLeft(){
		boolean goOn = false;
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
		return goOn;
	}


	public boolean isBlankSpace(int buttonIndex){
		if(buttonIndex < 0 || buttonIndex > buttons.size()-1)
			return false;

		return (buttons.get(buttonIndex).getState() == 0);
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
				youLost();
				randomIndex = -1;
			}

		}
	}

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

