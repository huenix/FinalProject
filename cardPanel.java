package fp;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class cardPanel extends JPanel implements ActionListener {
	
	public gameplayPanel gp;
        public settingsPanel s;

	// Constructor for card panel 
	// This builds and adds the cards to
	// the container, which is managed by the 
	// CardLayout layout manager. 
	

	public cardPanel(JFrame f){

		// Call the JPanel super constructor
		super();
		// Set the layout of the panel to CardLayout
		this.setLayout(new CardLayout());

		f.setJMenuBar(buildMenuBar());
		
		// Create and add intro screen panel
		this.add(buildIntroPanel(this), "INTRO");

		// Create and add instructions panel
		this.add(buildInstructionsPanel(this), "INSTRUCTIONS");

		// Create and add game designer panel
		this.add(buildDesignerPanel(this), "DESIGNER");

		// Create and add main gameplay panel
		gp = (gameplayPanel)buildGamePanel();
		this.add(gp, "GAMEPLAY");

        // Create and add Hi Scores panel
                this.add(buildHiScoresPanel(this),"SCORES");

        // Create and add settings Panel
                s = (settingsPanel)buildSettingsPanel();
		this.add(s,"SETTINGS");

	}

	// Function that creates the menu bar that will be used
	// for navigation across all game screens
	public JMenuBar buildMenuBar(){
		JMenuBar menu = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem saveButton = new JMenuItem("Save..");
		JMenuItem loadButton = new JMenuItem("Load..");
		saveButton.addActionListener(this);
		loadButton.addActionListener(this);
		fileMenu.add(saveButton);
		fileMenu.add(loadButton);

		JMenu windowMenu = new JMenu("Window");
		JMenuItem introButton = new JMenuItem("Intro Screen");
		JMenuItem  instructionsButton = new JMenuItem("Instructions");
		JMenuItem  settingsButton = new JMenuItem("Settings");
		JMenuItem  designerButton = new JMenuItem("About");
		JMenuItem  hiScoresButton = new JMenuItem("Hi Scores");
		JMenuItem  gameplayButton = new JMenuItem("Game Screen");

		introButton.addActionListener(this);
		settingsButton.addActionListener(this);
		instructionsButton.addActionListener(this);
		designerButton.addActionListener(this);
		hiScoresButton.addActionListener(this);
		gameplayButton.addActionListener(this);

		windowMenu.add(introButton);
		windowMenu.add(instructionsButton);
		windowMenu.add(designerButton);
		windowMenu.add(gameplayButton);
		windowMenu.add(hiScoresButton);
		windowMenu.add(settingsButton);

		menu.add(fileMenu);
		menu.add(windowMenu);

		return menu;
		
	}

	// Function to create the intro panel and then return 
	// the created panel
	public JPanel buildIntroPanel(Container container){
		introPanel panel = new introPanel();
		panel.playButton.addActionListener(this);
		panel.instructionsButton.addActionListener(this);
		panel.hiscoresButton.addActionListener(this);
		panel.designersButton.addActionListener(this);
		return panel;
	}

	
	// Function to create the Instructions panel
	public JPanel buildInstructionsPanel(Container container){
		return new instructionsPanel();
	}

	// Function to create the Designer panel
	public JPanel buildDesignerPanel(Container container){
		return new designerPanel();
	}
	

	// Function to build Gameplay panel 
	public JPanel buildGamePanel(){

		return new gameplayPanel();
	}

        //Function to build hi scores panel
	public JPanel buildHiScoresPanel(Container container){
		return new hiScoresPanel();
	}

	public JPanel buildSettingsPanel(){
		
		return new settingsPanel();
		
	}

        //Builds hi score list and orders appropriately


	// Function that gets called when home buttons are clicked
	// realized throught the ActionListener interface
	// implemented in the cardPanel class
	public void actionPerformed(ActionEvent e){
		// Get the cardLayout
		if(e.getSource() instanceof JMenuItem){
			CardLayout cardLayout = (CardLayout) this.getLayout();
			String whichMenu = ((JMenuItem)e.getSource()).getText();
			if(whichMenu.equals("Save..")){
				xmlProcess close = new xmlProcess();
				close.xmlClose(s.getName(),gp.score_panel.getScore(),gp.button_panel.getGameBoard());
                                
			} else if (whichMenu.equals("Load..")){
                                xmlProcess load = new xmlProcess();
                                load.xmlLoad(s.getName());
				int s = load.score;
				gp.score_panel.setScore(s);
				String b = load.gameBoard;
				gp.button_panel.setGameBoard(b);

			} else if (whichMenu.equals("Intro Screen")){
                                gp.stopTimer();
				cardLayout.show(this, "INTRO");
			} else if (whichMenu.equals("Instructions")){
                                gp.stopTimer();
				cardLayout.show(this, "INSTRUCTIONS");
			} else if (whichMenu.equals("About")){
                                gp.stopTimer();
				cardLayout.show(this, "DESIGNER");
			} else if (whichMenu.equals("Game Screen")){
                                gp.startTimer();
				cardLayout.show(this, "GAMEPLAY");
			} else if (whichMenu.equals("Hi Scores")){
                                gp.stopTimer();
                                this.add(buildHiScoresPanel(this),"SCORES");
                            	cardLayout.show(this, "SCORES");
			} else if (whichMenu.equals("Settings")){
                                gp.stopTimer();
				cardLayout.show(this, "SETTINGS");
			}
		}
		else if (e.getSource() instanceof JButton){
			JButton a = (JButton) e.getSource();
			CardLayout cardLayout = (CardLayout) this.getLayout();
			if(a.getText().equals("Play Game")){
                                gp.startTimer();
				cardLayout.show(this, "GAMEPLAY");	
			}
			else if(a.getText().equals("START HERE")){
                                gp.stopTimer();
				cardLayout.show(this, "SETTINGS");	
			}
			else if(a.getText().equals("Instructions")){
                                gp.stopTimer();
				cardLayout.show(this, "INSTRUCTIONS");	
			}
			else if(a.getText().equals("Game Designers")){
                                gp.stopTimer();
				cardLayout.show(this, "DESIGNER");	
			}
			else if(a.getText().equals("Hi Scores")){
                            gp.stopTimer();
                            this.add(buildHiScoresPanel(this),"SCORES");
				cardLayout.show(this, "SCORES");	
			}
		}
	}


}