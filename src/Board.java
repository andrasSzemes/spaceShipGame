import java.util.Arrays;
import com.codecool.termlib.Terminal;

public class Board {
    //resolution 183x43
    private static String[][] board = new String[43][183];
    private static String fillChar = " ";

    public void print(Spaceship myShip, Meteor[] myMeteors, LifeDisplay myLife, Missile myMissile) {
        Terminal.clearScreen();
        for (int i=0; i<board.length; i++) {
            String[] row = new String[183];
            Arrays.fill(row, fillChar);
            board[i] = row;
        }
        placeMissile(myMissile);
        placeLife(myLife, myShip);
        placeShip(myShip);
        for(Meteor myMeteor : myMeteors){
           boolean touchShip = myMeteor.getAttack();
           if(touchShip == true ) {placeMeteor(myMeteor);}
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
        	    board[coords[i][0]][coords[i][1]] = ascii.substring(i, i+1);
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


    public void placeLife(LifeDisplay myLife, Spaceship myShip) {
        int life = myShip.getLife();
        String[] ascii = myLife.getAscii(life);

        for(int row = 0; row < ascii.length; row++){
           for (int i=0; i < ascii[row].length(); i++) {
              board[row][i] = ascii[row].substring(i, i+1);
           }
        }
    }


    public void placeMissile(Missile myMissile) {
        String ascii = myMissile.getAscii();
        int[] origo = myMissile.getOrigo();
        try{
          board[origo[0]][origo[1]] = ascii;
        } catch(Exception e){}
    }


}
