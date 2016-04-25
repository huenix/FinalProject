/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jroth
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;



public class hiScoresPanel extends JPanel 
{

	public hiScoresPanel()
	{
            super();
            setBackground(Color.BLUE);
            setLayout(null);
            JLabel title = new JLabel("Hi Score List");
            title.setFont(new Font("Arial", Font.BOLD, 25));
            title.setForeground(Color.white);
            title.setBounds(190,-50,300,200);
            add(title);
            
            
            /*This code creates the label that displays our class information. Sets the text color to white.
            It also sets the font to Arial, bold size 25 and sets location and adds it*/
            xmlProcess start = new xmlProcess();
            for(int i = 0; i < 10; i++)
            {
                String place = Integer.toString(i + 1);
                int bound = (i * 30) + 50;
                int scoreList;
                listEntry e = start.hsl.get(i);
                scoreList = e.score;
                JLabel score = new JLabel(place + ". " + start.hsl.get(i).name + " " + scoreList);
                add(score);
                score.setFont(new Font("Arial", Font.BOLD, 25));
                score.setForeground(Color.white);
                score.setBounds(190, bound, 300, 50);
            }}
            


        }

