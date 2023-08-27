// Names: Thomas Walker & Samuel Perrott
// Assignment: LoopsA4 ASCII Chart (PP)

/**
   This class contais the main method which calls the printChart method inside to printout part of the ASCII chart.
*/
public class ASCII_1WalkerPerrott {
   public static void main(String[] args) {
      printChart();
   }
   
   /**
      The printChart method prints out the ASCII characters and their
      decimal codes from number 32 to 127 in four columns read vertically and to the right.
   */   
   public static void printChart() {
      char hline = (char)196;
      char vline = (char)179;
      for (int i = 0; i < 40; i++) {
         System.out.print(hline);
      }
      for (int i = 32; i < 51; i++) {
         System.out.printf("\n%c %2d %c %c%4d %c %c%4d %c %c%4d %c %c%4d %c %c", vline, i, (char)i, vline, i + 19, (char)(i + 19), vline, i + 38, (char)(i + 38), vline, i + 57, (char)(i + 57), vline, i + 76, (char)(i + 76), vline);
      }
      System.out.print("\n");
      for (int i = 0; i < 40; i++) {
         System.out.print(hline);
      }
   }
}