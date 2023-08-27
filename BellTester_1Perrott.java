// Name: Samuel Perrott
// Assignment: AList-A3: ArrayList Bk Pgm

import java.util.ArrayList;

/**
   BellTester class tests out the Bell class
   by creating Bell objects and using methods
   of the Bell class in creating an ArrayList
   of 12 Bell objects and printing out:
      - every Bell at an even index
      - every Bell with an even id number
      - the first and last Bell objects
      
   These three modifications are done via the evenIndex,
   evenId, and terminalElements methods of the BellTester
   class, respectively. 
   
   @author Samuel Perrott
*/
public class BellTester_1Perrott {

   public static void main(String[] args) {
   
      ArrayList<Bell> bells = new ArrayList<>();
      
      bells.add(new Bell(223291));
      bells.add(new Bell(223292));
      bells.add(new Bell(223293));
      bells.add(new Bell(223294));
      bells.add(new Bell(223295));
      bells.add(new Bell(223296));
      bells.add(new Bell(223297));
      bells.add(new Bell(223298));
      bells.add(new Bell(223299));
      bells.add(new Bell(223300));
      bells.add(new Bell(223301));
      bells.add(new Bell(223302));
      
      System.out.println("Original Roster:");
      System.out.println("----------------");
      for (Bell student : bells) {
         System.out.println(student);
      }
      
      System.out.println("\nEven Indices:");
      System.out.println("----------------");
      for (Bell student : evenIndex(new ArrayList<>(bells))) {
      // a copy of bells is passed into evenIndex() rather than
      // bells itself so that the original ArrayList is not
      // mutated. Likewise for evenId() and terminalElements().
         System.out.println(student);
      } 
            
      System.out.println("\nEven Id's:");
      System.out.println("----------------");
      for (Bell student : evenId(new ArrayList<>(bells))) {
         System.out.println(student);
      }
      
      System.out.println("\nOnly First and Last:");
      System.out.println("----------------");
      ArrayList<Bell> firstLast = terminalElements(new ArrayList<>(bells));
      for (Bell student : firstLast) {
         System.out.println(student);
      }
      
      System.out.println("\nExtra:");
      System.out.println("----------------");
      System.out.println("The difference between the first and last"
                         + "\nstudents' id numbers is " +
                         firstLast.get(1).compareTo(firstLast.get(0)) + ".");
      
   }
   
   public static ArrayList<Bell> evenIndex(ArrayList<Bell> bells) {
      for (int i = 1; i < bells.size(); i++) {
      // i needs only be incremented by 1 since the removal of
      // the element at the original ArrayList's odd index
      // causes the elements that follow after to decrement
      // their indices each by 1, so that, relative the
      // original ArrayList's indices, the loop in effect net
      // increments i by 2.
         bells.remove(i);
      }
      return bells;
   }
   
   public static ArrayList<Bell> evenId(ArrayList<Bell> bells) {
   /*
      Could also use this simpler code, but it doesn't use
      an explicit for loop:
      
         bells.removeIf(student -> student.id() % 2 != 0);
         return bells;
         
      Alternatively, an iterator could be used with a for
      loop that would still circumvent the need to create
      a new ArrayList object; however, it would require
      importing the Iterator interface (such as by
      adding "import java.util.Iterator;" to the imports).

         Iterator<Bell> itr = bells.iterator();
         while (itr.hasNext()) {
            Bell student = itr.next();
            if (student.id() % 2 != 0) {
               itr.remove();
            }
         }
         return bells;
   */
      ArrayList<Bell> evenIdBells = new ArrayList<>();
      for (int i = 0; i < bells.size(); i++) {
         if (bells.get(i).id() % 2 == 0) {
            evenIdBells.add(bells.get(i));
         }
      }
      return evenIdBells;
   }
   
   public static ArrayList<Bell> terminalElements(ArrayList<Bell> bells) {
   /*
      Could also use this simpler code, but it doesn't use
      an explicit for loop:
         
         bells.set(1, bells.set(bells.size() - 1, bells.get(1)));
         bells.subList(2, bells.size()).clear();
         return bells;
   */
      ArrayList<Bell> alphaOmega = new ArrayList<>();
      for (int i = 0; i < bells.size(); i += bells.size() - 1) {
         alphaOmega.add(bells.get(i));
      }
      return alphaOmega;
   }
}

/**
   This class creates Bell objects that each
   represent a Bellarmine student with a
   student id number. The id method is an
   accessor method that returns the student's
   id number. The compareTo method returns
   the difference between a given student
   and another student's id numbers. The
   toString method returns the student's
   id number as a string.   
*/
class Bell {
  private int studentId;
  
  public Bell(int id) {
     studentId = id;
  }

  public int id() {
     return studentId;
  }

  public int compareTo(Bell otherBell) {
     return this.id() - otherBell.studentId;
  }
  
  public String toString() {
     return "" + studentId;
  }
} 