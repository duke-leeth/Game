

public class Game {
  private Agent agent = new Agent();
  private int boundry = 0;

  public Game() {}

  public void setBoundry(int boundry) {
    agent.setBoundry(boundry);
  }

  public void setInitialLocation(int positionX, int positionY) {
    agent.setLocation(positionX, positionY);
  }

  public void setInitialDirection(String direction) {
    agent.setDirection(direction);
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

  public String getResultLocation() {
    return agent.getLocation();
  }

  public String getResultDirection() {
    return agent.getDirection();
  }

}
