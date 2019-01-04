import java.util.Scanner;
import java.util.ArrayList;

/**
 * Write a description of class ScrambledGame here.
 * 
 * @A. DeLaCruz
 * @5/12/17
 */
public abstract class ScrambledGame
{
    public static Scanner scan = new Scanner(System.in);
    //allWords holds all of the level's words
    private String[] allWords;
    //unusedWords holds words that have not been guessed yet
    private ArrayList<String> unusedWords = new ArrayList<String>();
    private String guess;
    private int lives;
    private int score;
    private int r;
    private boolean isMatch;
    //wordSize is the length of the word                                          
    private int length;
    //original is the original word
    private String original;
    //scrambled is the shuffled word
    private String scrambled;
    //nextWord is the next word the user will guess
    private String nextWord;
   
    /**
     * Constructor for objects of class ScrambledGame
     **/
     
    public ScrambledGame(String[] theWords)
    {
        lives = 3;
        score = 0;
        allWords = new String[theWords.length];
        allWords = theWords;
        for (String str: allWords)
        {
            unusedWords.add(str);
        }
    }
    
    public int getLives()
    {
        return lives;
    }
    
    public void showLives()
    {
        System.out.println("\nLives left: " + lives);
    }

    public String getNextWord()
    {
        unusedWords.remove(original);
        
        if (unusedWords.size()==0)
        {
            return null;       
        }
        r = (int) (Math.random() * unusedWords.size());
        original = unusedWords.get(r);
        return original;
    }
    
    public void showBlanks()
    {
        for (int i = 0; i<original.length(); i++)
        {
            System.out.print("_ ");
        }
    }
    
    public abstract String scrambleWord(String aWord);
    
    public abstract void analyze();
    
    public abstract void setNextWord();
    
    public abstract String getTheWord();
    
    public void showLine()
    {
        System.out.println("=========================");
    }
    
    public void showScore()
    {
        System.out.println(" Score: " + score);
    }
    
    public int getScore()
    {
        return score;
    }
    
    public boolean checkGuess()
    {
        System.out.print("\nEnter your guess: ");
        guess = scan.next();

        if (guess.equals(original))
        {
            isMatch = true;
            score++;
            System.out.print("\nCorrect!");
            showScore();
        }
        else
        {
            isMatch = false;
            System.out.print("\nIncorrect.");
        }
        return isMatch;
    }
    
    public void updateLives()
    {
        if (isMatch == false)
        {
            lives--;
        }
    }
    
    public abstract void getScrambled();
   
    
    public int getLeft()
    {
       return unusedWords.size();
    }
    
     /**
     * @Return the length of the word
     */
    public int getLength()
    {
        return length;
    }
    
    /**
     * @Return the unmodified word
     */
    public String getOriginal()
    {
        return original;
    }
    
    /**
     * @Return a hint to make guessing the word easier
     */
    public String setHint()
    {
        return "hint";
    }
    
    public abstract int getAllWords();
    
}
    
    
