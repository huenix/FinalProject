import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;



public class xmlProcess
{
    listEntry[] hiScore = new listEntry[1];
    ArrayList<listEntry> hsl = new ArrayList<listEntry>();
    
    public xmlProcess()
    {
        File g = new File("gameBoard.xml");
        XML_240 x = new XML_240();
        if(g.exists()){    
            x.openReaderXML("gameBoard.xml");
            for(int i = 0; i < 10; i++){
            int s = (int) x.ReadObject();
            String gb = (String) x.ReadObject();
            hsl.add(new listEntry(s,gb));
        }
        Collections.sort(hsl, listEntry.scoreComp);
        } 
        else{
        x.openWriterXML("gameBoard.xml");
        for(int i = 0; i < 10; i++)
        {
        x.writeObject(0);
        x.writeObject("0000100200000020");
        hsl.add(new listEntry(0,"0000100200000020"));
        }
        x.closeWriterXML();
        }
        
    }
    public void xmlClose(int score, String gb)
    {
        hsl.add(new listEntry(score,gb));
        XML_240 x = new XML_240();
        Collections.sort(hsl, listEntry.scoreComp);
        x.openWriterXML("gameBoard.xml");
        for(int i = 0; i < 10; i++)
        {
            x.writeObject(hsl.get(i).score);
            System.out.println(hsl.get(i).score);
            x.writeObject(hsl.get(i).gameBoard);
        }
        x.closeWriterXML();
    }

}

