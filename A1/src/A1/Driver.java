package A1;
import java.util.Scanner;
/*Assignment 1
 *  Written by: Kevin Shibu Chacko 40241154
 *  Andrew Harissi Dagher  40247726
 *  Program Description: The program is a snake and ladder game, where the program asks user how many players want to play.
 *  Since this is beta version of the game, it can only play 2 playersThe program, will then make the two players roll a dice to see who starts the game.
 *  After deciding the order, The first player will roll to move forward and then it'll be other players turnAlong the way, there can be ladders that can help players move up the board 
 *  also there will be snake, who will make players fall of to a smaller position.The point of the game is to reach 100exacty.If a player exceed 100, 
 *  it is then set back to the position that exceeded subtracted by 100.Also, if a player lands another players position, the other is knocked back to case 0.
 *  The simulation will output each players dice roll, its current position as well as display where on the board,it is located.
 * 
 */

/**
 * This is the driver class where the actual program is run
 * @author Kevin Shibu Chacko
 * @author Andrew Harissi Dagher
 *
 */
public class Driver {
	

	public static void main(String[] args) {
		int numOfPlayers;
		Scanner input = new Scanner(System.in);
		System.out.println("How many players would like to play?");
		if(input.hasNextInt()) {
			numOfPlayers = input.nextInt();
			}else {
				System.out.println("not an integer, number of players set to 2.");
				numOfPlayers = 2;
			}		
		LadderAndSnake ls1=new LadderAndSnake(numOfPlayers);
		ls1.play();
		
	
		
	}   

}



