import java.io.*;
import com.codecool.termlib.*;

public class Game {
    public static void main(String[] args) {
        Board myBoard = new Board();
        Spaceship myShip = new Spaceship();
	      Meteor slowMeteor = new Meteor(90);
	      Meteor mediumMeteor = new Meteor(30);
	      Meteor fastMeteor = new Meteor(150);

        Terminal.clearScreen();
        Board.printEmptyBoard();

        while (true) {
            //myBoard.printFrame(myShip, new Meteor[] {slowMeteor, mediumMeteor, fastMeteor});
            myBoard.printShip(myShip, false);
            for (Meteor meteor : new Meteor[] {slowMeteor, mediumMeteor, fastMeteor}) {
                myBoard.printMeteor(meteor, false);
            }

      	    moveShip(myShip);
            slowMeteor.fall();
      	    mediumMeteor.fall();
      	    fastMeteor.fall();

            Terminal.setColor(Color.YELLOW);
            myBoard.printShip(myShip, true);
            Terminal.setColor(Color.RED);
            for (Meteor meteor : new Meteor[] {slowMeteor, mediumMeteor, fastMeteor}) {
                myBoard.printMeteor(meteor, true);
            }
            Terminal.moveTo(new Integer(myBoard.getHeight()-2), new Integer(1));

            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
    }

    private static Character tryToRead() {
        try {
            if (System.in.available() > 0) {
                char pressedKey = (char) System.in.read();

                for (int i=0; i < System.in.available(); i++) {
                  System.in.read();
                }

                return pressedKey;
            }
        }
        catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
        return null;
    }

    private static void moveShip(Spaceship myShip) {
        try {
            char pressedKey = tryToRead();

            if (pressedKey == 'a' && myShip.getOrigoX() > 8) myShip.moveLeft();
            if (pressedKey == 'd' && myShip.getOrigoX() < 174) myShip.moveRight();
            if (pressedKey == 'q') System.exit(0);
        }
        catch (Exception e) {}
    }
}
