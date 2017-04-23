import java.io.*;
import java.util.*;
import java.lang.*;

public class GameProblem {
  static int boundry = 8;

  public static void main(String[] args) throws Exception {
    try {
      if (args.length != 1) {
        throw new IllegalArgumentException( "Invalid command. \n"
                                  + " Usage: java GameProblem <1> or <2>" );
      } else if ( args[0].equals("1") ) {
        Game1 game = new Game1();
        GameVersion1Executor(game);

      } else if ( args[0].equals("2") ) {
        Game2 game = new Game2();
        GameVersion2Executor(game);
      } else {
        throw new IllegalArgumentException( "Invalid option."
                                + " Usage: java GameProblem <1> or <2>" );
      }
    } catch(Exception ex) {
      System.out.println(ex);
    }

  }

  private static void GameVersion1Executor(Game1 game) {
    Scanner commandReader = new Scanner(System.in);
    game.setBoundry(boundry);

    System.out.println("Game - version 1 ");
    System.out.println(" --- Given a starting position [x,y] (0<x,y<9), "
          + "initial direction faced (W, S, N, E) on 8 x 8 square board "
          + " and sequence of actions for a robot, print the outcome;"
          + " direction faced and position on the board. --- ");
    System.out.println("Allowed Actions: \n"
                        + " M: Move 1 square forward \n"
                        + " L: Turn left \n"
                        + " R: Turn right \n");

    System.out.print("Location: (Format:[<x>,<y>]): ");
    game.setInitialLocation( parseLocation( commandReader.nextLine() ) );

    System.out.print("Direction faced: (Format:<N> or <S> or <E> or <W>): ");
    game.setInitialDirection( commandReader.nextLine() );


    System.out.print("Actions: (Format: <M>,<L>,<R>): ");
    game.executeActionSequence( commandReader.nextLine() );

    System.out.println("");
    System.out.println( "Output: ");
    System.out.println( "Location : " + game.getResultLocation() );
    System.out.println( "Direction faced: " + game.getResultDirection() );
  }

  private static void GameVersion2Executor(Game2 game) {
    Scanner commandReader = new Scanner(System.in);
    game.setBoundry(boundry);

    System.out.println("Game - version 2 ");
    System.out.println(" --- Given a starting position [x,y] (0<x,y<9), "
          + "initial direction faced (W, S, N, E) on 8 x 8 square board "
          + " and the target position, direction "
          + " and maximum actions allowed,"
          + " print all possible actions robot can make"
          + " to get to that position. --- ");
    System.out.println("Allowed Actions: \n"
                      + " M: Move 1 square forward \n"
                      + " L: Turn left \n"
                      + " R: Turn right \n");

    System.out.print("Original Location: (Format:[<x>,<y>]): ");
    game.setInitialLocation( parseLocation( commandReader.nextLine() ) );

    System.out.print("Original Direction faced: "
                      + "(Format:<N> or <S> or <E> or <W>): ");
    game.setInitialDirection( commandReader.nextLine() );

    System.out.print("Target Location: (Format:[<x>,<y>]): ");
    game.setTargetLocation( parseLocation( commandReader.nextLine() ) );

    System.out.print("Target Direction faced: "
                      + "(Format:<N> or <S> or <E> or <W>): ");
    game.setTargetDirection( commandReader.nextLine() );

    System.out.print("Maximum actions allowed: ");
    game.setMaxActions( Integer.parseInt(commandReader.nextLine()) );

    System.out.println("");
    System.out.println( "Output: ");
    System.out.println( "Possible solution: \n" );
    System.out.println( "\t Running");
    for (String sol : game.getSolution()) {
      System.out.println(sol);
      }

  }

  private static int[] parseLocation(String location) {
    int[] result = {0, 0};
    StringBuilder strBuilder = new StringBuilder();
    String[] tmp;

    try {
      for (int i=1 ; i<location.length()-1 ; i++) {
        strBuilder.append( location.charAt(i) );
      }
      tmp = strBuilder.toString().split(",");
      if (tmp.length != 2) {
        throw new IllegalArgumentException("Invalid Location format.");
      }
      result[0] = Integer.parseInt(tmp[0]);
      result[1] = Integer.parseInt(tmp[1]);
    } catch (Exception ex) {
      throw new IllegalArgumentException(
              "Invalid Location format: " + location);
    }
    return result;
  }


}
