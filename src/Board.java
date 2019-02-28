import java.util.Arrays;
import java.lang.*;
import com.codecool.termlib.*;

public class Board {
    //resolution 183x45
    private static String[][] board;
    private static String fillChar = " ";
    private static int numOfCols;

    Board(int[] consoleDimensions) {
        this.board = new String[consoleDimensions[0]][consoleDimensions[1]];
        this.numOfCols = consoleDimensions[1];
    }

    public int getHeight() {
        return board.length;
    }

    public void printEmptyBoard() {
        for (int i=0; i<board.length; i++) {
            String[] row = new String[this.numOfCols];
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
	     int[][] coords = myMeteor.getCoord(board.length);
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


    public void printLife(LifeDisplay myLife, Spaceship myShip) {
        int life = myShip.getLife();
        String[] ascii = myLife.getAscii(life);

        for(int row = 0; row < ascii.length; row++){
           for (int i=0; i < ascii[row].length(); i++) {
              Terminal.moveTo(new Integer(row+1), new Integer(i+1));
              Terminal.setChar(ascii[row].charAt(i));
           }
        }
    }


    public void printMissile(Missile myMissile, boolean bool) {
        String ascii = myMissile.getAscii();
        int[] origo = myMissile.getOrigo();
        try{
          Terminal.moveTo(new Integer(origo[0]), new Integer(origo[1]));
          Terminal.setChar(bool ? ascii.charAt(0) : ' ');
        } catch(Exception e){}
    }


    public int getNumOfMeteors(int terminalWidth){
        int shipWidth = 17;
        int meteorWidth = 11;
        int margin = 10; //for showing full meteors
        int remainingEmptyCols = (terminalWidth - margin) % meteorWidth;
        int maxNumOfMeteors = (int) Math.floor((terminalWidth - margin) / meteorWidth);
        int countOfMeteors;

        if(remainingEmptyCols < shipWidth){
            countOfMeteors = (maxNumOfMeteors == 2) ? maxNumOfMeteors - 3 : maxNumOfMeteors - 4;
        } else {
            countOfMeteors = maxNumOfMeteors - 2;
        }
        return countOfMeteors;
    }
}
