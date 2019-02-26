public class Meteor {
  private String ascii;
  private int[] origo;
	
	Meteor() {
		ascii = "MMM8&&&MMMM88&&&MMMM88&&&&&MMMM88&&&MMM8&&&";
		origo = new int[] {15, 90};
	}


  public void fall() {
    origo[0] += 1;
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
		return coordinates;
	}
  public String getAscii() {return ascii;}
}
