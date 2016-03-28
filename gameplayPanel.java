import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class gameplayPanel extends JPanel{
	
	ScorePanel score_panel;

	public gameplayPanel(){
		super();
		this.setLayout(new BorderLayout());
		score_panel = new ScorePanel();
		this.add(score_panel, "North");
	}
}