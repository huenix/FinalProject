
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class cardPanel extends JPanel implements ActionListener {
	

	// Constructor for card panel 
	// This builds and adds the cards to
	// the container, which is managed by the 
	// CardLayout layout manager. 
	public cardPanel(){

		// Call the JPanel super constructor
		super();

		// Set the layout of the panel to CardLayout
		this.setLayout(new CardLayout());
		
		// Create and add intro screen panel
		this.add(buildIntroPanel(this), "INTRO");

		// Create and add instructions panel
		this.add(buildInstructionsPanel(this), "INSTRUCTIONS");

		// Create and add game designer panel
		this.add(buildDesignerPanel(this), "DESIGNER");

		// Create and add main gameplay panel
		this.add(buildGamePanel(this), "GAMEPLAY");

	}

	// Function to create the intro panel and then return 
	// the created panel
	public JPanel buildIntroPanel(Container container){

		// Initialize the panel to be returned
		JPanel panel = new JPanel();

		// Initialize descriptive Label
		JLabel introLabel = new JLabel("WELCOME TO MY GAME", JLabel.CENTER);


		// Set panel attributes here
		panel.setLayout(new GridLayout(0,1));
		panel.setBackground(Color.green);

		// Add label and button panel
		panel.add(introLabel);
		panel.add(mainButtonsPanel(this));

		// Return the created panel
		return panel;
	}

	// Function that creates a button panel to navigate through application
	public JPanel mainButtonsPanel(Container container){

		// Initialize the panel that will be returned 
		JPanel buttons = new JPanel(new GridLayout(3,1));
		
		// Define the first button and it's action
		// which is to navigate to the instructions panel
		JButton b1 = new JButton("Read Instructions");
		CardLayout cardLayout = (CardLayout) container.getLayout();
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cardLayout.show(container, "INSTRUCTIONS");
			}
		});

		// Define the second button and it's action
		// which is to navigate to the designer panel
		JButton b2 = new JButton("About Designer");
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cardLayout.show(container, "DESIGNER");
			}
		});
		
		// Define the third button and it's action
		// which is to navigate to the gameplay panel
		JButton b3 = new JButton("Play Game");
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cardLayout.show(container, "GAMEPLAY");
			}
		});


		// Add each button to the panel
		buttons.add(b1);
		buttons.add(b2);
		buttons.add(b3);

		// Return the panel
		return buttons;
	}

	// Function to create the Instructions panel
	public JPanel buildInstructionsPanel(Container container){
		// Create the panel to be returned
		JPanel panel = new JPanel();

		// Set panel attributes
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.yellow);

		// Create panel elements
		JLabel instructionsLabel = new JLabel("INSTRUCTIONS SCREEN", JLabel.CENTER);
		JButton homeButton = new JButton("GO HOME");

		// Add home button action to home button
		homeButton.addActionListener(this);

		// Add elements to panel
		panel.add(homeButton, "North");
		panel.add(instructionsLabel, "Center");
		
		// Return panel
		return panel;
	}

	// Function to create the Designer panel
	public JPanel buildDesignerPanel(Container container){
		// Create the panel to be returned
		JPanel panel = new JPanel();

		// Set panel attributes
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.blue);

		// Create panel elements
		JLabel instructionsLabel = new JLabel("DESIGNER SCREEN", JLabel.CENTER);
		JButton homeButton = new JButton("GO HOME");
		
		// Add home button action to home button
		homeButton.addActionListener(this);

		// Add elements to panel
		panel.add(instructionsLabel, "Center");
		panel.add(homeButton, "North");
		
		// Return panel
		return panel;
	}
	

	// Function to build Gameplay panel 
	public JPanel buildGamePanel(Container container){

		// Create panel to be returned
		JPanel panel = new JPanel();

		// Set panel attributes
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.orange);

		// Create panel elements
		JLabel instructionsLabel = new JLabel("GAMEPLAY SCREEN", JLabel.CENTER);
		JButton homeButton = new JButton("GO HOME");

		// Add home button action to home button
		homeButton.addActionListener(this);

		// Add elements to panel
		panel.add(homeButton, "North");
		panel.add(instructionsLabel, "Center");

		// Return panel
		return panel;
	}


	// Function that gets called when home buttons are clicked
	// realized throught the ActionListener interface
	// implemented in the cardPanel class
	public void actionPerformed(ActionEvent e){
		// Get the cardLayout
		CardLayout cardLayout = (CardLayout) this.getLayout();
		// Show the intro panel
		cardLayout.show(this, "INTRO");
	}


}