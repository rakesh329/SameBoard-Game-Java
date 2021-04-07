import java.util.Scanner;
/**
 * class Game the comple information about the game exist.
 *
 * @author (Namballa Rakesh)
 * @version (v3,18/09/2020)
 */
public class Game
{
    
    private Player player1;
    private Player player2;
    private Dice dice;
    private boolean result;

    /**
     * Default constructor for objects of class Game
     * initialising  variables player1,player2,dice
     */
    public void Game()
    {
        player1 = new Player(readPlayerName("one"));
        player2 = new Player(readPlayerName("two"));
        dice = new Dice();
        result = false;
    }
    
    /**
     * A choice method - To use the case depending on the selected option
     * @param  option   parameter for a choosing the required case
     */
    public  void choice(String option)
    {
        switch (option)
        {
            case "1" : 
                this.Game();break;
            case "2" :
                if (player1 != null && !result) 
                {
                    this.playOneRound(player1);
                    this.playOneRound(player2);
                    gameResult();
                }
                else if (result)
                {
                    System.out.println("Game over! Start a New Game");
                }
                else 
                {
                    System.out.println("Error! Enter player names");
                }
                break;
            case "3" :
                if (player1 != null)
                {
                    this.playerStats(player1);
                    this.playerStats(player2);
                }
                else
                    System.out.println("Play the game to Display ");
                break;
            case "4" : 
                displayGameInstruction();break;
            case "5" : 
                System.out.println("Exit");break;
            default:
                System.out.println("Enter between 1-5");
                break;
        }
    }
    
    /**
     * A display method - To display the user all the options about the game
     * @return    the users selected option
     */
    public String display()
    {
        String option;
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the Simple Board Game");
        System.out.println("=================================");
        System.out.println("(1) Start/Restart a Game");
        System.out.println("(2) Play One Round");
        System.out.println("(3) Display Players' Position");
        System.out.println("(4) Display Game Help");
        System.out.println("(5) Exit Game");
        System.out.println("Choose an option: ");
        option = console.nextLine();
        return option;

    }
    
    /**
     * A displayGameInstruction method - To provide instructions of the game
     */
    void displayGameInstruction() 
    {
        System.out.println();
        System.out.println("Two players roll a dice once per turn.");
        System.out.println("For each player, depending on the rolled value moves their position");
        System.out.println("If the player position lands on [5,15,25,35]" +
            "they receive bonus and roll the dice again");
        System.out.println("If the player position lands on [11,22,33,44]" +
            "they receive penalty and fall back to five positions behind");
        System.out.println("First player to reach 50 or more wins the game");
        System.out.println("If both the player reach 50 or above at the same time its a DRAW!");

    }
    
    /**
     * A gameResult method - To check the result of the game
     */
    void gameResult()
    {
        if (player1.getPosition() >= 50 && 
            player2.getPosition()>= 50)
        {
            System.out.println("***** Congrats the Game is DRAW *****");
            result = true;
        }
        else if(player1.getPosition() >= 50)
        {
            System.out.println("***** Congrats  " + player1.getName() + " WON! *****");
            result = true;
        }
        else if(player2.getPosition() >= 50)
        {
            System.out.println("***** Congrats  " + player2.getName() + " WON! *****");
            result = true;
        }
    }
    
    /**
     * A isAlpha method check the each character of the string, weather it is an alphabet or not 
     * @param name takes the player name string
     * @return false or true depending on the condition
     */
    public boolean isAlphabet(String name)
    {
        char[] chars = name.toCharArray();
        for (char c : chars)
        {
            if (!Character.isLetter(c) && !Character.isWhitespace(c))
            {
                return false;
            }
        }
        return true;
    }
        
    /**
     * A playerStats method - To keep the players stats with their position,bonous, penalty in the game
     */
    void playerStats(Player player)
    {
        System.out.println(player.getName()+ " is on position " + player.getPosition() +"[Bonous "+player.getBonous()+
                ", Penalty " + player.getPenalty()+"]");

    }
    
    /**
     * A playOneRound method - To keep the track of the players positions depending on the bonous and penalty
     * @param  player   parameter for different players
     */
    public void playOneRound(Player player)
    {
        int position = player.getPosition();
        int dropPosition ;
        int rollDice = dice.random();
        player.setPosition(rollDice);

        System.out.println(player.getName() + " rolled " + rollDice + " moves from position " + position + " to " + player.getPosition());

        if (player.getPosition() == 5 ||
            player.getPosition() == 15 ||  
            player.getPosition() == 25 ||  
            player.getPosition() == 35 )
        {

            int rollDice2 = dice.random();
            player.setPosition(rollDice2);
            System.out.println( player.getName() + " rolled " + rollDice2 +" moves to " + player.getPosition() + " [Bonus applied]");
            player.setBonous();


        }

        
        if (player.getPosition() == 11 ||
            player.getPosition() == 22 ||
            player.getPosition() == 33 ||
            player.getPosition() == 44 ) 
        {
            
            dropPosition = player.getPosition() - 5;
            System.out.println( player.getName() + " drops to " + dropPosition  +" [Penalty applied]");
            player.setPenalty();
            player.setNewPosition(dropPosition);

        }
    }
    
    /**
     * A readPlayerName method - To take the player name and evaluate
     * @param  playerNumber   parameter for different players
     * @return    readPlayerName
     */
    public String readPlayerName(String playerNumber)
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter player " + playerNumber + " name:");
        String readPlayerName = console.nextLine().trim();

        if (readPlayerName.isEmpty())
        {
            System.out.println("Blank! Please enter name");
            readPlayerName = readPlayerName(playerNumber);
        }
                        
        if (!isAlphabet(readPlayerName))
        {
            System.out.println("Alphabet only no Alphanumeric!");
            readPlayerName = readPlayerName(playerNumber);
        }
        return readPlayerName;
    }
    
    
    /**
     * A startGame method - To start the "Simple Board Game"
     * Depending on the player options it executes various cases
     */
    public void startGame()
    {
        String option = "0";
        while (!option.equals("5"))
        {
            option = display();
            choice(option);

        }
    }
}
    
    
    
    
    
    
    
    