import java.io.*;
import java.util.*;
import java.lang.*;

public class GameTester {
  public static void main(String[] args) throws Exception {
    Game game = new Game();
    try {
      game.setBoundry(8);
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
