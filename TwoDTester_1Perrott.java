// Name: Samuel Perrott
// Assignment: Pics-A4: 2D Array lab

public class TwoDTester_1Perrott {
   public static void main(String[] args) {
      TwoDTable t1 = new MultiplicationTable(7,6);      
      TwoDTable t2 = new Checkerboard(6,5);
      TwoDTable t3 = new RandomTable(4,4,9);
      TwoDTable t4 = new TwoDTable(5,5);
      
      t1.print();
      System.out.println();

      System.out.println("Sum of multiplication table is " + sum(t1.getRawData()) + ".\n");
      System.out.println("Max of multiplication table is " + max(t1.getRawData()) + ".\n");      
      
      t2.print();
      System.out.println();
      
      t3.print();
      System.out.println();
      
      setAll(t4.getRawData(), 5);
      System.out.println("A table of all fives:");
      t4.print();
      
   }
   
   public static int sum(int[][] arr) {
      int total = 0;
      for (int[] row : arr) {
         for (int i : row) {
            total += i;
         }
      }
      return total;
      // iterate through whole arr and calc sum
   }
   
   public static void setAll(int[][] arr, int val) {
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[i].length; j++) {
            arr[i][j] = val;
         }
      }
      // sets all arr vals to val
   }
   
   public static int max(int[][] arr) {
      int largest = arr[0][0];
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[i].length; j++) {
            if (arr[i][j] > largest) largest = arr[i][j];
         }
      }
      return largest;
      //return largets val in arr
   }
}

class TwoDTable {
   final int ROWS;
   final int COLS;
   private int[][] array;
   
   public TwoDTable(int rows, int cols) {
      ROWS = rows;
      COLS = cols;
      array = new int[ROWS][COLS];
   }

   public void print() {
      for (int i = 0; i < ROWS; i++) {
         for (int j = 0; j < COLS; j++) {
            System.out.printf("%4d", array[i][j]);
         }
         System.out.println();
      }
   }
   
   public int[][] getRawData() {
      return array;
   }
   
}

class MultiplicationTable extends TwoDTable {
   public MultiplicationTable(int x, int y) {
      super(x,y);
      int[][] array = getRawData();
      for (int i = 0; i < array.length; i++) {
         for (int j = 0; j < array[i].length; j++) {
            array[i][j] = i * j;
         }
      }  
   }
   
   @Override
   public void print() {
      System.out.println("MULTIPLICATION TABLE");
      System.out.printf("%4s", " ");
      for (int i = 0; i < COLS; i++) {
         System.out.printf("%4d", i);
      }
      System.out.println();
      for (int i = 0; i < ROWS; i++) {
         System.out.printf("%4d", i);
         for (int j = 0; j < COLS; j++) {
            System.out.printf("%4d", getRawData()[i][j]);
         }
         System.out.println();
      }
   }
   
}

class Checkerboard extends TwoDTable {
   public Checkerboard(int x, int y) {
      super(x, y);
   }
   
   @Override
   public void print() {
      System.out.println("CHECKERBOARD");
      boolean zero = true;
      for (int i = 0; i < ROWS; i++) {
         for (int j = 0; j < COLS; j++) {
            if (zero) System.out.printf("%4d", 0);
            else System.out.printf("%4d", 1);
            zero = !zero;
         }
         if (COLS%2 == 0) zero = !zero;
         System.out.println();
      }
   }
}

class RandomTable extends TwoDTable {
   public RandomTable(int rows, int cols, int max) {
      super(rows, cols);
      int[][] arr = getRawData();
      for (int i = 0; i < arr.length; i++)
         for (int j = 0; j < arr[i].length; j++) {
            arr[i][j] = (int)(Math.random()*(max + 1));
         }
   }
   
   @Override
   public void print() {
      System.out.println("RANDOM TABLE");
      System.out.printf("%4s", " ");
      for (int i = 0; i < COLS; i++) {
         System.out.printf("%4d", i);
      }
      System.out.println();
      for (int i = 0; i < ROWS; i++) {
         System.out.printf("%4d", i);
         for (int j = 0; j < COLS; j++) {
            System.out.printf("%4d", getRawData()[i][j]);
         }
         System.out.println();
      }
   }
}