import java.io.*;
import java.util.*;

public class Coordinate{
  private int positionX = 0;
  private int positionY = 0;

  public Coordinate() {}

  public Coordinate(int[] coordArray) {
    this.setCoordinate(coordArray);
  }

  public Coordinate(int positionX, int positionY) {
    this.setCoordinate(positionX, positionY);
  }

  public String getCoordinateStringFormat() {
    StringBuilder strBuilder = new StringBuilder(6);
    strBuilder.append( "[" );
    strBuilder.append( Integer.toString(this.positionX) );
    strBuilder.append( ", " );
    strBuilder.append( Integer.toString(this.positionY) );
    strBuilder.append( "]" );
    return strBuilder.toString();
  }

  public int[] getCoordinateArrayFormat() {
    int[] location = {this.positionX, this.positionY};
    return location;
  }

  public void setCoordinate(Coordinate coord) {
    this.setCoordinate( coord.getCoordinateArrayFormat() );
  }

  public void setCoordinate(int[] coordArray) {
    this.setCoordinate(coordArray[0], coordArray[1]);
  }

  public void setCoordinate(int positionX, int positionY) {
    this.positionX = positionX;
    this.positionY = positionY;
  }

  public void moveNorthOneStep() {
    positionY++;
  }

  public void moveSouthOneStep() {
    positionY--;
  }

  public void moveEastOneStep() {
    positionX++;
  }

  public void moveWestOneStep() {
    positionX--;
  }
}
