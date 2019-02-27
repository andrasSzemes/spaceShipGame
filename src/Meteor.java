import java.util.Arrays;

public class Meteor {
  private final String ASCII = "MMM8&&&MMMM88&&&MMMM88&&&&&MMMM88&&&MMM8&&&";
  private int[] origo;
	private int velocity;

	Meteor(int col){
		origo = new int[] {(int)(Math.random() * (-15) - 1), col};
	}

  public void fall() {
		if(origo[0] < 47) {
			origo[0] += 1;
		} else {
			origo[0] = (int)(Math.random() * (-50) - 1);
		}
  }
	public int getOrigoY() {return origo[0];}
  public int getOrigoX() {return origo[1];}

  public int[][] getCoord() {
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

		return (origo[0] < -2 | origo[0] > 47) ? new int[1][1] : coordinates;
	}
  public String getAscii() {return ASCII;}
}
