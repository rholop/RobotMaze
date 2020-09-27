enum TypesofRobot {
    ScientistRobot,
    DoctorRobot,
    StudentRobot,
    PolicemanRobot
}
class RobotFactory{
	
	public Robot deliverARobot(String name, TypesofRobot typeClue) {
        switch(typeClue) {
            case ScientistRobot:
                return new ScientistRobot(name);
            case DoctorRobot:
                return new DoctorRobot(name);
            case StudentRobot:
                return new StudentRobot(name);
            default:
                return new PolicemanRobot(name);
        }
    }