public class LifeDisplay {

  private  String LIFE_ASCCI_ONE =   "__   ____  _  _ ___   _   _ ___ ___ ";
  private  String LIFE_ASCCI_TWO =   "\\ `v' /__\\| || | _ \\ | | | | __| __|";
  private  String LIFE_ASCCI_THREE = " `. .| \\/ | \\/ | v / | |_| | _|| _| ";
  private  String LIFE_ASCCI_FOUR =  "  !_! \\__/ \\__/|_|_\\ |___|_|_| |___|";


  public String[] getAscii(int life) {
    if(life == 3){
       String[] yourLifes3 = {
        LIFE_ASCCI_ONE +      "     ___",
        LIFE_ASCCI_TWO +      "    |__ \\ ",
        LIFE_ASCCI_THREE +    "     _[ | ",
        LIFE_ASCCI_FOUR +     "    |___/ ",};
        return yourLifes3;
    } else if (life == 2){
      String[] yourLifes2 = {
        LIFE_ASCCI_ONE +      "     ___",
        LIFE_ASCCI_TWO +      "    |   \\ ",
        LIFE_ASCCI_THREE +    "    '-'_/ ",
        LIFE_ASCCI_FOUR +     "    |___] ",};
       return yourLifes2;
    } else if (life == 1){
      String[] yourLifes1 = {
       LIFE_ASCCI_ONE +      "      ___",
       LIFE_ASCCI_TWO +      "     /   | ",
       LIFE_ASCCI_THREE +    "    /_/| | ",
       LIFE_ASCCI_FOUR +     "       |_| ",};
       return yourLifes1;
    } else{
      String[] yourLifes0 = {
       LIFE_ASCCI_ONE +      "     ___",
       LIFE_ASCCI_TWO +      "    |   | ",
       LIFE_ASCCI_THREE +    "    | \\ | ",
       LIFE_ASCCI_FOUR +     "    |___] ",};
       return yourLifes0;
    }
  }
}
