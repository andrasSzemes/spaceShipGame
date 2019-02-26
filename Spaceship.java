public class Spaceship {
    private String ascii = "_/\\/_\\|()||_|";
    private int[] origo = new int[]{39, 90};
    private int[][] coordinates = new int[][] {{origo[0]-5, origo[1]},
        {origo[0]-4, origo[1]-1},{origo[0]-4, origo[1]+1},{origo[0]-3, origo[1]-2},
        {origo[0]-3, origo[1]},{origo[0]-3, origo[1]+2},{origo[0]-2, origo[1]-3},
        {origo[0]-2, origo[1]-1},{origo[0]-2, origo[1]+1},{origo[0]-2, origo[1]+3},
        {origo[0]-1, origo[1]-3},{origo[0]-1, origo[1]},{origo[0]-1, origo[1]+3},};

    public void move() {

    }

    public int getOrigoY() {return origo[0];}
    public int getOrigoX() {return origo[1];}
    public int[][] getCoord() {return coordinates;}

    public String getAscii() {return ascii;}
}
