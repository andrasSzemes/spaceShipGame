import java.util.Arrays;
import java.lang.*;
import com.codecool.termlib.*;

public class Board {
    //resolution 183x45
    private static String[][] board = new String[45][183];
    private static String fillChar = " ";

    public int getHeight() {
        return board.length;
    }

    public static void printEmptyBoard() {
        for (int i=0; i<board.length; i++) {
            String[] row = new String[183];
            Arrays.fill(row, fillChar);
            board[i] = row;
        }

        for (int i=0; i<board.length; i++) {
            System.out.print(String.join("", board[i]));
        }

        System.out.print(" "); //Extra row for control input
    }

    public void printMeteor(Meteor myMeteor, boolean bool) {
	     String ascii = myMeteor.getAscii();
	     int[][] coords = myMeteor.getCoord();
	     if(coords.length > 1){
		   for (int i=0; i < coords.length; i++) {
            if (coords[i][0] > 0 && coords[i][0] < board.length) {
          	    Terminal.moveTo(new Integer(coords[i][0]), new Integer(coords[i][1]));
                Terminal.setChar(bool ? ascii.charAt(i) : ' ');
            }
      }
	}
    }
    public void printShip(Spaceship myShip, boolean bool) {
        String ascii = myShip.getAscii();
        int[][] coords = myShip.getCoord();

        for (int i=0; i < ascii.length(); i++) {
            Terminal.moveTo(new Integer(coords[i][0]), new Integer(coords[i][1]));
            Terminal.setChar(bool ? ascii.charAt(i) : ' ');
        }
    }
}
