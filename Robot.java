
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
    
    protected Robot(String name) {
        this.name = name;
    }
    protected String getName() {
        return this.name;
    }
    protected String speak() {
        return "My name is " + getName();
    }

}

abstract class ImmoveableRobot extends Robot
{
    // private static Location location;
    // private int traversed;
    
    protected ImmoveableRobot(String name) {
        super(name);
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
        super(name);
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
        super(name);
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
        super(name);
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
        super(name);
    }
    protected String showExpertise() {
        return " and I am a policeman robot";
    }
    @Override
    protected String speak() {
        return super.speak() + showExpertise();
    }
}

public class Alice extends ImmoveableRobot {
    private static Alice instance;
    
    private Alice(String name)
    {
        super(name);
    }

    public static Alice getAlice() {
        if (instance == null)
        {
            instance = new Alice("Alice");
        }
        return instance;
    }
}

abstract class MoveableRobot extends Robot
{
    // private Location location;
    // private int traversed;
    
    protected MoveableRobot(String name) {
        super(name);
    }
    /**
    public void setLocation(Location location) {
        this.location = location;
    }
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

public class Bob extends MoveableRobot{
    private static Bob instance;
    
    private Bob(String name)
    {
        super(name);
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
