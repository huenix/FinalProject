
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class cardPanel extends JPanel implements ActionListener {
	

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
		this.add(buildGamePanel(this), "GAMEPLAY");

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
		JMenuItem  designerButton = new JMenuItem("About");
		JMenuItem  gameplayButton = new JMenuItem("Game Screen");
	
		introButton.addActionListener(this);
		instructionsButton.addActionListener(this);
		designerButton.addActionListener(this);
		gameplayButton.addActionListener(this);

		windowMenu.add(introButton);
		windowMenu.add(instructionsButton);
		windowMenu.add(designerButton);
		windowMenu.add(gameplayButton);


		menu.add(fileMenu);
		menu.add(windowMenu);

		return menu;
		
	}

	// Function to create the intro panel and then return 
	// the created panel
	public JPanel buildIntroPanel(Container container){
		return new introPanel();
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
	public JPanel buildGamePanel(Container container){

            return gp;
	}

		gameplayPanel gp = new gameplayPanel();
	// Function that gets called when home buttons are clicked
	// realized throught the ActionListener interface
	// implemented in the cardPanel class
	public void actionPerformed(ActionEvent e){
		// Get the cardLayout
		if(e.getSource() instanceof JMenuItem){
			CardLayout cardLayout = (CardLayout) this.getLayout();
			String whichMenu = ((JMenuItem)e.getSource()).getText();
			if(whichMenu.equals("Save..")){
				System.out.println("SAVE CLICKED");
                                XML_240 x = new XML_240();
                                x.openWriterXML("saveData.xml");
                                x.writeObject(gp.score_panel.score);
                                x.closeWriterXML();
                                x.openWriterXML("gameBoard.xml");
                                x.writeObject(gp.button_panel.getGameBoard());
                                System.out.println(gp.button_panel.getGameBoard());
                                x.closeWriterXML();
			} else if (whichMenu.equals("Load..")){
				System.out.println("LOAD CLICKED");
                                XML_240 x = new XML_240();
                                x.openReaderXML("saveData.xml");
                                int s = (int) x.ReadObject();
                                x.closeReaderXML();
                                x.openReaderXML("gameBoard.xml");
                                String b = (String) x.ReadObject();
                                gp.button_panel.setGameBoard(b);
                                x.closeReaderXML();
                        } else if (whichMenu.equals("Intro Screen")){
				cardLayout.show(this, "INTRO");
			} else if (whichMenu.equals("Instructions")){
				cardLayout.show(this, "INSTRUCTIONS");
			} else if (whichMenu.equals("About")){
				cardLayout.show(this, "DESIGNER");
			} else if (whichMenu.equals("Game Screen")){
				cardLayout.show(this, "GAMEPLAY");
			} 
		}
	}


}