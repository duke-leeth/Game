import java.io.*;
import java.util.*;
import java.lang.*;

public class AgentTester {
  public static void main(String[] args) throws Exception {
    Agent agent = new Agent();

    try {
      agent.setBoundry(8);
      agent.setLocation(9, 1);
      agent.setDirection("E");

      agent.moveOneStep();
      agent.moveOneStep();
      agent.setDirection("N");
      agent.moveOneStep();


      System.out.println(agent.getLocation());
      System.out.println(agent.getDirection());
    } catch(Exception ex) {
      System.out.println(ex);
    }

  }
}
