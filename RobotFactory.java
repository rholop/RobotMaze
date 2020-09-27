enum TypesofRobot {
    ScientistRobot,
    DoctorRobot,
    StudentRobot,
    PolicemanRobot
}
class RobotFactory{
	
	public Robot deliverARobot(String name, TypesofRobot typeClue) {
        switch(typeClue) {
            case typeClue.ScientistRobot:
                return new ScientistRobot(name);
            case typeClue.DoctorRobot:
                return new DoctorRobot(name);
            case typeClue.StudentRobot:
                return new StudentRobot(name);
            default:
                return new PolicemanRobot(name);
        }
    }