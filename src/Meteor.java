import java.util.Arrays;
import java.util.Random;

public class Meteor {
    private final String ASCII = "MMM8&&&MMMM88&&&MMMM88&&&&&MMMM88&&&MMM8&&&";
    private int[] origo;
    private boolean attack = true;
    private int origoStart;
    private int origoEnd;
    private Random random = new Random();

	Meteor(int start, int end){
        this.origoStart = start;
        this.origoEnd = end;
		origo = new int[] {(int)(random.nextInt(50) + 1) * (-1), (int)random.nextInt(end - start) + start};
	}

    public void fall(int numOfRows) {
        int maxFallHeight = 49;

		if(origo[0] < numOfRows) {
			origo[0] += 1;
		} else {
  			origo[0] = (int)(-1) * (random.nextInt(maxFallHeight) + 1);
        origo[1] = (int)random.nextInt(this.origoEnd - this.origoStart) + this.origoStart;
        setAttack(true);
		}
  }
	  public int getOrigoY() {return origo[0];}
    public int getOrigoX() {return origo[1];}
    public boolean getAttack() {return attack;}
    public void setAttack(boolean value){attack = value;}
    public int[][] getCoord(int numOfRows) {
		int[][] coordinates = {
			{origo[0]-2, origo[1]-3}, {origo[0]-2, origo[1]-2}, {origo[0]-2, origo[1]-1}, {origo[0]-2, origo[1]}, {origo[0]-2, origo[1]+1},
			{origo[0]-2, origo[1]+2}, {origo[0]-2, origo[1]+3},
			{origo[0]-1, origo[1]-4}, {origo[0]-1, origo[1]-3}, {origo[0]-1, origo[1]-2}, {origo[0]-1, origo[1]-1}, {origo[0]-1, origo[1]},
			{origo[0]-1, origo[1]+1}, {origo[0]-1, origo[1]+2}, {origo[0]-1, origo[1]+3}, {origo[0]-1, origo[1]+4},
			{origo[0], origo[1]-5}, {origo[0], origo[1]-4}, {origo[0], origo[1]-3}, {origo[0], origo[1]-2}, {origo[0], origo[1]-1},
			{origo[0], origo[1]}, {origo[0], origo[1]+1}, {origo[0], origo[1]+2}, {origo[0], origo[1]+3}, {origo[0], origo[1]+4},
			{origo[0], origo[1]+5},
			{origo[0]+1, origo[1]-4}, {origo[0]+1, origo[1]-3}, {origo[0]+1, origo[1]-2}, {origo[0]+1, origo[1]-1}, {origo[0]+1, origo[1]},
			{origo[0]+1, origo[1]+1}, {origo[0]+1, origo[1]+2}, {origo[0]+1, origo[1]+3}, {origo[0]+1, origo[1]+4},
			{origo[0]+2, origo[1]-3}, {origo[0]+2, origo[1]-2}, {origo[0]+2, origo[1]-1}, {origo[0]+2, origo[1]}, {origo[0]+2, origo[1]+1},
			{origo[0]+2, origo[1]+2}, {origo[0]+2, origo[1]+3}
		};

		return (origo[0] < -2 | origo[0] > numOfRows + 2) ? new int[1][1] : coordinates;
	}
    public String getAscii() {return ASCII;}
}
