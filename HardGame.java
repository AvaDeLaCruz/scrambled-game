import java.util.Random;
/**
 * Write a description of class HardGame here.
 * 
 * @A. DeLaCruz
 * @5/12/17
 */
public class HardGame extends ScrambledGame
{
    //hWords holds hard words for the user to guess (six or more letters long, none repeat)
    private static final String[] hWords = {"headstrong", "insurance", "slogan",
                                            "clipboard", "microwave", "whistle", 
                                            "mockery", "demographic", "thunder",
                                            "obscenity", "handsome", "angel",
                                            "boundary", "phobia", "expand"};
                                            
    private static String scrambled = "";
        private String theWord = "";
    private static final Random gen = new Random();
                                            

    /**
     * Constructor for objects of class HardGame
     */
    public HardGame()
    {
        super(hWords);
    }

    
    @Override
    public void analyze()
    {
        int count = 0;
        String temp = scrambleWord(theWord);
        while ( temp.equals(theWord) == false )
        {
            count++;
            temp = scrambleWord(temp);
        } 

        System.out.println("Permutations to return to original word: " + count);
    }
    
      
    @Override
    public void setNextWord()
    {
       theWord = getNextWord();
    }
    
    //https://www.rosettacode.org/wiki/Knuth_shuffle
    //Fisher-Yates shuffle
    @Override
    public String scrambleWord(String aWord)
    {
        String[] arr = new String[theWord.length()];
        scrambled = "";
        
        for (int i = 0; i < theWord.length(); i++)
        {
            String letter = theWord.substring(i,i+1);
            arr[i] = letter;
        }
     
        for (int n = arr.length-1; n > 1; n--)
        {
            int r = gen.nextInt(n+1);
            String temp = arr[n];
            arr[n] = arr[r];
            arr[r] = temp;
        }
        
        for (String letter: arr)
        {
            scrambled+=letter;
        }
        
        aWord = scrambled;
        return aWord;
    }
    
    @Override
    public void getScrambled()
    {
        System.out.println("\n" + scrambled);
    }
    
    @Override
    public int getAllWords()
    {
        return hWords.length;
    }
    
    
    @Override
    public String getTheWord()
    {
        return "";
    }
}
