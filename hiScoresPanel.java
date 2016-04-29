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
            setBackground(Color.BLUE); //sets background to blue
            setLayout(null);  //sets a null layout
            JLabel title = new JLabel("Hi Score List");  //creates title label
            title.setFont(new Font("Arial", Font.BOLD, 25)); //sets font and size in line with rest of the app
            title.setForeground(Color.white);  //sets text color to white
            title.setBounds(190,-50,300,200);  //sets layout of title
            add(title);
            
            
            /*This code creates the label that displays our classhi score information. Sets the text color to white.
            It also sets the font to Arial, bold size 25 and sets location and adds it*/
            xmlProcess start = new xmlProcess();
            for(int i = 0; i < 10; i++)   //for loop for top 10 entries
            {
                String place = Integer.toString(i + 1);
                int bound = (i * 30) + 50; //variable to keep track of placement
                int scoreList;
                listEntry e = start.hsl.get(i); //reads the score from the list
                scoreList = e.score; 
                JLabel score = new JLabel(place + ". " + start.hsl.get(i).name + " " + scoreList);  //displays score entry
                add(score);
                score.setFont(new Font("Arial", Font.BOLD, 25));  //sets font and size
                score.setForeground(Color.white); //sets text color to white
                score.setBounds(190, bound, 300, 50);  //sets placement of the score
            }}
            


        }

