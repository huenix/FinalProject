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
        name = n;
        score = s;
        gameBoard = gb;
    }
        public static Comparator<listEntry> scoreComp = new Comparator<listEntry>()
    {
        public int compare(listEntry e1, listEntry e2)
        {
            return e2.score-e1.score;
        }
    };
    
}
