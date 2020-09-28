public class Location {
   private int x;
   private int y;
   private boolean visited = false;
   Robot r;
   public Location(int x, int y) {
      this.x = x;
      this.y = y;
      visited = false;
   }
   public Location(int x, int y, Robot r) {
      this.x = x;
      this.y = y;
      visited = false;
   }
   public int getX() {
      return x;
   }
   public int getY() {
      return y;
   }
   public void setRobot(Robot r) {
      this.r = r;
   }
   // Returns the robot stored in this location
   public Robot getRobot() {
      return r;
   }
   // Marks visited as true
   public void markVisited() {
      visited = true;
   }
   public boolean isVisited() {
      return visited;
   }
}
