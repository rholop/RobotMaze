
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

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
    
    protected String speak() {
        return "My name is " + name;
    }

}
