/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 /**
 *
 * @author scottu
 */
 
 public class ScorePanel extends JPanel implements KeyListener{
     //Set up variables
    public JButton saveGame, loadGame, restart;
    JTextArea gameTitle, profileName, score, topScore, timeLeft;
    public ScorePanel() {
        // No layouts yet. I will get to it. Maybe. Don't hold your breath
        setBackground(Color.yellow);
        
        // Add in the text areas for stuff and things 
        
        gameTitle = new JTextArea(5,20);
        profileName = new JTextArea(5,20);
        score = new JTextArea(5,10);
        topScore = new JTextArea(5,10);
        timeLeft = new JTextArea(5,8);
        
        // None of these are editable. 
        gameTitle.setEditable(false);
        profileName.setEditable(false);
        score.setEditable(false);
        topScore.setEditable(false);
        timeLeft.setEditable(false);
        this.setFocusable(true);
        this.addKeyListener(this);
        
        
        // Three buttons for score, timer and to stop
        saveGame = new JButton("Save");
        loadGame = new JButton("Load");
        restart = new JButton("Restart");
       
        add(saveGame);
        add(loadGame);
        add(restart);
    }
    
    public void setTopScore(int points) {
        // Function to change the current score
        topScore.setText("Top: " + points);
        
    }
    public void setScore(int points) {
        //Function to change the current time left
        score.setText("Score: " + points);
    }
    
    public void setProfileName(String name) {
       topScore.setText("User: " + name);
       
   }

    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        
    }

    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
        
    }
    
 
 }