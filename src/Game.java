import java.io.*;
import com.codecool.termlib.*;

public class Game {
    // min consoleWidth = 30???
    public static void main(String[] args) {
        Terminal myTerminal = new Terminal();
        int[] consoleDimensions = myTerminal.getConsoleDimensions();
        Board myBoard = new Board(consoleDimensions);
        Spaceship myShip = new Spaceship(consoleDimensions);
        Meteor[] meteors = createMeteors(consoleDimensions);

        while (true) {
            myBoard.print(myShip, meteors);
	    moveShip(myShip);
	    for(Meteor meteor : meteors){
            meteor.fall();
        }
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
    }

    private static Meteor[] createMeteors(int[] consoleDimensions){
        int countOfMeteors = 0;
        int start = 5;
        int end = 0;      
        int meteorWidth = 11;
        int minGap = 17;
        int cols = consoleDimensions[1];
        int remainder = (consoleDimensions[1] - 10) % meteorWidth;
        int ratio = (int) Math.floor((cols - 10) / meteorWidth);
        if(remainder < minGap){
            if(ratio > 2){
                countOfMeteors = ratio - 2;
            } else {
                countOfMeteors = ratio - 1;
            }
        } else {
            countOfMeteors = ratio;
        }
        Meteor[] meteors = new Meteor[countOfMeteors];
        int[] starts = new int[countOfMeteors];
        int[] ends = new int[countOfMeteors];
        for(int i = 0; i < countOfMeteors; i++){
            starts[i] = start;
            end = (int) Math.floor((cols - 10) / countOfMeteors) * (i + 1) - 5;
            ends[i] = end;
            Meteor newMeteor = new Meteor(start, end);
            meteors[i] = newMeteor;
            start = end + 10;
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
        }
        catch (Exception e) {}
    }
}
