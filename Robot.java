import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Assignment 1
 * 
 * @author melmccord
 * @author rowanholop
 * version 1.1 
 * 
 * This class is an abstract class that allows for our creation of robots.
 * 
 */
public abstract class Robot {

    private String name;
    private String type;
    private int x;
    private int y;
    protected Robot(String name, String type) {
        this.name = name;
        this.type = type;
    }
    protected String speak() {
        return "My name is " + name;
    }
    protected boolean equals(Robot r) {
        if (r.name == this.name) {return true;}
        else {return false;}
    }
    
    public static void main(String[] args){
        
    }
}
