import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.util.ArrayList;
import java.io.*;

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

	public Image getImage(String imagePath){
		try {
			return ImageIO.read(getClass().getClassLoader().getResource(imagePath));
		} catch (IOException exp) {
			exp.printStackTrace();
			return null;
		}
	}

	public void setState(int currState){
		this.currState = currState;
		this.value = (int) Math.pow(2, currState);
		//this.setText("" + value);
		int bWidth = 150;
		int bHeight = 75;
		if(this.getWidth() * this.getHeight() > 0){
			bWidth = this.getWidth();
			bHeight = this.getHeight();
		}
		Image img = null;
		ImageIcon a = null;
		switch(currState){
			default: 
				break;
			case 0:
				this.setIcon(null);
				this.setBackground(Color.white);
				this.setText(null);
				break;
			case 1:
				a = new ImageIcon("pics/beaverstadium3.jpg");
				this.setBackground(new Color(255,51,51));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 2:
				a = new ImageIcon("pics/creamery1.jpg");
				this.setBackground(new Color(255,153,51));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 3:
				a = new ImageIcon("pics/joepa2.jpg");
				this.setBackground(new Color(255,255,51));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 4:
				a = new ImageIcon("pics/mm1.jpg");
				this.setBackground(new Color(153, 255, 51));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 5:
				a = new ImageIcon("pics/nittanylion2.jpg");
				this.setBackground(new Color(51, 255, 51));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 6:
				a = new ImageIcon("pics/oldmain.jpg");
				this.setBackground(new Color(51, 255, 153));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 7:
				a = new ImageIcon("pics/THON2.jpg");
				this.setBackground(new Color(51, 255, 255));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 8:
				a = new ImageIcon("pics/bb1.jpg");
				this.setBackground(new Color(51, 153, 255));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 9:
				a = new ImageIcon("pics/nittanylion1.jpg");
				this.setBackground(new Color(51, 51, 255));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 10:
				a = new ImageIcon("pics/weare1.jpg");
				this.setBackground(new Color(153, 51, 255));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				break;
			case 11:
				a = new ImageIcon("pics/ist1.jpg");
				this.setBackground(new Color(255, 51, 255));
				img = a.getImage().getScaledInstance( bWidth, bHeight, java.awt.Image.SCALE_SMOOTH );
				this.setIcon(new ImageIcon(img));
				// Call win function maybe pop dialog with message
				break;
		}
	}

	

	public int getState(){
		return currState;
	}

}
	