import java.io.*;
import java.util.Arrays;


public class Game {

    public static void main(String[] args) {
        Board myBoard = new Board();
        Spaceship myShip = new Spaceship();
        Meteor slowMeteor = new Meteor(90);
        Meteor mediumMeteor = new Meteor(30);
        Meteor fastMeteor = new Meteor(150);
        LifeDisplay myLife = new LifeDisplay();
        Missile myMissile = new Missile();
        while (true) {
             handleMissile(myShip, myMissile);
             myBoard.print(myShip,new Meteor[] {slowMeteor, mediumMeteor, fastMeteor}, myLife, myMissile);
             lifeHandling(myShip, new Meteor[] {slowMeteor, mediumMeteor, fastMeteor});
             checkAndHandleHit(myMissile, new Meteor[] {slowMeteor, mediumMeteor, fastMeteor});
             moveShip(myShip);
             myMissile.moveUp();
             slowMeteor.fall();
       	     mediumMeteor.fall();
       	     fastMeteor.fall();
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }

    }



    private static Character tryToRead() {
        try {
            if (System.in.available() > 0) {
                char pressedKey = (char) System.in.read();

                for (int i=0; i < System.in.available(); i++) {
                  System.in.read();
                }

                return pressedKey;
            }
        }
        catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
        return null;
    }


    private static void handleMissile(Spaceship myShip, Missile myMissile) {
        try {
            char pressedKey = tryToRead();
              if (pressedKey == 's' && myMissile.getActivated() == false) {
                myMissile.setActivated(true);
                myMissile.setOrigo(myShip.getOrigoY()-6, myShip.getOrigoX());
              }
        }
        catch (Exception e) {}
    }


    private static void moveShip(Spaceship myShip) {
        try {
            char pressedKey = tryToRead();

            if (pressedKey == 'a' && myShip.getOrigoX() > 8) myShip.moveLeft();
            if (pressedKey == 'd' && myShip.getOrigoX() < 174) myShip.moveRight();
        }
        catch (Exception e) {}
    }

    public static void checkAndHandleHit(Missile myMissile, Meteor[] myMeteors) {
      int[] origo = myMissile.getOrigo();
      for(Meteor myMeteor : myMeteors){
        boolean attack = myMeteor.getAttack();
        for( int[] meteorcoord : myMeteor.getCoord()){
          if( Arrays.toString(origo).equals(Arrays.toString(meteorcoord)) && (attack == true)) {
            attack = false;
            myMeteor.setAttack(false);
            myMissile.setActivated(false);
            myMissile.setInvisible(true);
            myMissile.removeOrigo();
          }
        }
       }
     }


    public static void lifeHandling(Spaceship myShip, Meteor[] myMeteors) {
      for(Meteor myMeteor : myMeteors){
          boolean attack = myMeteor.getAttack();
          if(attack == true){
            for( int[] meteorcoord : myMeteor.getCoord()){
              for (int[] shipcoord : myShip.getCoord()){
                if( Arrays.toString(shipcoord).equals(Arrays.toString(meteorcoord)) && (attack == true)) {
                  myShip.decreaseLife();
                  myMeteor.setAttack(false);
                  attack = false;
                }
              }
            }
         }
      }
    }
}
