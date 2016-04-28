
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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



public class settingsPanel extends JPanel implements ActionListener
{
    JTextField rn;
    
    JLabel labelRealName, labelUserName, labelSpeedSlider;
    JButton settingsButton;
    JSlider setSpeed;
    
    String realName;
    
    int speed = 1;
    
    int next = 0;
    public settingsPanel(){
        
        super();
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        setBackground(Color.BLUE);
        

        JLabel title = new JLabel("Game Settings");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 75));
        title.setForeground(Color.white);
        //title.setBounds(190,-50,300,200);
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
    
    public String getName() {
        if(Objects.equals(null, rn.getText()))
            realName = "John Doe";
        else 
            realName = rn.getText();
        return(realName);
    }
  
    public float getSpeed() {
        return(speed);
    
    }
    public void actionPerformed(ActionEvent e) {
        // linewidth taken from the slider
        Object obj = e.getSource();
        if (obj == settingsButton) {
            realName = rn.getText();
            speed = setSpeed.getValue() * 1000;
            System.out.println("Settings Saved: " + realName + " " + speed);
            
        }
        

    }
}

