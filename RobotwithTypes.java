
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Robot Factory: Assignment 1
 * 
 * @author melmccord
 * @author rowanholop
 * version 1.1 
 */
public abstract class Robot {

    private String name;
    private String type;

    protected Robot(String name, String type) {
        this.name = name;
        this.type = type;
    }
    
    protected String getName() {
        return this.name;
    }
    
    protected String speak() {
        return "My name is " + name;
    }

}

abstract class ImmoveableRobot extends Robot
{
    // private static Location location;
    // private int traversed;
    
    protected ImmoveableRobot(String name, String type) {
        super(name, type);
    }
    /**
    private void setLocation(Location location) {
        this.location = location;
    }
    public Location getLocation() {
        return this.location;
    }*/
}


class ScientistRobot extends ImmoveableRobot {
    protected ScientistRobot(String name) {
        super(name, "Scientist");
    }
    protected String showExpertise() {
        String temp = "";
        temp += " and I am a scientist robot";
        return temp;
    }
        @Override
        protected String speak() {
            return super.speak() + showExpertise();
        }
}
class DoctorRobot extends ImmoveableRobot {
    protected DoctorRobot(String name) {
        super(name, "Docotor");
    }
    protected String showExpertise() {
        return " and I am a doctor robot";
    }
    @Override
    protected String speak() {
        return super.speak() + showExpertise();
    }
}
class StudentRobot extends ImmoveableRobot {
    protected StudentRobot(String name) {
        super(name, "Student");
    }
    protected String showExpertise() {
        return " and I am a student robot";
    }
    @Override
    protected String speak() {
        return super.speak() + showExpertise();
    }
}
class PolicemanRobot extends ImmoveableRobot {
    public PolicemanRobot(String name) {
        super(name, "Policeman");
    }
    protected String showExpertise() {
        return " and I am a policeman robot";
    }
    @Override
    protected String speak() {
        return super.speak() + showExpertise();
    }
}

public class Alice extends ImmoveableRobot
{
    private static Alice instance;
    
    private Alice(String name)
    {
        super(name, "Alice");
    }

    public static Alice getAlice() {
        if (instance == null)
        {
            instance = new Alice("Alice");
        }
        return instance;
    }
}



/**
 * Abstract class MoveableRobot - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class MoveableRobot extends Robot
{
    // private Location location;
    // private int traversed;
    
    protected MoveableRobot(String name, String type) {
        super(name, type);
    }
    
    /**
    public Location getLocation() {
        return this.location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    
    
    protected void move(Location current, Location next) {
        assert(this == Location.getRobot());
        if (!current.equals(next)) {
            assert(next.getRobot() == null);
            next.setRobot(this);
            current.setRobot(null);
            traversed++;
        }
        // do some moving stuff
    }
    */
}


public class Bob extends MoveableRobot
{
    private static Bob instance;
    
    private Bob(String name)
    {
        super(name, "Bob");
    }

    public static Bob getBob() {
        if (instance == null)
        {
            instance = new Bob("Bob");
        }
        return instance;
    }
    
    @Override
    protected String speak() {
        return "Who are you?";
    }
    
    public void checkRobot(Robot r){
        if (r.getName() == "Alice") {
            finishMoving();
        }
    }
    
    private void finishMoving() {
        System.out.println("I found Alice!");
        // Something to finish the puzzle
    }
}
