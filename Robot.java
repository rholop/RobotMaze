
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
interface CitizenRobot {
    public String showExpertise();
}
class ScientistRobot extends Robot implements CitizenRobot {
    protected ScientistRobot(String name) {
        super(name);
    }
    public String showExpertise() {
        String temp = "";
        temp += " and I am a scientist robot";
        return temp;
    }
        @Override
        protected String speak() {
            return super.speak() + showExpertise();
        }
}