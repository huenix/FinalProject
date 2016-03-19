import java.awt.*;
import javax.swing.*;

public class myJFrame extends JFrame
{
	// Declare the panel that will hold the 
	// cards for the application
	cardPanel cp;

	public myJFrame ()
	{
		// Call the super constructor JFrame
		// to instantiate the window
		super ("Assignment 08");
//------------------------------------------------------
// Create components
		// instantiate the card panel object
		// which will build the panel according
		// to the instructions in the cardPanel constructor
    	cp = new cardPanel(this);
//------------------------------------------------------
// Choose a Layout for JFrame and 
// add Jpanel to JFrame according to layout    	
		getContentPane().setLayout(new BorderLayout());

		// Add the card panel to the window
		getContentPane().add(cp,"Center");
//------------------------------------------------------
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (640, 480);
		setVisible(true);
	}
}
