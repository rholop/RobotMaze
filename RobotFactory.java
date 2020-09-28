import java.util.Random;

abstract class RobotFactory{

    public abstract Robot deliverARobot();

}

public class MazeRobotFactory{
    Bob bob = Bob.getBob();
    Alice alice = Alice.getAlice();
    Random generator = new Random();
    int bot;
    
    public Robot deliverBob() {
        return bob;
    }
    
    public Robot deliverAlice() {
        return alice;
    }
    
    public Robot deliverARobot() {
        bot = generator.nextInt(4);
        if (bot == 0) {
            return new ScientistRobot("science");
        }
        if (bot == 1) {
            return new DoctorRobot("doc");
        }
        if (bot == 2) {
            return new StudentRobot("stud");
        }
        else {
            return new PolicemanRobot("police");
        }
    }
    
}
