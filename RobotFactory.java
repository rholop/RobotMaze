enum TypesofRobot {
    Scientist,
    Doctor,
    Student,
    Policeman
}
class RobotFactory{
	
	public Robot deliverARobot(String name, TypesofRobot typeClue) {
        switch(typeClue) {
            case Scientist:
                return new ScientistRobot(name);
            case Doctor:
                return new DoctorRobot(name);
            case Student:
                return new StudentRobot(name);
            default:
                return new PolicemanRobot(name);
        }
    }