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