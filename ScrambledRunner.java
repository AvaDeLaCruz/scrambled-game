
/**
 * 
 @A.DeLaCruz
 @5/12/17
 *
 **/

import java.util.Scanner;

public class ScrambledRunner
{
    public static Scanner scan = new Scanner(System.in);
    private static ScrambledGame game;
    private static int max;
    private static boolean eWon;
    private static boolean mWon;
    private static boolean hWon;
        
    public static void main (String[] args)
    {
        max = 0;
        eWon = false;
        mWon = false;
        hWon = false;
        reset();
    }
    
    public static void reset ()
    {
        showMenu();
        int choice = scan.nextInt();
        while (choice != 0)
        {
            doChoice(choice);
            choice = scan.nextInt();
        }
    }
   
    public static void showMenu()
    {
        System.out.println("\nScrambled Word Game Menu   ");
        System.out.println("   ====");
        System.out.println("High Score: " + max);
        System.out.println("   ====");
        System.out.println("0: Quit");
        System.out.println("1: Play an Easy Game");
        System.out.println("2: Play a Medium Game");
        System.out.println("3: Play a Hard Game");
        System.out.print("\nEnter your choice: ");
    }
    
    public static void doChoice (int choice)
    {
        if (choice == 0)
        {
            System.out.println("Bye!");
        }
        else if (choice == 1)
        {   
            game = new EasyGame();
            playGame(game);
        }
        else if (choice == 2)
        {
            game = new MediumGame();
            playGame(game);
        }
        else if (choice == 3)
        {
            game = new HardGame();
            playGame(game);
        }
        else
        {
            System.out.print("Please enter an option from the menu: ");
        }
    }
    
    public static void playGame(ScrambledGame aGame)
    {
        aGame.setNextWord();
        aGame.analyze();
        while (aGame.getLives() > 0 && aGame.getLeft() > 1)
        {
            aGame.showLine();
            aGame.setNextWord();
            String theWord = aGame.getTheWord();
            aGame.scrambleWord(theWord);
            if (aGame.getLeft() > 0)
            {
                aGame.getScrambled();
                aGame.showBlanks();
                while (aGame.getLives() > 0 && aGame.checkGuess() == false)
                {
                    aGame.updateLives();
                    aGame.showLives();
                }
            }
        }
        if (aGame.getScore() > max)
        {
            max = aGame.getScore();
        }
        System.out.println();
        aGame.showLine();
        System.out.print("Game Over! Final");
        aGame.showScore();
        if (aGame.getAllWords()==aGame.getScore())
        {
            System.out.println("Level Completed!");
        }
        else
        {
            System.out.println("Level Incomplete.");
        }
        aGame.showLine();
        reset();
    }
}
