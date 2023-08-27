// Samuel Perrott       Array-A1: Basic Array Exercises
public class ArrayTester_1Perrott {
   /**
      Main method that calls testNums and testStrings to
      experiment with arrays.
      @param args -- standard String[] object
   */
   public static void main(String[] args) {
      int[] nums = {1,5,22,15,0,9};
      String[] words = {"to", "be", "not", "aardvark", "scintillating"};
      testNums(nums);
      testStrings(words);
   }
   /**
      Static method that will:
      Print out the 2nd element in nums
      Print out the last element in nums
      Print out the largest number in nums
      @param nums -- array of int
   */
   private static void testNums(int[] nums) {
      int max = nums[0];
      for(int i = 1; i < nums.length; i++) {
         if (nums[i] > max) max = nums[i];
      }
      System.out.println("2nd element: " + nums[1]);
      System.out.println("last element: " + nums[nums.length-1]);
      System.out.println("largest element: " + max);
   }
   /**
      Static method that will:
      Print out the last element in words
      Print out each word, on the same line
      Print out the lengths of each word in words
      @param words -- array of strings
   */
   private static void testStrings(String[] words) {
      System.out.println("\nlast element: " + words[words.length-1]);
      System.out.println("\nContents of array:");
      for (String word : words) {
         if (word.equals(words[words.length - 1])) System.out.print(word + "\n");
         else System.out.print(word + ", ");
      }
      System.out.println("\nLengths of each word:");
      for (String word : words) {
         System.out.println(word.length());
      }
   } 

}