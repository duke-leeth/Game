import java.io.*;
import java.util.*;

/**
 * File: Game2.java
 * Author: Tsunghan Lee
 * Date: Apr 23 2017
 *
 * Extending Game class and add new feature to perform path searching in order
 * to become version 2 game.
 */


/**
 * @author Tsunghan Lee
 *
 */
public class Game2 extends Game{
  private static final String[] actionOptionArray = {"M", "L", "R"};
  private ArrayList<String> record = new ArrayList<>();
  private ArrayList<String> solution = new ArrayList<>();
  private int maxActions = 0;
  private Agent agent = super.agent;
  private Agent targetAgent = new Agent();

  public Game2() {
    super();
  }

  public ArrayList<String> getSolution() {
    this.backtracking();
    return solution;
  }

  public void setBoundry(int boundry) {
    super.setBoundry(boundry);
    targetAgent.setBoundry(boundry);
  }

  public void setMaxActions(int maxActions) {
    this.maxActions = maxActions;
  }

  public void setTargetLocation(int[] targetLocation) {
    this.setTargetLocation(targetLocation[0], targetLocation[1]);
  }

  public void setTargetLocation(int positionX, int positionY) {
    targetAgent.setLocation(positionX, positionY);
  }

  public void setTargetDirection(String targetDirection) {
    targetAgent.setDirection(targetDirection);
  }

  public void backtracking() {
    int[] currLocation = agent.getLocationArrayFormat();
    String currDirection = agent.getDirection();

    if (record.size() > maxActions) {
      record.remove(record.size() - 1);
      return;
    }

    if ( isTargetReached() ) {
      traceProcessor();
      if (record.size() != 0) {
        record.remove(record.size() - 1);
      }
      return;
    }

    for (int i=0 ; i<actionOptionArray.length ; i++) {
      switch(i) {
        case 0:
          agent.moveOneStep();
          break;
        case 1:
          agent.turnLeft();
          break;
        case 2:
          agent.turnRight();
          break;
        default:
          break;
      }

      record.add(actionOptionArray[i]);
      backtracking();

      resetAgentToCurrentPosition(currLocation);
      resetAgentToCurrentDirection(currDirection);
    }
    if (record.size() != 0) {
      record.remove(record.size() - 1);
    }
  }

  // Helper function
  private boolean isTargetReached() {
    int[] location = agent.getLocationArrayFormat();
    int[] targetLocation = targetAgent.getLocationArrayFormat();
    return location[0] == targetLocation[0]
            && location[1] == targetLocation[1]
            && agent.getDirection().equals(targetAgent.getDirection());
  }

  private void traceProcessor() {
    StringBuilder strBuilder = new StringBuilder();
    for (String act : record) {
      strBuilder.append( act );
      strBuilder.append(",");
    }
    strBuilder.trimToSize();
    if (strBuilder.capacity() != 0) {
      strBuilder.deleteCharAt(strBuilder.capacity() - 1);
    }
    this.solution.add(strBuilder.toString());
  }

  private void resetAgentToCurrentPosition(int[] currLocation) {
    agent.setLocation(currLocation[0], currLocation[1]);
  }

  private void resetAgentToCurrentDirection(String currDirection) {
    agent.setDirection(currDirection);
  }

  private void printCurrentStatus() {
    System.out.println("Agent Location: " + agent.getLocation() );
    System.out.println("Direction: " + agent.getDirection());
    System.out.println("Record: " + record + "\n");
  }
}
