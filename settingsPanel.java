package fp;


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
    JTextField rn, un;
    
    JLabel labelRealName, labelUserName, labelSpeedSlider;
    JButton settingsButton;
    JSlider setSpeed;
    
    String realName;
    String userName;
    
    int speed = 1;
    
    int next = 0;
    public settingsPanel(){
        
        super();
        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        panel.setBounds(10,10,10,10);
        //panel.setLayout(layout);
        setBackground(Color.BLUE);
        //setLayout(null);

        JLabel title = new JLabel("Game Settings");
        title.setFont(new Font("Arial", Font.BOLD, 75));
        title.setForeground(Color.white);
        //title.setBounds(190,-50,300,200);
        add(title);


// Add fields for the user
        labelRealName = new JLabel("Real Name");
        add(labelRealName);
        rn = new JTextField(realName, 30);
        rn.setEditable(true);
        rn.addActionListener(this);
        add(rn);
        
        labelUserName = new JLabel("User Name");
        add(labelUserName);
        
        un = new JTextField(userName, 30);
        un.setEditable(true);
        un.addActionListener(this);
        add(un);
                
        labelSpeedSlider = new JLabel("Initial Speed");
        
        
        setSpeed = new JSlider(JSlider.HORIZONTAL,1,3,1);
        setSpeed.setBorder(BorderFactory.createTitledBorder("Initial Speed"));
        setSpeed.setMajorTickSpacing(1);
        setSpeed.setPaintTicks(true);
        setSpeed.setPaintLabels(true);
        setSpeed.setLabelTable(setSpeed.createStandardLabels(1));
        add(setSpeed);
        
        
        
        settingsButton = new JButton("Save Settings");
        settingsButton.addActionListener(this);
        
        add(settingsButton);
        

    }
    
    public String getName() {
        if(Objects.equals(null, realName))
            realName = "John Doe";
        
        return(realName);
    }
    public String getUserName() {
        if (Objects.equals(null, userName))
            userName = "Random Player";
        
        return(userName);
    }
    public float getSpeed() {
        return(speed);
    
    }
    public void actionPerformed(ActionEvent e) {
        // linewidth taken from the slider
        Object obj = e.getSource();
        if (obj == settingsButton) {
            realName = rn.getText();
            userName = un.getText();
            speed = setSpeed.getValue();
            System.out.println("Settings Saved: " + realName + " " + userName + " " + speed);
            
        }
        

    }
}

