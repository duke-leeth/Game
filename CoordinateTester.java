import java.io.*;
import java.util.*;

public class CoordinateTester{
  public static void main(String[] args) throws IOException {
    Coordinate coor1 = new Coordinate();
    Coordinate coor2 = new Coordinate(5, 5);
    coor1 = coor2;
    coor1.moveNorthOneStep();
    coor1.moveEastOneStep();
    coor1.moveSouthOneStep();
    coor1.moveWestOneStep();
    coor1.moveWestOneStep();
    System.out.println(coor1.getCoordinateArrayFormat());
    System.out.println(coor1.getCoordinateStringFormat());
    System.out.println(coor1.toString());
  }
}
