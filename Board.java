import java.util.Arrays;

public class Board {
    //resolution 180x45
    private static String[][] board = new String[45][183];
    private static String fillChar = " ";

    public void clear() {

    }
    public void print(Spaceship myShip, Meteor myMeteor) {
        System.out.print("\033[H\033[2J");
        for (int i=0; i<board.length; i++) {
            String[] row = new String[183];
            Arrays.fill(row, fillChar);
            board[i] = row;
        }

        placeShip(myShip);
	placeMeteor(myMeteor);

        for (int i=0; i<board.length; i++) {
            System.out.print(String.join("", board[i]));
        }
    }
    public void placeMeteor(Meteor myMeteor) {
	String ascii = myMeteor.getAscii();
	int[][] coords = myMeteor.getCoord();
	for (int i=0; i < ascii.length(); i++) {
            board[coords[i][0]][coords[i][1]] = ascii.substring(i, i+1);
        }
    }
    public void placeShip(Spaceship myShip) {
        String ascii = myShip.getAscii();
        int[][] coords = myShip.getCoord();

        for (int i=0; i < ascii.length(); i++) {
            board[coords[i][0]][coords[i][1]] = ascii.substring(i, i+1);
        }

        board[myShip.getOrigoY()][myShip.getOrigoX()] = "O";
    }
}
