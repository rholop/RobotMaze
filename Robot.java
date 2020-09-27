
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

class ScientistRobot extends Robot {
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
class DoctorRobot extends Robot {
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
class StudentRobot extends Robot {
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
class PolicemanRobot extends Robot {
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