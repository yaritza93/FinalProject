import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.util.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
class Show extends JPanel {
    Hangman controller;

    public Show(Hangman controller) {
        this.controller = controller;
        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border loweredBevel = BorderFactory.createLoweredBevelBorder();
        Border compound = BorderFactory.createCompoundBorder
            ( raisedBevel, loweredBevel );
        setBorder( compound );
    }

    public void paintComponent()throws IOException {

        JFrame f = new JFrame();
        String path = "hang1.gif";
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        JLabel label = new JLabel(new ImageIcon(image));
        f.getContentPane().add(label);
        f.setLocation(20,20);
        f.setVisible(true);
        if( controller.head ){
            String path1 = "hang2.gif";
            File file1 = new File(path1);
            BufferedImage image1 = ImageIO.read(file1);
            JLabel label1 = new JLabel(new ImageIcon(image1));
            f.getContentPane().add(label1);
            f.setLocation(20,20);
            f.setVisible(true);
        }

        if( controller.body ){
            String path2 = "hang3.gif";
            File file2= new File(path2);
            BufferedImage image2 = ImageIO.read(file2);
            JLabel label2 = new JLabel(new ImageIcon(image2));
            f.getContentPane().add(label2);
            f.setLocation(20,20);
            f.setVisible(true);

        }

        if( controller.leftArm ){
            String path3 = "hang4.gif";
            File file3= new File(path3);
            BufferedImage image3 = ImageIO.read(file3);
            JLabel label3 = new JLabel(new ImageIcon(image3));
            f.getContentPane().add(label3);
            f.setLocation(20,20);
            f.setVisible(true);
        }

        if( controller.rightArm ){
            String path4 = "hang5.gif";
            File file4 = new File(path4);
            BufferedImage image4 = ImageIO.read(file4);
            JLabel label4 = new JLabel(new ImageIcon(image4));
            f.getContentPane().add(label4);
            f.setLocation(20,20);
            f.setVisible(true);
        }

        if( controller.leftLeg ){
            String path5 = "hang6.gif";
            File file5= new File(path5);
            BufferedImage image5 = ImageIO.read(file5);
            JLabel label5 = new JLabel(new ImageIcon(image5));
            f.getContentPane().add(label5);
            f.setLocation(20,20);
            f.setVisible(true);

        }

        if( controller.rightLeg ){
            String path6 = "hang7.gif";
            File file6 = new File(path6);
            BufferedImage image6 = ImageIO.read(file6);
            JLabel label6 = new JLabel(new ImageIcon(image6));
            f.getContentPane().add(label6);
            f.setLocation(20,20);
            f.setVisible(true);

        }

    }
}