import java.io.*;
import java.util.*;
import java.lang.*;

public class Game1Tester {
  public static void main(String[] args) throws Exception {
    Game1 game = new Game1();
    try {
      game.setBoundry(2);
      game.setInitialLocation(2, 3);
      game.setInitialDirection("N");

      game.executeActionSequence("M,M,M,L,M,R,R,R");

      System.out.println( game.getResultLocation() );
      System.out.println( game.getResultDirection() );

    } catch(Exception ex) {
      System.out.println(ex);
    }

  }
}
