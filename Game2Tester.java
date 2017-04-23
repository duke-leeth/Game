import java.io.*;
import java.util.*;
import java.lang.*;

public class Game2Tester {

  static int boundry = 8;
  static int maxActions = 6;
  static int[] initialLocation = {2, 3};
  static int[] targetLocation = {3, 4};
  static String initialDirection = "N";
  static String targetDirection = "N";

  public static void main(String[] args) throws Exception {
    Game2 game = new Game2();
    Game1 correction = new Game1();

    try {
      setInitialCondition(correction, game);

      System.out.println( "Possible solution: \n" );
      for (String sol : game.getSolution()) {
        System.out.print(sol + "\t");

        if ( isCorrect(correction, targetLocation, targetDirection, sol) ) {
          System.out.println( "... Correct!" );
        }
      }

    } catch(Exception ex) {
      System.out.println(ex);
    }
  }

  private static void setInitialCondition(Game1 correction, Game2 game) {
    game.setBoundry(boundry);
    game.setInitialLocation(initialLocation);
    game.setInitialDirection(initialDirection);
    game.setMaxActions(maxActions);
    game.setTargetLocation(targetLocation);
    game.setTargetDirection(targetDirection);

    correction.setBoundry(boundry);
  }

  private static boolean isCorrect(Game1 correction, int[] targetLocation,
                                    String targetDirection, String sol) {
    correction.setInitialLocation(initialLocation);
    correction.setInitialDirection(initialDirection);
    correction.executeActionSequence(sol);
    return correction.getResultLocation().equals(
                "[" + targetLocation[0] + ", " + targetLocation[1] +  "]")
            &&
            correction.getResultDirection().equals(targetDirection);
  }

}
