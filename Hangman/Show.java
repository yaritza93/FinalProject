import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Show extends JPanel {
    public String message;
    Show() {
        setPreferredSize(new Dimension(620,420));
        setBackground( new Color(229, 204, 255) );
        setFont( new Font("Sansserif", Font.BOLD, 20) );
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D)g).setStroke(new BasicStroke(3));
        if (message != null) {
            g.setColor(Color.RED);
            g.drawString(message, 30, 40);
        }
    }
}