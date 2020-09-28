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
   public void setRobot(Robot r) {
      this.r = r;
   }
   // Returns the robot stored in this location
   public Robot getRobot() {
      if (r == null)
         return null;
      else
         return r;
   }
   // Marks visited as true
   public void placeBreadcrumb() {
      visited = true;
   }
   public boolean isVisited() {
      return visited;
   }
}
