/**
 *
 * @author sundercofler
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.*;


// Class that represents the settings panel within the game
// This panel will be responsible for taking in all user
// inputs before reaching the gameplay screen
public class settingsPanel extends JPanel implements ActionListener
{
    // Instantiation of panel elements
    JTextField rn;
    JLabel labelRealName, labelUserName, labelSpeedSlider;
    JButton settingsButton;
    JSlider setSpeed;
    
    // Name is user property to be inputted and moved into the game panel
    String realName;
    
    int speed = 1;
    int next = 0;

    // Constructor for this panel
    public settingsPanel(){
        
        super();
        
        // Set the layout for the panel to box layout
        // which will fix elements to an axis
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        // Set various panel/component attributes 
        setBackground(Color.BLUE);

        JLabel title = new JLabel("Game Settings");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 75));
        title.setForeground(Color.white);
        add(title);


        // Add fields for the user
        labelRealName = new JLabel("Name");
        labelRealName.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelRealName.setForeground(Color.white);
        add(labelRealName);
        rn = new JTextField(realName, 30);
        rn.setAlignmentX(Component.CENTER_ALIGNMENT);
        rn.setMaximumSize( rn.getPreferredSize() );
        rn.setEditable(true);
        rn.addActionListener(this);
        add(rn);
                
        labelSpeedSlider = new JLabel("Initial Speed");
        
        
        setSpeed = new JSlider(JSlider.HORIZONTAL,1,4,1);
        setSpeed.setBorder(BorderFactory.createTitledBorder("Initial Speed"));
        setSpeed.setMajorTickSpacing(1);
        setSpeed.setPaintTicks(true);
        setSpeed.setPaintLabels(true);
        setSpeed.setLabelTable(setSpeed.createStandardLabels(1));
        setSpeed.setMaximumSize( setSpeed.getPreferredSize() );
        setSpeed.setAlignmentX(Component.CENTER_ALIGNMENT);
        setSpeed.setForeground(Color.white);
        add(setSpeed);
        
        
        
        settingsButton = new JButton("Play Game");
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingsButton.addActionListener(this);
        
        add(settingsButton);
        

    }

    // Method to get name variable from settings page
    // Will be utilized by the card panel to move name to 
    // gameplay panel and will eventually be used for XML
    public String getName() {
        // If no name is given ("" in textfield)
        // return John Doe as name
        if(Objects.equals(null, rn.getText()))
            realName = "John Doe";
        else 
            realName = rn.getText();
        return(realName);
    }
  
    // Accessor for speed of timer
    public float getSpeed() {
        return(speed);
    
    }

    // Method that gets called when button gets clicked
    // This method will set the name variable accordingly
    // and prepare us to transition to the gameplay card
    public void actionPerformed(ActionEvent e) {
        // linewidth taken from the slider
        Object obj = e.getSource();
        if (obj == settingsButton) {
            realName = rn.getText();
            speed = setSpeed.getValue() * 1000;            
        }
    
    }
}

