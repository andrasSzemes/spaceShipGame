public class Spaceship {
    private final String ASCII = "_/\\/_\\|()||_|||||/||\\/||\\/|_|\\(_______________)()()";
    //         _
    //        / \
    //       / _ \
    //      | ( ) |
    //      |  _  |
    //      | | | |
    //     /  | |  \
    //   /    | |    \
    //  /     |_|     \
    // (_______________)
    //      ( ) ( )
    private int[] origo = new int[]{37, 90};
    private int life = 3;
    public void move() {

    }

    public int getOrigoY() {return origo[0];}
    public int getOrigoX() {return origo[1];}

    public int getLife() {return life;}
    public void decreaseLife() {life -= 1;}
    public int[][] getCoord() {
      //each line is a row from the ascii art
      int[][] coordinates = new int[][] {
          {origo[0]-5, origo[1]},
          {origo[0]-4, origo[1]-1},{origo[0]-4, origo[1]+1},
          {origo[0]-3, origo[1]-2},{origo[0]-3, origo[1]},{origo[0]-3, origo[1]+2},
          {origo[0]-2, origo[1]-3},{origo[0]-2, origo[1]-1},{origo[0]-2, origo[1]+1},{origo[0]-2, origo[1]+3},
          {origo[0]-1, origo[1]-3},{origo[0]-1, origo[1]},{origo[0]-1, origo[1]+3},
          {origo[0], origo[1]-3},{origo[0], origo[1]-1},{origo[0], origo[1]+1},{origo[0], origo[1]+3},
          {origo[0]+1, origo[1]-4},{origo[0]+1, origo[1]-1},{origo[0]+1, origo[1]+1},{origo[0]+1, origo[1]+4},
          {origo[0]+2, origo[1]-6},{origo[0]+2, origo[1]-1},{origo[0]+2, origo[1]+1},{origo[0]+2, origo[1]+6},
          {origo[0]+3, origo[1]-7},{origo[0]+3, origo[1]-1},{origo[0]+3, origo[1]},{origo[0]+3, origo[1]+1},{origo[0]+3, origo[1]+7},
          {origo[0]+4, origo[1]-8},{origo[0]+4, origo[1]-7},{origo[0]+4, origo[1]-6},{origo[0]+4, origo[1]-5},
          {origo[0]+4, origo[1]-4},{origo[0]+4, origo[1]-3},{origo[0]+4, origo[1]-2},{origo[0]+4, origo[1]-1},{origo[0]+4, origo[1]},
          {origo[0]+4, origo[1]+1},{origo[0]+4, origo[1]+2},{origo[0]+4, origo[1]+3},{origo[0]+4, origo[1]+4},
          {origo[0]+4, origo[1]+5},{origo[0]+4, origo[1]+6},{origo[0]+4, origo[1]+7},{origo[0]+4, origo[1]+8},
          {origo[0]+5, origo[1]-3},{origo[0]+5, origo[1]-1},{origo[0]+5, origo[1]+1},{origo[0]+5, origo[1]+3}};
      return coordinates;
    }

    public String getAscii() {return ASCII;}

    public void moveRight() {origo[1] += 2;}
    public void moveLeft() {origo[1] -= 2;}

}
