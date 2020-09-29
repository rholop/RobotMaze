/**
 * Assignment 1
 * 
 * @author melmccord
 * @author rowanholop
 * version 1.1 
 * 
 * This class is a concrete class for the Robot "Bob."
 * 
 */

public class Bob extends Robot
{
    private static Bob instance;
    int traversed;
    
    private Bob()
    {
        super("Bob", "Bob");
        traversed = 0;
    }

    public static Bob getBob() {
        if (instance == null)
        {
            instance = new Bob();
        }
        return instance;
    }
    
    @Override
    protected String speak() {
        return "Who are you?";
    }
   
    protected void move() {
        traversed++;
    }
    
    public String failed() {
        return ("I couldn't find Alice anywhere I looked. I traveled " + traversed + " steps.");
    }
    
    public String foundAlice() {
        return ("I found Alice! It only took me " + traversed + " steps!");
    }
}


