// Name: Samuel Perrott
// Assignment: AList-A14: SelSort 2

public class NameSortTester_1Perrott{
   /**
      Main method that tests the selectionSort.
      
      @param args the standard input
   */
   public static void main(String[] args) {
      String[] students = {"Maria", "Sophia", "Serena", "Melinda", "Bobby", "Ryan", "Ethan", "Ysidro"};
      print(selectionSort(students));
   }
   
   /**
      Sorts the array of Strings passed in from smallest to smallest.
      
      @return the sorted array
   */   
   public static String[] selectionSort(String[] arr) {
      for (int i = 0; i < arr.length - 1; i++)
         swap(arr, i, findMindex(arr, i));
      return arr;
   }
   
   /**
      Finds the index of the minimum value (as determined lexicographically)
      in an array of Strings from the given index to the end of the array.
      
      @param arr array of elements to be sorted
      @param from starting location in the array to begin search for
      minimum element
      @return the index of the smallest element in the portion of
      array arr starting at index start and going up through
      length - 1
   */
   public static int findMindex(String[] arr, int from) {
      int mindex = from;
      for (int i = from + 1; i < arr.length; i++) {
         if (arr[mindex].compareTo(arr[i]) > 0) mindex = i;
      }
      return mindex;
   }
   
   /**
      Swaps two elements in an array of Strings.
      
      @param arr array of elements with elements to swap
      @param index1 index of first element to swap
      @param index2 index of 2nd element to swap
      Postcondition: Array arr is updated the elements at index1
      and index2 swapped
   */
   public static void swap(String[] arr, int index1, int index2) {
      String temp = arr[index1];
      arr[index1] = arr[index2];
      arr[index2] = temp;
   }
   
   /**
      Prints out the given array of Strings in a list.
      
      @param arr the array to be printed.
   */
   public static void print(String[] arr) {
      System.out.print("[");
      for(int i = 0; i < arr.length - 1; i++)
         System.out.print(arr[i] + ", ");
      System.out.print(arr[arr.length - 1]);
      System.out.println("]");
   }
   
}