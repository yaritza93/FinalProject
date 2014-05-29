import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonControl implements ActionListener {
    public String message; 
    private Show show;
        public void actionPerformed( ActionEvent evt ) {
            JButton whichButton = (JButton)evt.getSource();  
            String cmd = evt.getActionCommand();  
            if (cmd.equals("Quit")) { 
                System.exit(0);
            }
            else {
                message = "The command is " + cmd;
            }
            show.repaint();  
        }
    }
