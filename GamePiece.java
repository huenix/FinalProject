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
		this.currState = currState;
		this.value = (int) Math.pow(2, currState);
		this.setText("" + value);
		switch(currState){
			default: 
				break;
			case 0:
				this.setBackground(Color.white);
				this.setText("");
				break;
			case 1:
				this.setBackground(new Color(255,51,51));
				break;
			case 2:
				this.setBackground(new Color(255,153,51));
				break;
			case 3:
				this.setBackground(new Color(255,255,51));
				break;
			case 4:
				this.setBackground(new Color(153, 255, 51));
				break;
			case 5:
				this.setBackground(new Color(51, 255, 51));
				break;
			case 6:
				this.setBackground(new Color(51, 255, 153));
				break;
			case 7:
				this.setBackground(new Color(51, 255, 255));
				break;
			case 8:
				this.setBackground(new Color(51, 153, 255));
				break;
			case 9:
				this.setBackground(new Color(51, 51, 255));
				break;
			case 10:
				this.setBackground(new Color(153, 51, 255));
				break;
			case 11:
				this.setBackground(new Color(255, 51, 255));
				break;
		}
	}

	public int getState(){
		return currState;
	}

}
	