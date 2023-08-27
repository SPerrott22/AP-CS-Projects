// Name: Samuel Perrott
// Assignment: AList-A8: Methods w/ArrayList 

import java.util.ArrayList;

public class ArrayListMethodsTester_1Perrott {

  public static void main(String[] args) {
    int[] testData = {3, 6, 9, 2, 1, 9, 4, 7, 5};
    ArrayListMethods methods = new ArrayListMethods(testData);
    
    System.out.println("Swapping first and last elements:");
    methods.swapFirstAndLast(); // E7.11a
    methods.display();
    methods.reset();
    
    System.out.println("Right shifting all elements:");
    methods.rightShift(); // E7.11b
    methods.display();
    methods.reset();
    
    System.out.println("Replace all even elements with 0:");
    methods.zeroTheEvens(); // E7.11c
    methods.display();
    methods.reset();
    
    System.out.println("Replace each element except the first"
                       + "\nand last by the larger of its two neighbors:");
    methods.becomeLargerNeighbor(); // E7.11d
    methods.display();
    methods.reset();
    
    System.out.println("Removing the middle element(s):");
    methods.removeMiddle(); // E7.11e
    methods.display();
    methods.reset();
    
    System.out.println("Move even values to front, otherwise preserving the ordering:");
    methods.moveEvens();  // E7.11f
    methods.display();
    methods.reset();
    
    // This one is a challenge:
    System.out.println("2nd largest element: "
                       + methods.find2ndLargest()); // E7.11g
    methods.reset();
    
    // These methods will return boolean (true or false)
    System.out.println("List is sorted in increasing order: "
                       + methods.isIncreasing()); // E7.11h
    methods.reset();
    
    System.out.println("List has 2 adjacent duplicate elements: "
                       + methods.hasAdjacentDuplicates()); // E7.11i
    methods.reset();
    
    System.out.println("List has 2 duplicate elements: "
                       + methods.hasDuplicates()); // E7.11j
    methods.reset();    
  }
  
 } // End class ArrayListMethodsTester
 
 class ArrayListMethods {
 
   private ArrayList<Integer> values;
   private int[] data;
   
   /**
      Initializes the values list
      
      @param data the integer array used
      to initialize the values list
   */
   public ArrayListMethods(int[] data) {
     this.data = data; // copies data so values can be reset
     values = new ArrayList<Integer>();
     for(int i : data) values.add(i);
   }
   
   public void display() { 
     System.out.println(values + "\n");
   }
   
   public void swapFirstAndLast() {
      values.set(0, values.set(values.size() - 1, values.get(0)));
   }
   
   public void rightShift() {
      values.add(0, values.remove(values.size() - 1));
   }
   
   public void zeroTheEvens() {
      for (int i = 0; i < values.size(); i++) {
         if (values.get(i) % 2 == 0) values.set(i, 0);
      }
   }
   
   public void becomeLargerNeighbor() {
      ArrayList<Integer> duplicate = new ArrayList<>(values);
      for (int i = 1; i < values.size() - 1; i++) {
         duplicate.set(i, Math.max(values.get(i-1), values.get(i+1)));
      }
      values = duplicate;
      // Note: the ArrayList object duplicate refers to is not destroyed
      // by the garbage collector on the termination of the method since
      // a valid reference to this object (that is, values) continues
      // to exist even after the termination of this method. Thus,
      // values does not refer to a null object even after the
      // termination of this method. This is because local
      // variables in a method are deleted when they go out of
      // scope if they are primitives, and references to objects
      // are also deleted, but the objects themselves remain
      // if a valid reference still exists.
   }
   
   public void removeMiddle() {
      if (values.size() % 2 == 0) {
         values.remove(values.size()/2 - 1);
         values.remove(values.size()/2);
      } else {
         values.remove(values.size()/2);
      }
   }
   
   public void moveEvens() {
      int j = 0;
      for (int i = values.size() - 1; i >= j; i--) {
         if (values.get(i) % 2 == 0) {
            values.add(0, values.remove(i));
            j++;
         }
      }
   }
   
   /**
      Gets the second largest integer in the
      ArrayList (or the largest if the max value
      occurs more than once).
      
      @return the second largest value
   */
   public int find2ndLargest() {
      int max1 = values.get(0), max2 = values.get(1);
      for (int i = 2; i < values.size(); i++)
         if (values.get(i) > max1 || values.get(i) > max2)
            if (max1 < max2) max1 = values.get(i);
            else max2 = values.get(i);
      return Math.min(max1, max2);
   }
   
   /**
      Returns true if the ArrayList is in increasing order,
      otherwise returns false.
      
      @return whether the ArrayList is increasing
   */
   public boolean isIncreasing() {
      for (int i = 1; i < values.size(); i++) {
         if (values.get(i - 1) > values.get(i)) return false;
      }
      return true;
   }
   
   /**
      Returns true if the ArrayList contains adjacent
      duplicate integers, otherwise returns false.
      
      @return whether the ArrayList has adjacent duplicates
   */
   public boolean hasAdjacentDuplicates() {
      for (int i = 0; i < values.size() - 1; i++) {
         if (values.get(i + 1) == values.get(i)) return true;
      }
      return false;
   }
   
   /**
      Returns true if the ArrayList contains duplicate
      integers, otherwise returns false.
      
      @return whether the ArrayList has duplicates
   */   
   public boolean hasDuplicates() {
      ArrayList<Integer> temp = new ArrayList<>(values);
      while (temp.size() > 0) {
         if (temp.contains(temp.remove(0))) return true;
      } 
      return false;
   }
   
   public void reset() {
      values.clear();
      for(int i : data) values.add(i);
   }
}
