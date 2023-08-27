import acm.program.GraphicsProgram;
import acm.graphics.GTurtle;
import acm.graphics.GRect;
import acm.graphics.GLabel;
import acm.graphics.GLine;
/**
   A class that races three GTurtles against each other.
   The winning turtle performed a victory dance.
*/
public class TurtleRun_1PerrotS extends GraphicsProgram {
   /**
      A run class that adds GTurtles, GLines, a GLabel and GRect
      to the GUI and then moves them. The three turtles race
      in lanes delineated by the GLines and the finish line
      is a GRect labeled with a GLabel. The turtles move
      forward a number of steps within [10,50). The winner
      (determined by whose head first crosses the front of
      the finish line) performs a victory dance at the end.
   */
   public void run() {
      GTurtle winner = null;
      boolean achieved = false;
      
      GLine divider1 = new GLine(0, 26, 650, 26);
      add(divider1);
      
      GTurtle billy = new GTurtle(100, 100);
      add(billy);
      
      GLine divider2 = new GLine(0, 160, 650, 160);
      add(divider2);
      
      GTurtle bob = new GTurtle(100, 225);
      add(bob); 
      
      GLine divider3 = new GLine(0, 290, 650, 290);
      add(divider3);
      
      GTurtle joe = new GTurtle(100, 350);
      add(joe);
      
      GLine divider4 = new GLine(0, 400, 650, 400);
      add(divider4);
            
      GRect rect = new GRect(650, 0, 10, 450);
      add(rect);
      
      GLabel label = new GLabel("Finish", 650, 465);
      add(label);
      
      /*
         This loop moves each turtle forward sequentially
         a random distance with a magnitude that lies within
         [10,50). The loop identifies that the race has been
         won using the achieved boolean and marks the winning
         turtle with the alias winner. The loop ensures
         the turtles move past the finish line after touching
         it and finish the race even if they did not win.
      */
      while (billy.getX() < 690 || bob.getX() < 690 || joe.getX() < 690) {
         if (billy.getX() < 690) {
            billy.forward(Math.random() * 40 + 10);
            pause(10);
         }
         if (billy.getX() >= 623 && !achieved) {
            winner = billy;
            achieved = true;
         }
         if (bob.getX() < 690) {
            bob.forward(Math.random() * 40 + 10);
            pause(10);
         }
         if (bob.getX() >= 623 && !achieved) {
            winner = bob;
            achieved = true;
         }
         if (joe.getX() < 690) {
            joe.forward(Math.random() * 40 + 10);
            pause(10);
         }
         if (joe.getX() >= 623 && !achieved) {
            winner = joe;
            achieved = true;
         }
      }
      pause(500);
      // Moving winning turtle to dance position.
      for (int i = 0; i < 50; i++) {
         winner.move(-7, (250-winner.getY())/4);
         pause(1);
      }
      winner.setDirection(90);
      winner.sendToFront();
      // Dance:
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 8; j++) {
            winner.left(45);
            winner.forward(50);
            pause(5);
         }
         pause(10);
         if (i/2*2 != i) {
            for (int k = 0; k < 360; k++) {
               winner.right(1);
               pause(1);
            }
         }
         if (i/2*2 == i) {
            for (int k = 0; k < 360; k++) {
               winner.left(1);
               pause(1);
            }
         }
         pause(10);
         for (int j = 0; j < 8; j++) {
            winner.right(45);
            winner.forward(50);
            pause(5);
         }
         winner.right(90);
      }
      winner.right(90);
      for (int k = 0; k < 4; k++) {
         winner.move(15,0);
         winner.move(-15,0);
         winner.move(0,15);
         winner.move(0,-15);
         winner.move(-15,0);
         winner.move(15,0);
         winner.move(0,-15);
         winner.move(0,15);
      }
      for (int k = 0; k < 720; k++) {
         winner.setSize(winner.getTurtleSize() + k/10);
         winner.left(1);
         pause(0.5);
      }
      for (int k = 0; k < 720; k++) {
         winner.setSize(winner.getTurtleSize() - k/10);
         winner.right(1);
         pause(0.5);
      }      
   }
   /**
      Main method that starts the ACM window.
   */   
   public static void main(String[] args) {
      new TurtleRun_1PerrotS().start(args);
   }
}