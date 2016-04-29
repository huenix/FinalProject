/**
 *
 * @author mwilliams
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;



public class xmlProcess
{
    /*Create the Arraylist and the entries for the array to hold the top scores, names, and gameboards. The array
    list is going to hold multiple 2d arrays consisting of a complete record*/
    listEntry[] hiScore = new listEntry[1];
    ArrayList<listEntry> hsl = new ArrayList<listEntry>();
    int score;
    String gameBoard;
    
    public xmlProcess()
    {
        /* Checks to see if XML file exists, if it does, it will load the contents of the XML file to the arraylist
        It will also take the list and sort it according to hi score
        If the file doesnt exist at the time, it will create the file and fill it in with filler names and scores */
        File g = new File("gameBoard.xml");
        XML_240 x = new XML_240();
        if(g.exists()){    
            x.openReaderXML("gameBoard.xml");
            for(int i = 0; i < 10; i++){   //for loop for top 10 hi scores
            String n = (String) x.ReadObject(); //read first entry, commit to name
            int s = (int) x.ReadObject(); //read second entry, commit to score
            String gb = (String) x.ReadObject(); //read third entry, commit to gameboard save
            hsl.add(new listEntry(n,s,gb)); //adds the whole thing into a listentry array, then into the array list
        }
        Collections.sort(hsl, listEntry.scoreComp); //sort the arraylist by score
        } 
        else{
        x.openWriterXML("gameBoard.xml");
        for(int i = 0; i < 10; i++)   //for loop to fill in XML file for creation
        {
        x.writeObject("John"); //add John as name
        x.writeObject(0); //add 0 as score
        x.writeObject("0000100200000020"); //add basic 16 character string for gameboard
        hsl.add(new listEntry("John", 0,"0000100200000020")); //adds all entries to the arraylist for tracking
        }
        x.closeWriterXML();
        }
        
    }
    public void xmlClose(String name, int score, String gb)
    {
     /* This will take the information in the arraylist and write it in order to the XML file
     This will also write the latest gameboard to the XML for easy loading*/
        hsl.add(new listEntry(name,score,gb));
        XML_240 x = new XML_240();
        Collections.sort(hsl, listEntry.scoreComp); //sort the arraylist by score
        x.openWriterXML("gameBoard.xml");
        for(int i = 0; i < 10; i++) //for loop for top 10 hi scores
        {
            x.writeObject(hsl.get(i).name); //takes name from memory and commits to XML
            System.out.println(hsl.get(i).name);
            x.writeObject(hsl.get(i).score); //takes score from memory and commits to XML
            System.out.println(hsl.get(i).score);
            x.writeObject(gb); //takes gameboard and saves it to the XML file
        }
        x.closeWriterXML();
    }
    public void xmlLoad(String name)
    {
        //Reads the XML file and loads the gameboard in the form of a 16 character string marking each piece on the gameboard
        XML_240 x = new XML_240();
        x.openReaderXML("gameBoard.xml");
        name = (String) x.ReadObject();  //reads name from the XML and loads into memory
        score = (int) x.ReadObject();  //reads score from the XML and loads into memory
        gameBoard = (String) x.ReadObject();  //reads gameboard from the XML and loads into memory
        x.closeReaderXML();
            }
            

}

