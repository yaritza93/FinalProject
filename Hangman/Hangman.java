
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Hangman extends JPanel {

    private Show show; 

    private ArrayList<JButton> alphabetButtons = new ArrayList<JButton>(); 
    private JButton nextButton;    
    private JButton giveUpButton;  

    public String message;     
    private String[] wordlist;  
    private String word;        
    private String guesses;     
    private boolean gameOver;   
    private int badGuesses;    

    public Hangman() {

        ButtonControl buttonControl = new ButtonControl(); 

        show = new Show();  
        JPanel bottom = new JPanel();  
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new GridLayout(1,6));
        setLayout(new BorderLayout(3,3));  
        add(show, BorderLayout.CENTER); 
        add(bottom, BorderLayout.SOUTH);
        add(subPanel, BorderLayout.NORTH);

        for (char alphabet = 'A'; alphabet <='Z'; alphabet++){
            String buttonText = String.valueOf(alphabet);
            JButton letterButton = new JButton(buttonText);
            alphabetButtons.add(letterButton);
            letterButton.addActionListener(buttonControl);
            subPanel.add(letterButton, BorderLayout.CENTER);
        }

        nextButton = new JButton("Next word");
        nextButton.addActionListener(buttonControl);
        bottom.add(nextButton);

        giveUpButton = new JButton("Give up");
        giveUpButton.addActionListener(buttonControl);
        bottom.add(giveUpButton);

        JButton quit = new JButton("Quit");
        quit.addActionListener(buttonControl);
        bottom.add(quit);

        setBackground( new Color(204,255,229) );
        setBorder(BorderFactory.createLineBorder(new Color(100,0,0), 3));

        wordlist = new String[15];
        wordlist[0] = "taco";
        wordlist[1] = "secrets";
        wordlist[2] = "chest";
        wordlist[3] = "invented";
        wordlist[4] = "mouse";
        wordlist[5] = "four";
        wordlist[6] = "wednesdays";
        wordlist[7] = "three";
        wordlist[8] = "rainbows";
        wordlist[9] = "hawaii";
        wordlist[10] = "hot dog";
        wordlist[11] = "butter";
        wordlist[12] = "october";
        wordlist[13] = "haters";
        wordlist[14] = "africa";

        startGame();
    } 
    private void startGame() {
        gameOver = false;
        guesses = "";
        badGuesses = 0;
        nextButton.setEnabled(false);
        for (int i = 0; i < alphabetButtons.size(); i++) {
            alphabetButtons.get(i).setEnabled(true);
        }
        giveUpButton.setEnabled(true);
        int index = (int)(Math.random()*wordlist.length);
        word = wordlist[index-1] ;
        word = word.toUpperCase();
        message = "The word has " + word.length() + " letters.  Let's play Hangman!";
    }

    private boolean wordIsComplete() {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if ( guesses.indexOf(ch) == -1 ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Hangman"); 
        Hangman panel = new Hangman();  
        window.setContentPane(panel);   
        window.pack();  
        window.setResizable(false); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); 
        window.setLocation( (screen.width - window.getWidth())/2, 
            (screen.height - window.getHeight())/2 );
        window.setVisible(true);  
    }
} 