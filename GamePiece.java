import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;

public class GamePiece extends JButton{

	public int currState;
	public int value;
	
	public GamePiece(){
		super();

		setState(0);
		value = 0;
		setText("" + value);

		setBorderPainted( false );
		setFocusPainted( false );
		setOpaque(true);
	}

	public GamePiece(int currState){
		super();
		this.currState = currState;
		value = (int)Math.pow(2, currState);
		setText("" + value);
	}

	public void setImage(int currState){

	}

	public void setState(int currState){
		switch(currState){
			default: 
				break;
			case 0:
				this.setBackground(Color.gray);
				break;
			case 1:
				this.setBackground(Color.blue);
				break;
			case 2:
				this.setBackground(Color.red);
				break;
			case 3:
				this.setBackground(Color.green);
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				break;
			case 11:
				break;
			case 12:
				break;
		}
		this.currState = currState;
		this.value = (int) Math.pow(2, currState);
		this.setText("" + value);
	}

	public int getState(){
		return currState;
	}

}
	