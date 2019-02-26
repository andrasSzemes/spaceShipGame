public class Game {
    public static void main(String[] args) {
        Board myBoard = new Board();
        Spaceship myShip = new Spaceship();

        while (true) {
            myBoard.print(myShip);
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
    }
}
