import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;

public class ButtonPanel extends JPanel implements KeyListener{
	
	private final int ROWS = 4;
	private final int COLS = 4;
	private final int PAD = 3;
	ArrayList<JButton> buttons;
	private int score;
	

	public ButtonPanel()
	{	
		super();
		buttons = new ArrayList<>();
		 this.setLayout(new GridLayout(ROWS, COLS, PAD, PAD));
		 for(int x = ROWS*COLS; x > 0; x--){
			GamePiece a = new GamePiece();
			a.addKeyListener(this);
			a.setBorderPainted( false );
			a.setFocusPainted( false );
            a.setState((int) Math.floor(Math.random() * 4));
            a.setOpaque(true);
			buttons.add(a);
			this.add(a);
		 }
		 //this.setFocusable(true);
		 this.addKeyListener(this);
	}

	 /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        
    }

    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
        	case KeyEvent.VK_UP:
        		actuate("UP");
        		break;
        	case KeyEvent.VK_DOWN:
        		actuate("DOWN");
        		break;
        	case KeyEvent.VK_LEFT:
        		actuate("LEFT");
        		break;
        	case KeyEvent.VK_RIGHT:
        		actuate("RIGHT");
        		break;
        	default:
        		System.out.println("Not supported Key");
        		break;
        }
    }

    

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
        
    }

    public void actuate(String phrase){
        for(JButton b : buttons){
        	b.setText(phrase);
        }
    }
}