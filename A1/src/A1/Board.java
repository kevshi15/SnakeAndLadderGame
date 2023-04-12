package A1;
/**
 * This class implements Board class .This is where we print board, and update it with each player's postion.
 * @author Kevin Shibu Chacko
 * @author Andrew Harissi Dagher
 *
 */

public class Board {
	static int[][] board = new int[10][10];
	
/**
 * This method will return exact index of player, as it takes into account the position of the player
 * @param position takes position of specific player
 * @return return array of giving us specific row and column of player
 */
	public int[] getIndexFromPosition(int position) {
		int row = (position - 1)/10;
		int column =(position-1)%10;
		row = 9-row;
		
		if(position > 10) {
			int[] a = {row,column};
			if (row%2 !=0)return a;
			column = 9-column;
		}
		int[] a = {row,column};
		return a;
		
		
	}
	/**
	 * method that print the actual board with player positions.for board printing,if row is odd,then numbers will be printed left to right,
	 *  if row is pair,then row will printed from right to left.postion variable will continously increment as the we switch from odd and pair rows.
	 */
	public void printBoard() {
	    int location[][]=new int[Player.pl.length][2];
	    for(int i=0;i<Player.pl.length;i++) {
	    	location[i]=getIndexFromPosition(Player.pl[i].getPosition_player());
	    }
	    
	    int position = 1;
	    boolean odd = true;
	    for (int i = 9; i >= 0; i--) {
	        if (odd) {
	            for (int j = 0; j < 10; j++) {
	                board[i][j] = position;
	                position++;
	            }
	            odd = false;
	        } else {
	            for (int j = 9; j >= 0; j--) {
	                board[i][j] = position;
	                position++;
	            }
	            odd = true;
	        }
	    }
	    System.out.println("-".repeat(5 * 10 ));
	    for (int i = 0; i < 10; i++) {
	        System.out.print("|");
	        for (int j = 0; j < 10; j++) {
	           for(int k=0;k<Player.pl.length;k++) {
	        	   if(i==location[k][0]&&j==location[k][1]) {
	        		   System.out.print(" P"+ LadderAndSnake.player[k]);
	        		   continue;
	        	   }
	           }
	            System.out.printf("%3d ", board[i][j]);
	            System.out.print("|");
	        }
	        System.out.println();
	        System.out.println("-".repeat(5 * 10 ));
	    }
	}
}
