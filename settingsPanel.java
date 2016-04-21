package app;

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



public class settingsPanel extends JPanel implements ChangeListener
{
    JTextField fn, ln, ispeed, jt1,jt2, jt3;
    JButton settingsButton;
    JSlider setSpeed;
    
    String firstName;
    String lastName;
    
    float speed;
    
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
        fn = new JTextField("Real Name", 10);
        fn.setEditable(false);
        add(fn);

        jt1 = new JTextField(firstName, 30);
        jt1.setEditable(true);
        add(jt1);
        
        ln = new JTextField("User Name", 10);
        ln.setEditable(true);
        add(ln);

        jt2 = new JTextField(lastName, 30);
        jt2.setEditable(true);
        add(jt2);
                
        ispeed = new JTextField("Initial Speed", 10);
        ispeed.setEditable(false);
        add(ispeed);
        
        setSpeed = new JSlider(JSlider.HORIZONTAL,1,3,1);
        setSpeed.setBorder(BorderFactory.createTitledBorder("Initial Speed"));
        setSpeed.setMajorTickSpacing(1);
        setSpeed.setPaintTicks(true);
        setSpeed.setPaintLabels(true);
        setSpeed.setLabelTable(setSpeed.createStandardLabels(1));
        add(setSpeed);
        
        
        
        settingsButton = new JButton("Save Settings");
        add(settingsButton);
        

    }
    
    public String getName() {
        String fullName = firstName + " " + lastName;
        return(fullName);
    }
    public float getSpeed() {
        return(speed);
    
    }
    public void stateChanged(ChangeEvent e) {
        // linewidth taken from the slider
    
        speed = setSpeed.getValue();
         // This sets the currWidth
        System.out.println("Setting speed  to " + speed);

    }
}

