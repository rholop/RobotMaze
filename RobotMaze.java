import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Random;

/******************************************************************************
 *  Compilation:  javac Maze.java
 *  Execution:    java Maze.java n
 *  Dependencies: StdDraw.java // Library from Princeton
 *  
 *  @author: https://algs4.cs.princeton.edu/41graph/Maze.java.html
 *  @author: melmccord
 *  @author: rowanholop
 *
 *  This is a concrete class that creates our RobotMaze and places our Robots.
 *  
 *  Class based off of Princeton's Maze.java, keys for methods as follows:
 *  - Original methods (written by Melanie and Rowan) are marked original.
 *  - Modified methods (sourced from Princeton but modified by us) are marked modified.
 *  - Unmodified methods (sourced from Princeton and unchanged) are marked unmodified.
 *
 ******************************************************************************/

public class RobotMaze {
    private int n;                 // dimension of maze
    private boolean[][] north;     // is there a wall to north of cell i, j
    private boolean[][] east;
    private boolean[][] south;
    private boolean[][] west;
    private boolean[][] visited;
    private boolean[][] occupied;
    private Bob bob;  // **NEW CODE ADDITION**
    private Alice alice;  // **NEW CODE ADDITION**
    private Robot[][] robots;  // **NEW CODE ADDITION**
    private boolean done = false;
    Random generator;  // **NEW CODE ADDITION**
    MazeRobotFactory factory;  // **NEW CODE ADDITION**

    public RobotMaze(int n) {
        this.n = n;
        StdDraw.setXscale(0, n+2);
        StdDraw.setYscale(0, n+2);
        generator = new Random();  // **NEW CODE ADDITION**
        factory = new MazeRobotFactory();  // **NEW CODE ADDITION**
        init();
        generate();
    }

    /*
     * Original method
     */

    private void placeBots() {
        // place bob and alice
        bob = factory.deliverBob();
        occupied[1][1] = true;
        alice = factory.deliverAlice();
        robots[n][n] = alice;
        occupied[n][n] = true;

        // find a random number between 0 and .05 for how many bots will be generated
        double number = generator.nextDouble() * .05;

        // add some random robots
        for (int i = 0; i < n*n*number; i++) {
            int x = 2 + generator.nextInt(n-2);
            int y = 2 + generator.nextInt(n-2);
            // mark walls as existing so bob cannot pass
            east[x][y] = west[x][y] = true; 
            north[x][y] = south[x][y] = true;
            robots[x][y] = factory.deliverARobot();
            occupied[x][y] = true;
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.filledCircle(x + 0.5, y + 0.5, 0.375);
        }

    }

    /*
     * Original method
     */
    private void robotsInteract(int x, int y) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text((n+2)/2, .5, bob.speak());
        StdDraw.show();
        StdDraw.pause(2000);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle((n+2)/2, 0, (n+2)/2, .95);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text((n+2)/2, .5, robots[x][y].speak());
        StdDraw.show();
        StdDraw.pause(2000);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle((n+2)/2, 0, (n+2)/2, .95);
        if (robots[x][y].equals(alice)) {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text((n+2)/2, .5, bob.foundAlice());
            StdDraw.show();
            StdDraw.pause(2000);
        }
    }

    /*
     * Modified method
     */
    // generate the maze starting from lower left
    private void generate() {
        generate(1, 1);
        placeBots(); // **NEW CODE ADDITION**
    }

    /*
     * Modified method
     */
    private void init() {
        // initialize border cells as already visited
        visited = new boolean[n+2][n+2];
        for (int x = 0; x < n+2; x++) {
            visited[x][0] = true;
            visited[x][n+1] = true;
        }
        for (int y = 0; y < n+2; y++) {
            visited[0][y] = true;
            visited[n+1][y] = true;
        }

        // initialze all walls as present & all squares as unoccupied
        north = new boolean[n+2][n+2];
        east  = new boolean[n+2][n+2];
        south = new boolean[n+2][n+2];
        west  = new boolean[n+2][n+2];
        occupied = new boolean[n+2][n+2];  // **NEW CODE ADDITION**
        robots = new Robot[n+2][n+2];  // **NEW CODE ADDITION**
        for (int x = 0; x < n+2; x++) {
            for (int y = 0; y < n+2; y++) {
                north[x][y] = true;
                east[x][y]  = true;
                south[x][y] = true;
                west[x][y]  = true;
                occupied[x][y] = false;  // **NEW CODE ADDITION**
                robots[x][y] = null;  // **NEW CODE ADDITION**
            }
        }
    }    

    /*
     * Modified method
     */
    // solve the maze using depth-first search
    private void solve(int x, int y) {
        if (x == 0 || y == 0 || x == n+1 || y == n+1) return;
        if ((x == 1 && y == 1) && visited[x][y]) {
            StdDraw.setPenColor(StdDraw.BLACK);  // **NEW CODE ADDITION**
            StdDraw.text((n+2)/2, .5, bob.failed());  // **NEW CODE ADDITION**
        }
        bob.move();  // **NEW CODE ADDITION**

        if (done || visited[x][y]) return;
        visited[x][y] = true;

        if ((x!=1 && y!=1) && occupied[x][y]) {  // **NEW CODE ADDITION**
            robotsInteract(x, y);  // **NEW CODE ADDITION**
        }

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
        StdDraw.show();
        StdDraw.pause(30);

        // reached end
        if (x == n && y == n) {
            done = true;
        }

        if (!north[x][y]) solve(x, y + 1);
        if (!east[x][y])  solve(x + 1, y);
        if (!south[x][y]) solve(x, y - 1);
        if (!west[x][y])  solve(x - 1, y);

        if (done) return;

        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
        StdDraw.show();
        StdDraw.pause(30);
    }

    /*
     * Modified method
     */
    // draw the maze
    public void draw() {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(n + 0.5, n + 0.5, 0.375); // Dot for alice
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledCircle(1.5, 1.5, 0.375); // Dot for Bob

        StdDraw.setPenColor(StdDraw.BLACK);
        // Make sure our outer edges are filled even though they're occupied
        StdDraw.line(1, 1, 2, 1);   // **NEW CODE ADDITION**
        StdDraw.line(1, 1, 1, 2);  // **NEW CODE ADDITION**
        StdDraw.line(n, n+1, n+1, n+1);  // **NEW CODE ADDITION**
        StdDraw.line(n+1, n, n+1, n+1);  // **NEW CODE ADDITION**
        /*
         * For loop was slightly modified to make sure occupied squares are not drawn
         */
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (south[x][y] && !occupied[x][y]) StdDraw.line(x, y, x+1, y);
                if (north[x][y] && !occupied [x][y]) StdDraw.line(x, y+1, x+1, y+1);
                if (west[x][y] && !occupied[x][y])  StdDraw.line(x, y, x, y+1);
                if (east[x][y]  && !occupied [x][y])  StdDraw.line(x+1, y, x+1, y+1);
            }
        }

        StdDraw.show();
        StdDraw.pause(1000);
    }

    /*
     * Unmodified method
     */
    // solve the maze starting from the start state
    public void solve() {
        for (int x = 1; x <= n; x++)
            for (int y = 1; y <= n; y++)
                visited[x][y] = false;
        done = false;
        solve(1, 1);
    }

    /*
     * Unmodified method
     */
    // generate the maze
    private void generate(int x, int y) {
        visited[x][y] = true;

        // while there is an unvisited neighbor
        while (!visited[x][y+1] || !visited[x+1][y] || !visited[x][y-1] || !visited[x-1][y]) {

            // pick random neighbor (could use Knuth's trick instead)
            while (true) {
                int r = generator.nextInt(4);
                if (r == 0 && !visited[x][y+1]) {
                    north[x][y] = false;
                    south[x][y+1] = false;
                    generate(x, y + 1);
                    break;
                }
                else if (r == 1 && !visited[x+1][y]) {
                    east[x][y] = false;
                    west[x+1][y] = false;
                    generate(x+1, y);
                    break;
                }
                else if (r == 2 && !visited[x][y-1]) {
                    south[x][y] = false;
                    north[x][y-1] = false;
                    generate(x, y-1);
                    break;
                }
                else if (r == 3 && !visited[x-1][y]) {
                    west[x][y] = false;
                    east[x-1][y] = false;
                    generate(x-1, y);
                    break;
                }
            }
        }
    }
}
