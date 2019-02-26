public class Game {
    public static void main(String[] args) {
        Board myBoard = new Board();
        Spaceship myShip = new Spaceship();
	Meteor slowMeteor = new Meteor(90,1);
	Meteor mediumMeteor = new Meteor(30,1);
	Meteor fastMeteor = new Meteor(150,1);

        while (true) {
            myBoard.print(myShip, new Meteor[] {slowMeteor, mediumMeteor, fastMeteor});
	    slowMeteor.fall();
	    mediumMeteor.fall();
	    fastMeteor.fall();
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
    }
}
