package A1;
/**
 * This class implements Player class.This is where all players position is updated, and checks if player is caught by snake or landed on ladder
 * @author Kevin Shibu Chacko
 * @author Andrew Harissi Dagher
 *
 */

public class Player extends LadderAndSnake {
	private int position_player;
	private int playerNum;
	public static Player[] pl;
	
	/**
	 * This is a default constructor
	 */
	public Player() {
		
	}
	
	/**
	 * This constructor takes in a player number to see which player it needs to update position.
	 * @param playerNum player number of player
	 */
	public Player(int playerNum) {
		this.playerNum = playerNum;
		
	}
	/**
	  * This method gets player position of a certain player
	  * @return player position of certain player
	  */
	public int getPosition_player() {
		return position_player;
	}

	/**
	 * This method sets player position after taking in player positions
	 * @param position_player position of player at that time
	 */
	public void setPosition_player(int position_player) {
		this.position_player = position_player;
	}

	
	/**
	 * This method check is player is at head of snake
	 * @param head position where the head of snake is located
	 * @return updated position if corresponds to snake, if not return -11
	 */
	private int tailSnake(int head) {
		switch(head) {
		case 16:
			return 6;
		case 48:
			return 30;
		case 64:
			return 60;
		case 79:
			return 19;
		case 93:
			return 68;
		case 95:
			return 24;
		case 97:
			return 76;
		case 98:
			return 78;
		default:
			return -11;
		}
	}
	/**
	 * This method check is player is at bottom ladder 
	 * @param bottom position where bottom of ladder is located
	 * @return updated position if corresponds to ladder, if not return -11
	 */
	 private int TopLadder(int bottom) {
		 switch(bottom) {
		 case 1:
			 return 38;
		 case 4:
			 return 14;
		 case 9:
			 return 31;
		 case 21:
			 return 42;
		 case 28:
			 return 84;
		 case 36:
			 return 44;
		 case 51:
			 return 67;
		 case 71:
			 return 91;
		 case 80:
			 return 100;
			 default:
				 return -11;
		 }
	 }
	 
    /**
     * This method updates position of player by taking in dice value that player rolled.if player reached 100 them program exits.
     * if player is over 100 them player is set back .Checks if player has hit snake, if not then updates position,then checks if player hits ladder, if not updates postion simply from dice roll
     * if player has indeed hit a snake, we then print statement saying that he was caught by snake,else it has was a ladder
     * @param diceNum dice value that player rolled
     */
	public void updatePos(int diceNum) {
		int storepos=0;
		boolean goBack=false;
		int positionGo;
		
		if(this.position_player+diceNum == 100) {
			System.out.println("Player "+this.playerNum+" has won!");
			System.exit(0);
		}
		
		if(this.position_player+diceNum>100) {
			positionGo = 100-((this.position_player+diceNum)-100);
			storepos=positionGo;
			System.out.println("Player "+this.playerNum+" fell back to "+ positionGo+".");
			goBack=true;
		}
		
		Player[] plys = pl;
		for (int i = 0 ; i<plys.length;i++) {
			plys[i].getPosition_player();
			if(plys[i].getPosition_player()== this.position_player+diceNum) {
				this.position_player+=diceNum;
				plys[i].setPosition_player(0);
				System.out.print("Player "+super.player[i]+" is set back to position 0. \n");
				return;
			}
		}
		
		positionGo = TopLadder(diceNum + this.position_player);
		
		
		if (positionGo == -11) {
			positionGo = tailSnake(diceNum + this.position_player);
		}
		
		//checks if hits a ladder, if not then update
		if (positionGo==-11) {
			if(goBack==true) {
				this.position_player=storepos;
				return;
			}
			this.position_player+=diceNum;
			return;
		}
		
		
		if (this.position_player > positionGo) {
			System.out.println("Player " + (this.playerNum) + " got caught by a snake. Go to "+positionGo+".");
			
			
		} else {
			System.out.println("Player " + (this.playerNum) + " climbs a ladder. Go to " +positionGo+".");
			if(positionGo == 100) {
				System.out.println("Player "+this.playerNum+" has won!");		
				System.exit(0);
			}

		}
		
		
		//update position
		this.position_player=positionGo;
		
	}
	

}

