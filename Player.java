
/**
 * class Player stors the players position, bonous, penalty.
 * @author (Namballa Rakesh)
 * @version (v3,13/09/2020)
 */
public class Player
{
    
    private String name;
    private int  position;
    private int  penalty;
    private int bonous;

    /**
     * Default constructor for objects of class Player
     * initialising instance variables position,bonous,penalty
     */
    public Player()
    {
        position = 0;
        bonous = 0;
        penalty = 0;
        name = "";
    }
    
    /**
     * Non-default constructor for objects of class Dice
     * @param  name a sample parameter to take the name of the players
     */
    public Player(String name)
    {
        this.name = name;
        position = 0;
        bonous = 0;
        penalty = 0;
    }

    /**
     * An Accessor getBonous - To know the no:of times the player got the bonous
     * @return    bonous
     */
    public int getBonous()
    {
        return bonous;
    }

    /**
     * An Accessor getName - To know the name of the player
     * @return    name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * An Accessor getPenalty - To know the no:of times the player got the penalty
     * @return    penalty
     */
    public int getPenalty()
    {
        return penalty;
    }
    
    /**
     * An Accessor getPosition - To know the position of the player on the board
     * @return    position
     */
    public int getPosition()
    {
        return position;
    }

    /**
     * A Mutator setBonous - To set the no:of times the player got the bonous
     */
    public void setBonous()
    {
        bonous = bonous + 1;
    }

    /**
     * A Mutator setPenalty - To set the no:of times the player got the penalty
     */
    public void setPenalty()
    {
        penalty = penalty + 1;
    }
    
    /**
     * A Mutator setPosition - To calculate the players position and set it
     * @param  diceValue is used to calculate the position
     */
    public void setPosition(int diceValue)
    {

        position += diceValue;

    }

    public void setNewPosition(int newPosition)
    {
        position = newPosition;
    }

}
