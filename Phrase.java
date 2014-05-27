package ABCButton;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Yariza on 5/26/2014.
 */
public class Phrase {
    private int randomX;
    private String[] phrases = new String[14];
    private Random random;
    private Phrase phrase;
    private String[] words = new String[14];



    // "secrets", "chest hair", "invented", "", , ,
    //       "three", "rainbows", "espn", "hot dog","butter","october", "haters", "africa"}

    public Phrase() {
        random = new Random();
        this.randomX = -1;
        phrases[0] = "I can't go to ---- ----. I'm on an all-carb diet. God, Karen, you are so stupid";
        phrases[1] = "That's why her hair is so big. It's full of -------";
        phrases[2] = "Nice wig, Janice. What's it made of? Janice: 'your mom's ----- ----";
        phrases[3] = "I like -------- her, you know what i mean";
        phrases[4] = "I'm a -----, duh!";
        phrases[5] = "---- for you, Glen Coco! You gom Glen Coco!";
        phrases[6] = "On ----------, we wear pink.";
        phrases[7] = "I really wanna lose ----- pounds";
        phrases[8] = "I wish I could bake a cake filled with -------- and smiles and eveyone would eat and be happy";
        phrases[9] = "It's like I have ---- or something.";
        phrases[10] = "Made out with a --- ---? Oh my god, that was one time!";
        phrases[11] = "Is ------ a carb?";
        phrases[12] = "On ------- 3rd he asked me what day it was.";
        phrases[13] = "Don't let the ------ stop you from doing yo thang'.";
        phrases[14] = "If you're from ------, why are you white";

        words[0] = "taco bell";
        words[1] =  "secrets";
        words[2] = "chest hair";
        words[3] = "invented";
        words[4] = "mouse";
        words[5] = "four";
        words[6] = "wednesdays";
        words[7] = "three";
        words[8] = "rainbows";
        words[9] = "espn";
        words[10] = "hot dog";
        words[11] = "butter";
        words[12] = "october";
        words[13] = "haters";
        words[14] = "africa";

    }


    public String getPhrase() {
        int nextInt = randomX;
        while (nextInt == randomX) {
            nextInt = random.nextInt(phrases.length);
        }
        this.randomX = nextInt;
        return phrase[randomX];
    }

}