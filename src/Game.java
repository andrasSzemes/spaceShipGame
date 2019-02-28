import java.io.*;
import com.codecool.termlib.*;

public class Game {
    // min consoleWidth = 30???
    public static void main(String[] args) {
        Terminal myTerminal = new Terminal();
        int[] consoleDimensions = myTerminal.getConsoleDimensions();
        Board myBoard = new Board(consoleDimensions);
        Spaceship myShip = new Spaceship(consoleDimensions);
        Meteor[] meteors = createMeteors(consoleDimensions, myBoard);

	    Terminal.clearScreen();
        myBoard.printEmptyBoard();

        while (true) {
            myBoard.printShip(myShip, false);
            for(Meteor meteor : meteors){
                myBoard.printMeteor(meteor, false);
            }

	        moveShip(myShip);
	        for(Meteor meteor : meteors){
                meteor.fall(consoleDimensions[0]);
            }

            Terminal.setColor(Color.YELLOW);
            myBoard.printShip(myShip, true);
            Terminal.setColor(Color.RED);
            for (Meteor meteor : meteors) {
                myBoard.printMeteor(meteor, true);
            }

            Terminal.moveTo(new Integer(myBoard.getHeight()-2), new Integer(1));

            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
    }

    private static Meteor[] createMeteors(int[] consoleDimensions, Board myBoard){
        int terminalWidth = consoleDimensions[1];
        int countOfMeteors = myBoard.getNumOfMeteors(consoleDimensions[1]);
        int margin = 10;
        int start = 5;
        int end;      
        Meteor[] meteors = new Meteor[countOfMeteors];
        for(int i = 0; i < countOfMeteors; i++){
            int marginRight = (i == countOfMeteors - 1) ? 0 : margin / 2;

            end = (int) Math.floor((terminalWidth - margin) / countOfMeteors) * (i + 1) - marginRight;
            Meteor newMeteor = new Meteor(start, end);
            meteors[i] = newMeteor;
            start = end + margin;
        }
        return meteors;    
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
