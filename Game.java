
public class Game {
  Agent agent = new Agent();
  int boundry = 0;

  public Game() {}

  public void setBoundry(int boundry) {
    agent.setBoundry(boundry);
  }

  public void setInitialLocation(int[] location) {
    this.setInitialLocation(location[0], location[1]);
  }

  public void setInitialLocation(int positionX, int positionY) {
    agent.setLocation(positionX, positionY);
  }

  public void setInitialDirection(String direction) {
    agent.setDirection(direction);
  }

  public String getResultLocation() {
    return agent.getLocation();
  }

  public String getResultDirection() {
    return agent.getDirection();
  }

}
