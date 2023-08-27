public class CounterTester_1Perrott {
   public static void main(String[] args) {
      Counter costcoCounter = new Counter();
      costcoCounter.initialize("Costco Counter");
      costcoCounter.click();
      costcoCounter.print();
      
      Counter hdCounter = new Counter();
      hdCounter.initialize("Home Depot Counter");
      hdCounter.click();
      hdCounter.print();
      
      // can't do System.out.println(costcoCounter.count); since count is private
   }
}

// Define a class representing a clicker:
class Counter {
   // Instance variables required to be private by College Board
   private int count;
   private String name;
   
   /*
      initializes the instance variables
   */
   public void initialize(String nameOfClicker) { //nameOfClicker is parameter var
      System.out.println("Initializing: " + nameOfClicker); // method
      name = nameOfClicker;
      count = 0;
   }
   
   public void click() {
      // add 1 to count...
      count = count + 1; // can also do count +=1, count++ 
      System.out.println("click");
   }
   
   public void print() {
      System.out.println(name + ": " + count);
   }

}