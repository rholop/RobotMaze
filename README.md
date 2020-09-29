# RobotMaze
Authors: Mel McCord, Rowan Holop
Files:
    Robot.java: the Abstract Robot Class, defines the methods other Robots inherit
    Bob.java: the Bob robot that searches for Alice
    Alice.java: the robot at the end
    ScientistRobot.java: scientist robot
    DoctorRobot.java: doctor robot
    PolicemanRobot.java: policeman robot
    StudentRobot.java: student robot
    MazeRobotFactory.java: Factory class that supplies robots to RobotMaze.java
    Client.java: Facade class for simple usability
    RobotMaze.java: Maze generator and solver - code for maze generation and solving based on:
        https://algs4.cs.princeton.edu/41graph/Maze.java.html
    StdDraw.java: also draws the maze (see above for citation)
        https://introcs.cs.princeton.edu/java/stdlib/StdDraw.java.html

    Instructions:
        Run Client.java with a filename in the commandline.
        Example: java MyProgram myfile.type
        Program will read the first int of the file and create a maze size (first int * first int).
