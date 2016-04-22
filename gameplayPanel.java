import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class gameplayPanel extends JPanel implements KeyListener, ActionListener {
	
	scorePanel score_panel;
	ButtonPanel button_panel;

	public gameplayPanel(){
		super();
		this.setLayout(new BorderLayout());
		score_panel = new scorePanel();
		button_panel = new ButtonPanel();
		this.add(score_panel, "North");
		this.add(button_panel, "Center");
		this.setFocusable(true);
		this.addKeyListener(this);
		button_panel.setFocusable(true);
		button_panel.addKeyListener(this);
		score_panel.setFocusable(true);
		score_panel.addKeyListener(this);
		score_panel.resetButton.addActionListener(this);

		for(GamePiece g : button_panel.buttons){
			g.addKeyListener(this);
		}
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == score_panel.resetButton){
			button_panel.reset();
			score_panel.setScore(0);
		}
	}

	 /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        
    }

    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
	    switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
			if(button_panel.actuateUp())
				button_panel.addRandomTile();
			score_panel.setScore(button_panel.score);
			break;
			case KeyEvent.VK_DOWN:
			if(button_panel.actuateDown())
				button_panel.addRandomTile();
			score_panel.setScore(button_panel.score);
			break;
			case KeyEvent.VK_LEFT:
			if(button_panel.actuateLeft())
				button_panel.addRandomTile();
			score_panel.setScore(button_panel.score);
			break;
			case KeyEvent.VK_RIGHT:
			if(button_panel.actuateRight())
				button_panel.addRandomTile();
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
}