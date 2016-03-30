import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;

public class ButtonPanel extends JPanel implements KeyListener{
	
	private final int ROWS = 4;
	private final int COLS = 4;
	private final int PAD = 3;
	ArrayList<GamePiece> buttons;
	private int score;
	

	public ButtonPanel()
	{	
		super();
        this.score = 0;
		buttons = new ArrayList<>();
		 this.setLayout(new GridLayout(ROWS, COLS, PAD, PAD));
		 for(int x = ROWS*COLS; x > 0; x--){
			GamePiece a = new GamePiece();
			a.addKeyListener(this);
			buttons.add(a);
			this.add(a);
		 }
	    buttons.get((int) Math.floor(Math.random() * ROWS * COLS)).setState(1);
		 this.addKeyListener(this);
         this.printGrid();
	}

    public void reset(){
        for(GamePiece g : buttons){
            g.setState(0);
        }
        buttons.get((int) Math.floor(Math.random() * ROWS * COLS)).setState(1);
        this.score = 0;
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

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
        
    }

    public void actuate(String phrase){
        for(JButton b : buttons){
        	b.setText(phrase);
        }
    }
}