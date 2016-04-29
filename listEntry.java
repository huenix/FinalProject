/**
 *
 * @author mwilliams
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.File;
import java.util.Comparator;


public class listEntry {
    public int score;
    public String gameBoard;
    public String name;
    
    public listEntry(String n, int s, String gb)
    {
     //Constructor used to create individual records in the final arraylist
        name = n;  //sets name in listentry record
        score = s;  //sets score in listentry record
        gameBoard = gb;  //sets gameboard in listentry record
    }
   
        public static Comparator<listEntry> scoreComp = new Comparator<listEntry>()
    {
        
        public int compare(listEntry e1, listEntry e2)  //sets up to compare hi scores to help sort
       
        {
            //Sorts the entires based on hi score
            return e2.score-e1.score;
        }
    };
    
}
