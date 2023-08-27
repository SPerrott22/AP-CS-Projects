// Name: Samuel Perrott
// Assignment: AList-A4: In class Lab

import java.util.ArrayList;

/**
   This ArrayListCompareDemo creates an ArrayList
   of String and calls various methods on it
   before testing out the compareTo method
   to find the String in the ArrayList that
   comes last in the lexicographic ordering.
   
   @author Samuel Perrott
*/
public class ArrayListCompareDemo_1Perrott {

   public static void main(String[] args) {
   
      ArrayList<String> aList = new ArrayList<>();
      
      aList.add("Hello");
      aList.add("Jello");
      aList.add("Elmo");
      aList.add("World");
      aList.add("Velcro");
      
      System.out.println("Original Word List:");
      System.out.println("-------------------");
      for (int i = 0; i < aList.size(); i++) {
         System.out.println(aList.get(i));
      }
      
      aList.remove(1); // removing the second element
      
      aList.set(3, "Trello"); // setting fourth element to new value
      
      aList.add(1, "Goofball"); // adding element at index 1
      
      System.out.println("\nModified Word List:");
      System.out.println("-------------------");
      for (String s : aList) {
         System.out.println(s);
      }
      
      System.out.print("\nThe \"largest\" name as per the "
                       + "lexicographic ordering is: " +
                       findMax(aList));

   }
   
   // This method compares String elements of an array
   // to find the one that comes last in the
   // lexicographic ordering.
   public static String findMax(ArrayList<String> names) {
      String max = names.get(0);
      for (int i = 1; i < names.size(); i++) {
         if (names.get(i).compareTo(max) > 0) max = names.get(i);
      }
      return max;
   }
   
}