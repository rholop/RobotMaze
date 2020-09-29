/**
 * Assignment 1
 * 
 * @author melmccord
 * @author rowanholop
 * version 1.1 
 * 
 * This class is a concrete class for the Robot "Alice."
 * 
 */


public class Alice extends Robot
{
    private static Alice instance;
    
    private Alice()
    {
        super("Alice", "Alice");
    }

    public static Alice getAlice() {
        if (instance == null)
        {
            instance = new Alice();
        }
        return instance;
    }
}
