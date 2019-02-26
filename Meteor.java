import java.util.Arrays;

public class Meteor {
  private String ascii;
  private int[] origo;
	
	Meteor() {
		ascii = "MMM8&&&MMMM88&&&MMMM88&&&&&MMMM88&&&MMM8&&&";
		origo = new int[] {15, 90};
	}


  public void fall() {
		if(origo[0] < 47) {
			origo[0] += 1;		
		} else {
			origo[0] = 15;
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
			case 43:
				newArray = Arrays.copyOfRange(coordinates, 0, coordinates.length - 7);
				break;
			case 44:
				newArray = Arrays.copyOfRange(coordinates, 0, coordinates.length - 16);
				break;
			case 45:
				newArray = Arrays.copyOfRange(coordinates, 0, coordinates.length - 27);
				break;
			case 46:
				newArray = Arrays.copyOfRange(coordinates, 0, coordinates.length - 36);
				break;
			case 47:
				newArray = new int[1][1];
				break;
			default:
				newArray = coordinates;
				break;
		}
		return newArray;
	}
  public String getAscii() {return ascii;}
}
