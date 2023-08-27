// Name: Samuel Perrott
// Assignment: Array-A4: Movie Class

import java.util.Scanner;

/**
   MovieTester class that tests the movie class by creating
   three Movie objects, calling the rate method, and 
   calling the toString method.
   
   @author Samuel Perrott
*/
public class MovieTester_1Perrott {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      System.out.println("\n-----------------------------------------------------");

      Movie m1 = new Movie("Finding Nemo", "adventure", "G", 100.0);
      System.out.println(m1);
      
      System.out.println("\nPlease input each rating out of ten as an integer");
      System.out.println("all on one line with a space between each integer below:");
      String[] nums1 = input.nextLine().split(" ");
      for (String num : nums1) {
         m1.rate(Integer.parseInt(num));
      }

      System.out.println(m1);

      System.out.println("\n-----------------------------------------------------");
      
      Movie m2 = new Movie("Avengers: End Game", "superhero", "PG-13", 151.0);
      System.out.println(m2);
      System.out.println("\nPlease input each rating out of ten as an integer");
      System.out.println("all on one line with a space between each integer below:");      
      String[] nums2 = input.nextLine().split(" ");
      for (String num : nums2) {
         m2.rate(Integer.parseInt(num));
      }

      System.out.println(m2);
  
      System.out.println("\n-----------------------------------------------------");
      
      Movie m3 = new Movie("Dune", "sci-fi", "PG-13", 135.0);
      System.out.println(m3);
      System.out.println("\nPlease input each rating out of ten as an integer");
      System.out.println("all on one line with a space between each integer below:");      
      String[] nums3 = input.nextLine().split(" ");
      for (String num : nums3) {
         m3.rate(Integer.parseInt(num));
      }
      
      System.out.println(m3);

   }
}

/**
   Movie class used to create Movie objects that each
   represent a specific movie with a title, genre,
   length in minutes, MPAA rating, and average
   rating out of ten.
*/
class Movie {
   private String title;
   private String genre;
   private double length;
   private String mpaa;
   private double pointsSum; 
   private int ratingsCount;
   
   public Movie(String theTitle, String theGenre, String theMPAARating, double theLength) {
      title = theTitle;
      genre = theGenre;
      mpaa = theMPAARating;
      length = theLength;
      ratingsCount = 0;
      pointsSum = 0;
   }
   
   public void rate(int newRating) {
      pointsSum += newRating;
      ratingsCount++;
   }
   
   public String toString() {
      return "\nTitle: \t\t\t\t" + title +
      "\nGenre: \t\t\t\t" + genre +
      "\nMPAA Rating: \t\t" + mpaa +
      "\nLength: \t\t\t\t" + length + " min." +
      "\nAverage Rating: \t" +
      Math.round((double)pointsSum/ratingsCount*100)/100.0 +
      " out of 10";
   }
}