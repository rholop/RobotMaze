import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Write a description of class Client here.
 *
 * @melmccord
 * @rowanholop
 * @version 1.1
 * 
 * This is a facade class that allows our client to more easily run our program.
 * 
 */
public class Client
{
    private RobotMaze maze;

    /**
     * empty constructor
     */
    public Client(){}

    /**
     * Make the maze.
     */
    public void makeMaze(int n)
    {
        maze = new RobotMaze(n);
    }

    /**
     * Draw the maze.
     */
    public void drawMaze()
    {
        StdDraw.enableDoubleBuffering();
        maze.draw();
    }

    /**
     * Solve the maze.
     */
    public void solveMaze()
    {
        maze.solve();
    }

    /**
     * Method to read a file in on the client end and create the maze based on the first int in the file.
     */

    public static void main(String[] args) {
        try {
            Client client = new Client();
            Scanner sc = new Scanner(new File(args[0]));
            int n = sc.nextInt();
            client.makeMaze(n);
            client.drawMaze();
            client.solveMaze();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
