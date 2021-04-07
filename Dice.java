
/**
 * class Dice used to generate a random value.
 * @author (Namballa Rakesh)
 * @version (v2,13/09/2020)
 */
public class Dice
{
    
    private int diceValue;

    /**
     * Constructor for objects of class Dice
     * initialising instance variables diceValue
     */
    public Dice()
    {
        // initialise instance variables
        diceValue = 0;
    }
    

    /**
     * A random() method - To generate a random value in the range of 1 to 6
     * @return    the randomly generated diceValue
     */
    public  int random()
    {
        
        diceValue = (int)(Math.random()*6+1);
        return diceValue;


    }
}
