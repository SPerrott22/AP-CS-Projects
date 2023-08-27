// Name: Samuel Perrott
// Assignment: Inherits-A3: In class lab

import java.awt.Color;

public class InheritanceWS_1Perrott {
   public static void main(String[] args) {
      Shape s = new Shape(1,1,Color.YELLOW);
      System.out.println("This shape is at (" + s.getX() + ", " + s.getY() + ").");
      System.out.println("Its area is " + s.getArea());
      
      Shape c = new Circle(0,0,Color.BLUE,2);
      System.out.println("This circle is at (" + c.getX() + ", " + c.getY() + ").");
      System.out.println("Its area is " + c.getArea());
   }
}

class Shape {
    private int xLoc;
    private int yLoc;
    private Color color;

    public Shape( int xLocation, int yLocation ) {
    	xLoc = xLocation;
    	yLoc = yLocation;
    }
    public int getX() {return xLoc;}
    public int getY() {return yLoc;}
    /**
     2) Write an alternate constructor that takes the x, y location AND
     	a color object and initializes all instance variables.
    */
    public Shape (int xLocation, int yLocation, Color c) {
      xLoc = xLocation;
      yLoc = yLocation;
      color = c;
    }

    public double getArea( ) { return 0; }

} // end class Shape

/** 3) Write a class Circle that has an instance field for radius and
	   inherits the x,y and color from the Shape class. 
      (3b) Write a constructor for Circle that initializes all instance variables,
	   including location.
      (3c) Write a getArea method that returns the area of the circle

*/

class Circle extends Shape {
   private int radius;
   
   public Circle(int xLocation, int yLocation, Color c, int r) {
      super(xLocation, yLocation, c);
      radius = r;
   }
   
   @Override
   public double getArea() {
      return Math.PI * Math.pow(radius, 2);
   }

}




















/** 5) Create a public tester class: ShapeTester_Lastna
       Create a few objects, print out thier areas
*/
