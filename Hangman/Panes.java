import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.util.*;
import java.awt.Image;
/**
 * Write a description of class Panes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Panes extends JPanel
{
    Hangman hangman;
    Show show = null;
    JButton newGame = null;
    JButton exit    = null;
    JLabel wordArea = null;
    JLabel    messageArea = null;
    java.util.List alphaButtonList = new ArrayList();
    Iterator alphaIterator = null;
    private JButton[] alphabetButtons = new JButton[26];

    boolean reset        = true;
    boolean disable      = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hangman");
        frame.setSize( new Dimension(640,480) );
        Hangman app = new Hangman();
        Component contents = app.pane.createComponents();

        frame.getContentPane().add(contents);
        frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
    }

    public Component createEastPane() {

        ActionListener controlButtonListener = new ActionListener() {
                public void actionPerformed( ActionEvent e ) {
                    JButton buttonPushed = (JButton)e.getSource();
                    if( buttonPushed.getText().equals("New Game") ) {
                        hangman.setUpNewGame();
                    }
                    else {
                        System.exit(0);
                    }
                }
            };

        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createLoweredBevelBorder());
        pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );

        newGame = new JButton( "New Game" );
        newGame.setFont( new Font("Sansserif", Font.PLAIN, 18) );
        newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        newGame.addActionListener( controlButtonListener );
        pane.add( newGame );

        pane.add( Box.createVerticalGlue() );

        exit = new JButton( "Exit" );
        exit.setFont( new Font("Sansserif", Font.PLAIN, 18) );
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.addActionListener( controlButtonListener );
        pane.add( exit );

        return pane;
    }

    public Component createComponents() {
        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createLoweredBevelBorder());
        pane.setLayout(new BorderLayout() );
        pane.add( createNorthPane(),  BorderLayout.NORTH );
        pane.add( createWestPane(),   BorderLayout.WEST );
        pane.add( createSouthPane(),  BorderLayout.SOUTH );
        pane.add( createCenterPane(), BorderLayout.CENTER );
        pane.add( createEastPane(),   BorderLayout.EAST );

        return pane;
    }

    public Component createNorthPane() {
        JPanel pane = new JPanel();
        pane.setLayout( new BoxLayout( pane, BoxLayout.X_AXIS ) );
        pane.setBorder( BorderFactory.createEmptyBorder(0, 10, 10, 10) );
        pane.add(Box.createHorizontalGlue() );
        wordArea = new JLabel("Press New Game");
        wordArea.setFont( new Font("Helvetica", Font.PLAIN, 24) );
        wordArea.setBackground(Color.lightGray);
        wordArea.setForeground(Color.black);
        pane.add(wordArea);
        pane.add(Box.createHorizontalGlue() );
        return pane;
    }

    public Component createSouthPane() {
        JPanel pane = new JPanel();
        pane.setLayout( new BoxLayout( pane, BoxLayout.X_AXIS ) );
        pane.setBorder( BorderFactory.createEmptyBorder(10, 10, 10, 10) );
        pane.add(Box.createHorizontalGlue() );

        messageArea = new JLabel("HANGMAN by Yaritza :)");
        messageArea.setFont( new Font("Sansserif", Font.PLAIN, 28) );
        messageArea.setBackground( Color.GREEN );
        messageArea.setForeground( Color.blue );
        pane.add(messageArea);
        pane.add(Box.createHorizontalGlue() );
        return pane;
    }

    public Component createCenterPane() {
        show = new Show(hangman);
        return show;
    }

    public Component createWestPane() {
        ActionListener alphabetButtons = new ActionListener() {
                public void actionPerformed( ActionEvent e ) {
                    JButton buttonPushed = (JButton)e.getSource();
                    buttonPushed.setEnabled(disable);
                    hangman.processAnswer(buttonPushed.getText());
                }
            };
        JPanel pane = new JPanel();
        this.add(pane);
        pane.setBorder(BorderFactory.createLoweredBevelBorder());
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c  = new GridBagConstraints();
        pane.setLayout( gridbag );
        c.fill = GridBagConstraints.BOTH;
        for (char alphabet = 'A'; alphabet <='Z'; alphabet++){
            String buttonText = String.valueOf(alphabet);
            JButton alphabetButton = new JButton(buttonText);
            pane.add(alphabetButton, BorderLayout.CENTER);
        }

        return pane;
    }
}
