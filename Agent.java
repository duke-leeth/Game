import java.lang.*;

public class Agent{
//  private Coordinate initialLocation = new Coordinate(0, 0);
//  private String initialDirection = "N";
  private Coordinate location = new Coordinate(0, 0);
  private String direction = "N";
  private int boundry = 0;


  public Agent() {}

/*
  public Agent(Coordinate initialLocation
                , String initialDirection
                , int boundry) {
    int[] locationArray = initialLocation.getCoordinateArrayFormat();
    this.initialLocation = new Coordinate(locationArray[0], locationArray[1]);
    this.setLocation(locationArray[0], locationArray[1]);
    this.initialDirection = initialDirection;
    this.setDirection(initialDirection);
    this.boundry = boundry;
  }
*/

/*
  public String getInitialLocation() {
    return this.initialLocation.getCoordinateStringFormat();
  }
*/
  public String getLocation() {
    return location.getCoordinateStringFormat();
  }
/*
  public String getInintialDirection() {
    return this.initialDirection;
  }
*/
  public String getDirection() {
    return direction;
  }

  public int getBoundry() {
    return boundry;
  }
/*
  public void setInitialLocation(int positionX, int positionY) {
    if ( !locationIsValid(positionX, positionY) ) {
      throw new IllegalArgumentException("Invalid location within the boundry");
    }
    this.initialLocation = new Coordinate(positionX, positionY);
    this.setLocation(positionX, positionY);
  }
*/
  public void setLocation(int positionX, int positionY) {
    Coordinate newLocation = new Coordinate(positionX, positionY);
    if ( !locationIsValid(positionX, positionY) ) {
      throw new IllegalArgumentException( "Invalid location: "
                                      + newLocation.getCoordinateStringFormat()
                                      + " is not within the boundry");
    }
    this.location = newLocation;
  }
/*
  public void setInitialDirection(String direction) {
    if ( !directionIsValid(direction) ) {
      throw new IllegalArgumentException("Invalid direction: " + direction);
    }
    this.initialDirection = direction;
    this.setDirection(direction);
  }
*/
  public void setDirection(String direction) {
    if ( !directionIsValid(direction) ) {
      throw new IllegalArgumentException("Invalid direction: " + direction);
    }
    this.direction = direction;
  }

  public void setBoundry(int boundry) {
    this.boundry = boundry;
  }

  public void turnRight() {
    if ( direction.equals("N") ) {
      this.setDirection("E");
    } else if ( direction.equals("S") ) {
      this.setDirection("W");
    } else if ( direction.equals("E") ) {
      this.setDirection("S");
    } else if ( direction.equals("W") ) {
      this.setDirection("N");
    } else {
      throw new IllegalArgumentException("Invalid right-hand turning");
    }
  }

  public void turnLeft() {
    if ( direction.equals("N") ) {
      this.setDirection("W");
    } else if ( direction.equals("S") ) {
      this.setDirection("E");
    } else if ( direction.equals("E") ) {
      this.setDirection("N");
    } else if ( direction.equals("W") ) {
      this.setDirection("S");
    } else {
      throw new IllegalArgumentException("Invalid left-hand turning");
    }
  }

  public void moveOneStep() {
    int[] originalCoordArray = this.location.getCoordinateArrayFormat();
    if ( direction.equals("N") ) {
      location.moveNorthOneStep();
    } else if ( direction.equals("S") ) {
      location.moveSouthOneStep();
    } else if ( direction.equals("E") ) {
      location.moveEastOneStep();
    } else if ( direction.equals("W") ) {
      location.moveWestOneStep();
    } else {
      throw new IllegalArgumentException("Invalid movement");
    }

    if ( !locationIsValid(location) ) {
      location.setCoordinate(originalCoordArray);
    }
  }


  // Helper function
  private boolean locationIsValid(Coordinate coord) {
    return locationIsValid( coord.getCoordinateArrayFormat() );
  }

  private boolean locationIsValid(int[] coordArray) {
    return locationIsValid(coordArray[0], coordArray[1]);
  }

  private boolean locationIsValid(int positionX, int positionY) {
    return 0 < positionX
            && positionX < this.boundry+1
            && 0 < positionY
            && positionY < this.boundry+1;
  }

  private boolean directionIsValid(String direction) {
    return direction.equals("N")
            || direction.equals("S")
            || direction.equals("E")
            || direction.equals("W");
  }

}
