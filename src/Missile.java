import java.util.Arrays;

public class Missile {
  private final String ASCII = "0";
  private int[] origo;
  private boolean invisible = false;
  private boolean activated = false;


  public boolean getInvisible() {return invisible;}
  public void setInvisible(boolean value){invisible = value;}
  public boolean getActivated() {return activated;}
  public void setActivated(boolean value){activated = value;}
  public void setOrigo(int row, int col){origo = new int[]{row, col};}
  public void removeOrigo(){origo = null;}


  public void moveUp() {
    if(activated == true){
      try{
    		if(origo[0] > 0) {
    			origo[0] -= 1;
    		} else {
    			origo[0] = 45;
          invisible = false;
          activated = false;
    		}
      } catch(Exception e){}
    }
  }


	public int[] getOrigo() {return origo;}
  public String getAscii() {return ASCII;}
}
