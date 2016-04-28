/**
 *
 * @author jroth
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class designerPanel extends JPanel 
{
 
	public designerPanel()
	{
            super();
            
            //sets background of panel to blue
            setBackground(Color.BLUE);
            //sets layout to null so we can place things wherever we specify
            setLayout(null);
             /*This code creates the label that displays our class information. Sets the text color to white.
            It also sets the font to Arial, bold size 25 and sets location and adds it*/
            JLabel istClass = new JLabel("Spring 2016 * IST 240 * Team 6 * Dan Neal");
            istClass.setFont(new Font("Arial", Font.BOLD, 25));
            istClass.setForeground(Color.white);
            istClass.setBounds(50,10,500,200);
            add(istClass);
            
            
            /*This code creates the label that displays our class information. Sets the text color to white.
            It also sets the font to Arial, bold size 25 and sets location and adds it*/
            JLabel designerName = new JLabel("Game Designers");
            designerName.setFont(new Font("Arial", Font.BOLD, 25));
            designerName.setForeground(Color.white);
            designerName.setBounds(190,60,300,200);
            add(designerName);
            
            
            /*This code creates the label that displays our class information. Sets the text color to white.
            It also sets the font to Arial, italics size 20 and sets location and adds it*/
            JLabel designerName2 = new JLabel("<html>Jessica Roth<br>Dan Strivelli<br>Scott Undercofler<br>Michael Williams</html>");
            designerName2.setFont(new Font("Arial", Font.ITALIC, 20));
            designerName2.setForeground(Color.white);
            designerName2.setBounds(220,125,300,200);
            add(designerName2);
        }
}
