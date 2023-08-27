// Name: Nikhil Reddy and Samuel Perrott
// Assignment: AList-A6: Find2ndMin-PP Copy

import java.util.ArrayList;
import java.util.List;

public class MinTester_1ReddyPerrott {
   public static void main( String[] args) {
      List<Integer> stuff = new ArrayList<Integer>();
      stuff.add(2);
      stuff.add(12);
      stuff.add(22);
      stuff.add(17);
      stuff.add(19);
      stuff.add(-10);
      stuff.add(-2);
      System.out.println("Test 1: 2nd smallest is: " + find2ndMin(stuff));
       
      stuff = new ArrayList<Integer>();
      stuff.add(-2);
      stuff.add(12);
      stuff.add(22);
      stuff.add(17);
      stuff.add(19);
      stuff.add(-1);
      stuff.add(-2);
      System.out.println("Test 2: 2nd smallest is: " + find2ndMin(stuff));
      
      stuff = new ArrayList<Integer>();
      stuff.add(-1);
      stuff.add(-2);
      stuff.add(22);
      stuff.add(17);
      stuff.add(19);
      stuff.add(-1);
      stuff.add(999999);
      System.out.println("Test 3: 2nd smallest is: " + find2ndMin(stuff));
   }
/**
 @param ints An arrayList with at least 2 elements (precondition). 
 Postcondition: The arrayList ints is not mutilated or disturbed in any way.
 @return the 2nd smallest value in the array (or the smallest if the min value occurs more than once)
*/
   public static int find2ndMin(List<Integer> ints) {
      int min = ints.get(0), secondMin = ints.get(1);
      for (int i = 1; i < ints.size(); i++) {
         if (ints.get(i) < min) {
            secondMin = min;
            min = ints.get(i);
         } else if (ints.get(i) < secondMin) {
            secondMin = ints.get(i);
         }
      }
      return secondMin;
   }
  
}