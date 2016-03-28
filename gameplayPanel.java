import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class gameplayPanel extends JPanel implements KeyListener{
	
	ScorePanel score_panel;
	ButtonPanel button_panel;

	public gameplayPanel(){
		super();
		this.setLayout(new BorderLayout());
		score_panel = new ScorePanel();
		button_panel = new ButtonPanel();
		this.add(score_panel, "North");
		this.add(button_panel, "Center");
		this.setFocusable(true);
		this.addKeyListener(this);
		button_panel.setFocusable(true);
		button_panel.addKeyListener(this);
		score_panel.setFocusable(true);
		score_panel.addKeyListener(this);

	}

	 /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        
    }

    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
        
    }
}