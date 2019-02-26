import java.io.*;

public class Game {
    public static void main(String[] args) {
        Board myBoard = new Board();
        Spaceship myShip = new Spaceship();
	      Meteor myMeteor = new Meteor();

        while (true) {
            myBoard.print(myShip, myMeteor);
            moveShip(myShip);

	          //myMeteor.fall();
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
        }
        catch (Exception e) {}
    }
}
