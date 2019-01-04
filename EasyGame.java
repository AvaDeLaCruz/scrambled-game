//import java.util.Collections;


/**
 * Write a description of class EasyGame here.
 * 
 * @A. DeLaCruz
 * @5/12/17
 */
public class EasyGame extends ScrambledGame
{
    // eWords holds easy words for the user to guess (four to five letters long, with repeats)
    private static final String[] eWords = {"cell", "full", "wall", "puff", "moss",
                                            "small", "sheep", "bliss", "staff", "press",
                                            "class", "grill", "pizza", "gross", "floor"};
    private static String scrambled = "";
                                            
    private String theWord = "";
    //private String temp = "";

                                            

    /**
     * Constructor for objects of class EasyGame
     */
    public EasyGame()
    {
       super(eWords);
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
   
    //https://stackoverflow.com/questions/20011599/java-perfect-shuffle-using-arrays
    //perfect shuffle
    @Override
    public String scrambleWord(String aWord)
    {
        if (getLeft() > 0){
            String[] arr = new String[theWord.length()];
            String[] top = new String[arr.length/2];
            String[] bottom = new String[arr.length/2];
            scrambled = ""; //resets scrambled so permutations cant be counted
            //scrambled = temp;
            
            for (int i = 0; i < theWord.length(); i++)
            {
                String letter = aWord.substring(i,i+1);
                arr[i] = letter;
            }
            
            for (int i = 0; i < arr.length/2; i++)
            {
                top[i] = arr[i];
            }
            
            for (int i = 0; i < arr.length/2; i++)
            {
                bottom[i] = arr[i+(arr.length/2)];
            }
            
            for (int j = 0; j < top.length; j++)
            {
                arr[j*2] = top[j];
                arr[j*2+1] = bottom[j];
            }
            
            //for (String letter: arr)
            //{
             //  aWord+=letter;
            //}
            
            for (String letter: arr)
            {
                scrambled+=letter;
            }
            
            aWord = scrambled;
            
            //temp = scrambled;
           
            
            }
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
        return eWords.length;
    }
    
    @Override
    public String getTheWord()
    {
        return theWord;
    }
    
}

