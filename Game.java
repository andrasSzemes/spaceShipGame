public class Game {
    public static void main(String[] args) {
        Board myBoard = new Board();
        Spaceship myShip = new Spaceship();
	Meteor myMeteor = new Meteor();

        while (true) {
            myBoard.print(myShip, myMeteor);
	    myMeteor.fall();
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
    }
}
