package A1;
import java.util.Random;
import java.util.Scanner;
/**
 * This class implements a ladder and snake game allowing to play the game.
 * @author Kevin Shibu Chacko
 * @author Andrew Harissi Dagher
 *
 */
public class LadderAndSnake {
 
	private int numOfPlayers;
	
	protected static int[] player = new int[2];
	public Player[] players;
	private Random dice = new Random();
	
	/**
	 * this constructor is a default constructor
	 */
	public LadderAndSnake() {
		
	}
	/**
	 * This constructs a LadderAndSnake with a specified number of players
	 * @param numOfPlayers the number of players in the game
	 */
	public LadderAndSnake(int numOfPlayers) {
		
		if(numOfPlayers<2) {
			System.out.println("Error: Cannot create game with less than 2 player. Exiting Game!");
			System.exit(0);
		}
		else if(numOfPlayers>2) {
			System.out.println("You have chosen "+numOfPlayers+" numbers of players. Unfortunetely, this program can only have 2 players. Value will be set to 2.");
			this.numOfPlayers = 2;
		}
		else this.numOfPlayers=2;
		
		}
	/**
	 * This method is a getter that returns the player objects.
	 * @return player objects
	 */
	public Player[] getPlayers() {
		return players;
	}


	
	/**
	 * This method rolls the dice for the game	
	 * @return a random integer from 1 to 6.
	 */
	public int flipDice() {
			return dice.nextInt(6)+1;		
	}
	
	
	
	
	/**
	 * This method determines which players starts game first, by using flipdice method,and storing it into a player array,if both player roll same dice number then, thhye have to roll again, until one of them has rolled higher
	 */
	public void Order(){
		int attempts=1;
		int player1=flipDice();
		int player2=flipDice();
		System.out.println("- Now deciding which player will start playing:");
		System.out.println("- Player 1 got a dice value of "+player1+".");
		System.out.println("- Player 2 got a dice value of "+player2+".");
			
		while(player1==player2) {
			System.out.println("- A tie was acheived between Player 1 and Player 2. Attempting to break the tie.");
			attempts++;
			player1=flipDice();
			player2=flipDice();
			System.out.println("- Player 1 got a dice value of "+player1+".");
			System.out.println("- Player 2 got a dice value of "+player2+".");
		}
		if(player1>player2) {
			player[0]=1;
			player[1]=2;
		}
		else {
			player[0]=2;
			player[1]=1;
			}
			System.out.println("Reached final decision on order of playing: Player " + player[0] + " then Player " + player[1] + ". It took "+attempts+" attempts before a decision could be made.");	
		}
	
	/**
	 * This method allows for simulation of game,where it takes order method. Creating two player objects and stores them in player array from player class.It takes in all position updates from player class as well as board modification from board class and displays it to user.
	 */
	public void play() {
		Order();
		players = new Player[2];
		for (int i = 0; i < numOfPlayers; i++) {
			Player ply = new Player(player[i]);
			players[i] = ply;
			}
     	Player.pl=players;
		Board b1=new Board();
		while (true) {
			for(int i = 0; i<numOfPlayers;i++) {
				int diceValue = flipDice();
				System.out.println();
				System.out.println("Player "+player[i]+" rolled "+diceValue+".");
				players[i].updatePos(diceValue);
				System.out.println("Player "+ player[i]+" is now at position "+players[i].getPosition_player()+".");
				b1.printBoard();
			}
				
			    	
			    }
			}
			
		}
	


			
					
				
				
				
				
			
		



	
    
