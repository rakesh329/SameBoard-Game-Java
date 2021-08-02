## SimpleBoard-Game-Java

This program is to simulate a simple Board Game commonly played among children, where the players take turn to roll a dice, and move their game tokens on a physical board. The winner is the one who reaches a final position on the board first. The program will display a menu which allows the user of the program to select various options to simulate the various board game operations. As this is not a graphical program, will show the players' "positions" by simply displaying numbers on the screen (eg. "Player David is on position 25", etc). The dice rolls will also be simulated by the program, which will update each player's position accordingly. 


## Rules for the game

Key instruction for this program:
1. A Player is considered a winner if he reaches position 50 or more, and the other player has not reached 50.
2. Player reaches one of the special positions 11/22/33/44, he will be given a penalty, by having 5 subtracted from his current position.
3. Player reaches one of the special positions 5/15/25/35, he will be given a bonus, by having the computer roll the dice a second time for him, and his position movedonce more. The bonus move has the special condition that if his new position (after
the bonus dice roll) is on 11/22/33/44, no penalty is imposed. 
4. Menu must be displayed after each operation.

## Program Explaination

Complete projects is done in three different java files (Classes):
1. Dice.java
2. Game.java
3. Player.java

#### Class Diagram

![alt text](D:\Git\SimpleBoard-Game\Figure.JPG)

**1. Dice.java**

This program generates a random number between 1-6. This is used by the program to simulate a dice roll operation.

**2. Game.java**

In this program a Game object will be responsible for displaying the menus, accepting user responses, and performing the requested operations. It will make use of 2 Player objects and 1 Dice object.


**3. Player.java**

In this program a Player object will remember his own name, what board position he is currently on, and how many times he has received a penalty/bonus. 

