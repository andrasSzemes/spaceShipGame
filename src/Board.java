import java.util.Arrays;
import java.lang.*;

public class Board {
    //resolution 183x45
    private static String[][] board;
    private static String fillChar = " ";
    private int rows;
    private int cols;

    Board(int[] consoleDimensions){
        this.rows = consoleDimensions[0];
        this.cols = consoleDimensions[1];
        this.board = new String[consoleDimensions[0] - 2][consoleDimensions[1]];
    }

    public void clear() {

    }
    public void print(Spaceship myShip, Meteor[] myMeteors) {
        System.out.print("\033[H\033[2J");
        for (int i=0; i<board.length; i++) {
            String[] row = new String[this.cols];
            Arrays.fill(row, fillChar);
            board[i] = row;
        }

        placeShip(myShip);
	      for(Meteor myMeteor : myMeteors){
		        placeMeteor(myMeteor);
        }
        for (int i=0; i<board.length; i++) {
            System.out.print(String.join("", board[i]));
        }
        System.out.print(" "); //Extra row for control input
    }

    public void placeMeteor(Meteor myMeteor) {
	     String ascii = myMeteor.getAscii();
	     int[][] coords = myMeteor.getCoord();
	     if(coords.length > 1){
		   for (int i=0; i < coords.length; i++) {
          try {
          	    board[coords[i][0]][coords[i][1]] = ascii.substring(i, i+1);
              }
          catch (ArrayIndexOutOfBoundsException e) {}
      }
	}
    }
    public void placeShip(Spaceship myShip) {
        String ascii = myShip.getAscii();
        int[][] coords = myShip.getCoord();

        for (int i=0; i < ascii.length(); i++) {
            board[coords[i][0]][coords[i][1]] = ascii.substring(i, i+1);
        }
    }
}
