/**
 * File: Game1.java
 * Author: Tsunghan Lee
 * Date: Apr 23 2017
 *
 * Extending Game class and add action-taking sequence method to form
 * the version 1 game.
 */


/**
 * @author Tsunghan Lee
 *
 */
public class Game1 extends Game {
  private Agent agent = super.agent;

  public Game1() {
    super();
  }

  public void executeActionSequence(String actSequence) {
    for (String act : actSequence.split(",") ) {
      if ( act.equals("M") ) {
        agent.moveOneStep();
      } else if (act.equals("L")) {
        agent.turnLeft();
      } else if (act.equals("R")) {
        agent.turnRight();
      } else {
        continue;
      }
    }
  }

}
