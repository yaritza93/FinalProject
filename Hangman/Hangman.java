import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.util.*;
import java.awt.Image;
/**
 * @author Yaritza Ascencio
 */
public class Hangman {
    Show show;
    JButton exit    = null;
    JButton newGame = null;    
    Panes pane;
    JLabel    wordArea    = null;
    JLabel    messageArea = null;
    java.util.List alphaButtonList = new ArrayList();
    //JButton[] alphaButtonList = new JButton[26];
    Iterator alphaIterator = null;
    static Hangman app = new Hangman();
    boolean reset        = true;
    boolean disable      = false;
    boolean donWrap      = false;
    boolean wrap         = true;
    boolean head    = false;
    boolean body    = false;
    boolean leftArm = false;
    boolean rightArm= false;
    boolean leftLeg = false;
    boolean rightLeg= false;

    String[] words = {
            "secret", "invented", "mouse", "clean", "summer",
            "fall", "great", "mother", "spaceship", "aliens",
            "crayons", "different", "computer"
        };
    String winnerMessage = "Congratulations!  You win!";
    String losingPrefix  = "Sorry the anwswer was: ";
    String currentGuess;
    String word;

    int numberWrong       = 0;
    int numberOfBodyParts = 6;
    int next              = 0;
   
    public  void setUpNewGame() {
        numberWrong = 0;
        messageArea.setText("May the Odds be ever in your favor");

        Iterator alphaIterator = alphaButtonList.iterator();
        while( alphaIterator.hasNext() ) {
            ( (JButton)alphaIterator.next() ).setEnabled( reset );
        }

        newGame.setEnabled( disable );

        wordArea.setBackground(Color.BLUE);

        double numb = Math.random();
        next = (int)( numb * words.length );
        word  = words[next];

        currentGuess = "-";
        for( int i=0; i<word.length()-1; i++) {
            currentGuess = currentGuess.concat("-");
        }
        wordArea.setText( currentGuess );

        head    = false;
        body    = false;
        leftArm = false;
        rightArm= false;
        leftLeg = false;
        rightLeg= false;
        show.repaint();

    }

    public void processAnswer(String answer) {      
        char newCharacter = answer.charAt(0);
        String nextGuess    = "";
        boolean foundAMatch = false;
        for( int i=0; i<word.length(); i++ ) {
            char characterToMatch = word.charAt(i);
            if( characterToMatch == newCharacter ) {
                nextGuess = nextGuess.concat( String.valueOf(newCharacter) );
                foundAMatch = true;
            }
            else {
                nextGuess = nextGuess.concat(String.valueOf
                    ( currentGuess.charAt(i) ));
            }
        }
        currentGuess = nextGuess;
        wordArea.setText( currentGuess );

        if( currentGuess.equals( word ) ) {

            Iterator alphaIterator = alphaButtonList.iterator();
            while( alphaIterator.hasNext() ) {
                ( (JButton)alphaIterator.next() ).setEnabled( disable );
            }
            messageArea.setText( winnerMessage );
            newGame.setEnabled( reset );
            exit.setEnabled( reset );
        }

        else {
            if( !foundAMatch ) {
                numberWrong++;
                switch (numberWrong){
                    case 1: { head     = true; break; }
                    case 2: { body     = true; break; }
                    case 3: { leftArm  = true; break; }
                    case 4: { rightArm = true; break; }
                    case 5: { leftLeg  = true; break; }
                    case 6: { rightLeg = true; break; }
                    default: System.out.println("You are dead!");
                }
                show.repaint();
            }

            if( numberWrong >= numberOfBodyParts ) {

                Iterator alphaIterator = alphaButtonList.iterator();
                while( alphaIterator.hasNext() ) {
                    ( (JButton)alphaIterator.next() ).setEnabled( disable );
                }
                messageArea.setText( losingPrefix + word );
                newGame.setEnabled( reset );
                exit.setEnabled( reset );
            }
        }
    }


    public static void main(String[] args) {
        app.setUpNewGame();
        
        JFrame frame = new JFrame("Hangman");
        frame.setSize( new Dimension(640,480) );
        
        frame.setVisible(true);
    }
}
