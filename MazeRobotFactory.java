import java.util.Random;

/**
 * Assignment 1
 * 
 * @author melmccord
 * @author rowanholop
 * version 1.1 
 * 
 * This class is a concrete Factory class that creates Robots, so our RobotMaze class doesn't have to
 * worry about that.
 * 
 */

public class MazeRobotFactory{
    Bob bob = Bob.getBob();
    Alice alice = Alice.getAlice();
    Random generator = new Random();
    int bot;
    
    public Bob deliverBob() {
        return bob;
    }
    
    public Alice deliverAlice() {
        return alice;
    }
    
    public Robot deliverARobot() {
        bot = generator.nextInt(4);
        if (bot == 0) {
            return new ScientistRobot();
        }
        if (bot == 1) {
            return new DoctorRobot();
        }
        if (bot == 2) {
            return new StudentRobot();
        }
        else {
            return new PolicemanRobot();
        }
    }
    
}
