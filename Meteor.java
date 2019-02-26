import java.util.Arrays;

public class Meteor {
  private final String ASCII = "MMM8&&&MMMM88&&&MMMM88&&&&&MMMM88&&&MMM8&&&";
  private int[] origo = new int[] {-2, 90};

  public void fall() {
		if(origo[0] < 45) {
			origo[0] += 1;
		} else {
			origo[0] = -2;
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
		int[][] newArray;
		switch(origo[0]){
			case -2:
				newArray = Arrays.copyOfRange(coordinates, coordinates.length - 7, coordinates.length);
				break;
			case -1:
				newArray = Arrays.copyOfRange(coordinates, coordinates.length - 16, coordinates.length);
				break;
			case 0:
				newArray = Arrays.copyOfRange(coordinates, coordinates.length - 27, coordinates.length);
				break;
			case 1:
				newArray = Arrays.copyOfRange(coordinates, coordinates.length - 36, coordinates.length);
				break;
			case 41:
				newArray = Arrays.copyOfRange(coordinates, 0, coordinates.length - 7);
				break;
			case 42:
				newArray = Arrays.copyOfRange(coordinates, 0, coordinates.length - 16);
				break;
			case 43:
				newArray = Arrays.copyOfRange(coordinates, 0, coordinates.length - 27);
				break;
			case 44:
				newArray = Arrays.copyOfRange(coordinates, 0, coordinates.length - 36);
				break;
			case 45:
				newArray = new int[1][1];
				break;
			default:
				newArray = coordinates;
				break;
		}
		return newArray;
	}
  public String getAscii() {return ASCII;}
}
