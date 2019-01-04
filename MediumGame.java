
/**
 * Write a description of class MediumGame here.
 * 
* @A. DeLaCruz
 * @5/12/17
 */
public class MediumGame extends ScrambledGame
{
    // mWords holds medium words for the user to guess (five to six letters long, some repeats)
    private static final String[] mWords = {"bliss", "agree",  "giant", "horse", "child",
                                            "lust",  "taboo", "left", "rose", "edit",
                                            "thrill", "uphill", "refill", "unwell", "bypass"};
                                            
    private static String scrambled = "";
    private String theWord = "";
    
    /**
     * Constructor for objects of class MediumGame
     */
    public MediumGame()
    {
        super(mWords);
    }
   
    
    @Override
    public void analyze()
    {   int count = 0;
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
    
    //http://www.programcreek.com/java-api-examples/index.php?source_dir=SFHSAPCompSci2015-master/src/main/java/com/justinwflory/assignments/spring/elevens-lab/Shuffler.java
    //selection shuffle
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
        
        for (int i = 0; i < arr.length; i++)
        {
            int r = (int) (Math.random()*arr.length);
            String temp = arr[i];
            arr[i] = arr[r];
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
        return mWords.length;
    }
    
    @Override
    public String getTheWord()
    {
        return "";
    }
}
