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


public class instructionsPanel extends JPanel 
{
 
	public instructionsPanel()
	{
            super();
            setLayout(null);
            setBackground(Color.BLUE);
            
             /*This code creates the label that asks how to play game.Sets the text color to white.
            It also sets the font to Arial, bold size 22 and sets location and adds it*/
            JLabel goal1 = new JLabel("<html>The goal of this game is to combine <br>the tiles to add up to the number 2048</html>");
            goal1.setFont(new Font("Arial", Font.BOLD, 22));
            goal1.setForeground(Color.white);
            goal1.setBounds(100, 10, 500, 50);
            add(goal1);
            
            
            /*This code creates the label that asks how to play game.Sets the text color to white,
            It also sets the font to Arial, bold size 20 and sets location and adds it*/
            JLabel howTo1 = new JLabel("* How do I play this awesome game?");
            howTo1.setFont(new Font("Arial", Font.BOLD, 20));
            howTo1.setForeground (Color.white);
            howTo1.setBounds(10,85,400,25);
            add(howTo1);
            
            
             /*This code creates the label that asks how to play game. Sets the text color to white.
            It also sets the font to Arial, bold size 15 and sets location and adds it*/
            JLabel howTo2 = new JLabel("- Move the arrows on your keyboard to move and combine game pieces with like numbers");
           
            howTo2.setFont(new Font("Arial", Font.BOLD, 15));
            howTo2.setForeground (Color.white);
            howTo2.setBounds(35,105,600,25);
            add(howTo2);
            
            
             /*This code creates the label that asks how to play game. Sets the text color to white.
            It also sets the font to Arial, bold size 20 and sets location and adds it*/
            JLabel saveGame1 = new JLabel("* How do I save my game?");
            saveGame1.setFont(new Font("Arial", Font.BOLD, 20));
            saveGame1.setForeground (Color.white);
            saveGame1.setBounds(10,150,600,25);
            add(saveGame1);
            
            
            /*This code creates the label that asks how to play game. Sets the text color to white.
            It also sets the font to Arial, bold size 15 and sets location and adds it*/
            JLabel saveGame2 = new JLabel("- The save button is located in the menu bar under 'File');
            saveGame2.setFont(new Font("Arial", Font.BOLD, 15));
            saveGame2.setForeground (Color.white);
            saveGame2.setBounds(35,170,600,25);
            add(saveGame2);
            
            
            
             /*This code creates the label that asks how to play game.Sets the text color to white.
            It also sets the font to Arial, bold size 20 and sets location and adds it*/
            JLabel loadGame1 = new JLabel("* I've already played! How do I load my saved game?");
            loadGame1.setFont(new Font("Arial", Font.BOLD, 20));
            loadGame1.setForeground (Color.white);
            loadGame1.setBounds(10,215,600,25);
            add(loadGame1);
            
            
            
            /*This code creates the label that asks how to play game. Sets the text color to white.
            It also sets the font to Arial, bold size 15 and sets location and adds it*/
            JLabel loadGame2 = new JLabel("- Click the 'load button' in the menu bar under 'File'");
            loadGame2.setFont(new Font("Arial", Font.BOLD,15));
            loadGame2.setForeground (Color.white);
            loadGame2.setBounds(35,235,600,25);
            add(loadGame2);
            
            
            
            
             /*This code creates the label that asks how to play game. Sets the text color to white.
            It also sets the font to Arial, bold size 20 and sets location and adds it*/
            JLabel resetGame1 = new JLabel("* I'm not doing very well.. Can I start over?");
            resetGame1.setFont(new Font("Arial", Font.BOLD, 20));
            resetGame1.setForeground (Color.white);
            resetGame1.setBounds(10,280,600,25);
            add(resetGame1);
            
            
            
            /*This code creates the label that asks how to play game.Sets the text color to white.
            It also sets the font to Arial, bold size 15 and sets location and adds it*/
            JLabel resetGame2 = new JLabel("- Of course! Click 'reset' at the top of the game");
            resetGame2.setFont(new Font("Arial", Font.BOLD,15));
            resetGame2.setForeground (Color.white);
            resetGame2.setBounds(35,300,600,25);
            add(resetGame2);
         
	}
        
}
 
