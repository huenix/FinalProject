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
    listEntry[] hiScore = new listEntry[1];
    ArrayList<listEntry> hsl = new ArrayList<listEntry>();
    int score;
    String gameBoard;
    
    public xmlProcess()
    {
        File g = new File("gameBoard.xml");
        XML_240 x = new XML_240();
        if(g.exists()){    
            x.openReaderXML("gameBoard.xml");
            for(int i = 0; i < 10; i++){
            String n = (String) x.ReadObject();
            int s = (int) x.ReadObject();
            String gb = (String) x.ReadObject();
            hsl.add(new listEntry(n,s,gb));
        }
        Collections.sort(hsl, listEntry.scoreComp);
        } 
        else{
        x.openWriterXML("gameBoard.xml");
        for(int i = 0; i < 10; i++)
        {
        x.writeObject("John");
        x.writeObject(0);
        x.writeObject("0000100200000020");
        hsl.add(new listEntry("John", 0,"0000100200000020"));
        }
        x.closeWriterXML();
        }
        
    }
    public void xmlClose(String name, int score, String gb)
    {
        hsl.add(new listEntry(name,score,gb));
        XML_240 x = new XML_240();
        Collections.sort(hsl, listEntry.scoreComp);
        x.openWriterXML("gameBoard.xml");
        for(int i = 0; i < 10; i++)
        {
            x.writeObject(hsl.get(i).name);
            System.out.println(hsl.get(i).name);
            x.writeObject(hsl.get(i).score);
            System.out.println(hsl.get(i).score);
            x.writeObject(gb);
        }
        x.closeWriterXML();
    }
    public void xmlLoad(String name)
    {

        XML_240 x = new XML_240();
        x.openReaderXML("gameBoard.xml");
        name = (String) x.ReadObject();
        score = (int) x.ReadObject();
        gameBoard = (String) x.ReadObject();
        x.closeReaderXML();
            }
            

}

