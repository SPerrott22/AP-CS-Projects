// Name: Samuel Perrott
// Assignment: Array-A6: Movie Database

import java.util.Scanner;

/**
   MovieDatabaseTester class that tests the MovieDatabase class by creating
   creating a MovieDatabase object and calling its methods and methods on
   its movies. 
   
   @author Samuel Perrott
*/
public class MovieDatabaseTester_1Perro {

   public static void main(String[] args) {
      MovieDatabase playlist = new MovieDatabase();
      Scanner input = new Scanner(System.in);
      boolean error = false;
      int action = 0;
      String answer = "";
      System.out.println("-----------------------------------------------------" +
      "\n\t\t\t\tWelcome to the Movie Database\n" +
      "-----------------------------------------------------" +
      "\n12 amazing movies are already loaded into this list.\nNote: they are" +
      " indexed starting from 0.\nThey are:\n\n" + playlist + "\nThey include" +
      " the following genres:\nadventure\ncomedy\n\nAnd the following MPAA" +
      " ratings:\nG\nPG\nPG-13\n\nThere is space for three more movies..." +
      "\nI'm looking at you.\n\nToday, you have a" + " fantastic menu of options.");
      do {
         System.out.println("\n\t\t\t\t\t\tMENU\n\nEnter 1 to retrieve a random movie" +
         " from the list.\nEnter 2 to retrieve the best movie for a date." + "\nEnter" + 
         " 3 to retrieve the highest-rated movie." + "\nEnter 4 to add a movie to" + 
         " the list." + "\nEnter 5 to rate a movie." + "\nEnter 6 to print out the" +
         " description of a movie." + "\nEnter 7 to terminate.\n"); 
         do {
            switch (action = input.nextInt()) {
               case 1:
                  System.out.println("\nYour random movie is:\n" +
                  playlist.getRandomMovie(input));          
                  break;
               case 2:
                  System.out.println("\nThe best movie for a date is:\n" +
                  playlist.getDateMovie());
                  break;
               case 3:
                  System.out.println("\nThe highest-rated movie is:\n" +
                  playlist.getBestMovie());
                  break;
               case 4:
                  playlist.addMovie(input);
                  break;
               case 5:
                  Movie pick = playlist.selectMovie(input);
                  System.out.println("\nPlease input each rating out of ten as an" +
                  " integer");
                  System.out.println("all on one line with a space between each" +
                  " integer below:");
                  input.nextLine();      
                  String[] nums = input.nextLine().split(" ");
                  System.out.println("\nThe old rating for this movie was " +
                  pick.getRating() + " out of 10.");
                  for (String num : nums) {
                     pick.rate(Integer.parseInt(num));
                  }
                  System.out.println("\nThe new rating for this movie is " +
                  pick.getRating() + " out of 10.");
                  break;
               case 6:
                  System.out.println(playlist.selectMovie(input));
                  break;    
               case 7:
                  System.out.print("Thank you and have a nice day!");
                  System.exit(0);
               default:
                  System.out.println("Invalid entry. Please enter an integer" +
                  "from 1 to 7");
                  break;    
            }
         } while (action > 7 || action < 1);
         System.out.print("\nWould you like to return to the main menu? ");
         answer = input.next();
      } while (answer.toUpperCase().equals("YES"));
      System.out.print("\nThank you and have a nice day!");
   }
   
}

/**
   This class represents a database that can hold up to 15 movies, with 10 movies already
   uploaded. It has getBestMovie, getDateMovie, and getRandomMovie methods to provide
   the user the highest rated-movie in the list, the longest movie, and a random movie
   within some criteria, respectively. The addMovie method can be used
   to append an additional movie to the database. selectMovie returns a movie chosen
   by the user from the movies in the list. The toString method displays the whole
   list.
*/
class MovieDatabase {
   private Movie[] movies;
   private int filled = 0;

   public MovieDatabase() {
      movies = new Movie[] {new Movie("Finding Nemo", "adventure", "G", 100.0, 8.1),   
                            new Movie("Wall.E", "adventure", "G", 98.0, 8.4),
                            new Movie("Cars", "comedy", "G", 117.0, 7.1),
                            new Movie("The Muppet Movie", "comedy", "G", 95.0, 7.6), 
                
                            new Movie("Spiderman: Homecoming", "adventure", "PG-13",
                            133.0, 7.4),
                            new Movie("Dune", "adventure", "PG-13", 135.0, 8.2),
                            new Movie("Star Wars: The Empire Strikes Back", "adventure",
                            "PG-13", 26.0, 8.7),
                            new Movie("Star Trek Beyond", "adventure", "PG-13", 122.0,
                            7.0),
                
                            new Movie("Frozen", "adventure", "PG", 102.0, 7.4),
                            new Movie("Monty Python's Holy Grail", "comedy", "PG",
                            91.0, 8.2),
                            new Movie("The Sting", "comedy", "PG", 129.0, 8.3),
                            new Movie("Home Alone", "comedy", "PG", 103.0, 7.6), null,
                            null, null};
      filled = 12;                
   }
   
   public void addMovie(Scanner input) {
      if (filled < movies.length) {
         String tempTitle = "", tempGenre = "", tempMPAA = "";
         double tempLength = 0.0;
         double tempRating = 0;
         input.nextLine();
         
         System.out.println("\nPlease enter the title of the movie you wish to add.");
         tempTitle = input.nextLine();
         
         System.out.println("Please enter the genre of the movie.");
         tempGenre = input.nextLine();
         
         System.out.print("Please enter the movie's MPAA rating: ");
         tempMPAA = input.next();
         
         System.out.print("Please enter the movie's length in minutes: ");
         tempLength = input.nextDouble();
         
         System.out.print("Please enter your rating for the movie as an integer" + 
         "\nbetween one and ten: ");
         tempRating = input.nextDouble();
         
         movies[filled] = new Movie(tempTitle, tempGenre,
         tempMPAA, tempLength, tempRating);
         System.out.println(movies[filled]);
         filled++;
      } else {
         System.out.println("Sorry, the database is already full.");
      }
   }
   
   public Movie getBestMovie() {
      Movie best = movies[0];
      for (int i = 1; i < filled; i++) {
         if (movies[i].getRating() > best.getRating()) best = movies[i];
         else if (movies[i].getRating() == best.getRating() &&
         Math.round(Math.random()*2) == 0) best = movies[i];
         /*
            This ensures if several movies have the same rating, a
            different one may be returned each time.
         */
      }
      return best;
   }
   
   public Movie getDateMovie() {
      Movie longest = movies[0];
      for (int i = 1; i < filled; i++) {
         if (movies[i].getLength() > longest.getLength()) longest = movies[i];
         else if (movies[i].getLength() == longest.getLength() &&
         Math.round(Math.random()*2) == 0) longest = movies[i];
         /*
            This ensures if several movies have the same rating, a
            different one may be returned each time.
         */
      }
      return longest;
   }
   
   public Movie getRandomMovie(Scanner input) {
      Movie rand = null;
      String selection = "";
      System.out.println("\nYou must provide a specific genre or MPAA rating or " +
      "minimum user\nrating according to which a random movie will be " +
      "selected for you.\nInput 1 to randomly select a movie from a specific genre." +
      "\nInput 2 to randomly select a movie with a specific MPAA rating.\nInput 3 to " +
      "randomly select a movie with a minimum user rating of ten.");
      selection = input.next();
      if (Integer.parseInt(selection) == 1) {
         System.out.print("\nPlease enter the genre: ");
         selection = input.next();
         do {
            rand = movies[(int)Math.round(Math.random()*filled)];
         } while (!rand.getGenre().equals(selection));
      } else if (Integer.parseInt(selection) == 2) {
         System.out.print("\nPlease enter the MPAA rating: ");
         selection = input.next();
         do {
            rand = movies[(int)Math.round(Math.random()*filled)];
         } while (!rand.getMPAA().equals(selection));
      } else if (Integer.parseInt(selection) == 3) {
         boolean possible = false;
         System.out.print("\nPlease enter the minimum user rating: ");
         selection = input.next();
         for (int i = 0; i < filled; i++) {
            if (movies[i].getRating() >= Double.parseDouble(selection)) possible = true;
         }
         if (possible) {
            do {
               rand = movies[(int)Math.round(Math.random()*filled)];
            } while (rand.getRating() < Double.parseDouble(selection));
         } else {
            System.out.println("\nSorry, we lack movies with or above that rating.");
         }
      }
      return rand;
   }
   
   public Movie selectMovie(Scanner input) {
      System.out.println("Current list of movies:\n");
      for (int i = 0; i < filled; i++) {
         System.out.println(i + ". " + movies[i].getTitle());
      }      
      System.out.print("\nSelect a movie by entering its number: ");
      return movies[input.nextInt()];
   }
      
   public String toString() {
      String menu = "";
      for (int i = 0; i < filled; i++) {
         menu += i + ". " + movies[i].getTitle() + "\n";
      }
      return menu;
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
   public Movie(String theTitle, String theGenre, String theMPAARating, double theLength,
   double firstRating) {
      title = theTitle;
      genre = theGenre;
      mpaa = theMPAARating;
      length = theLength;
      ratingsCount = 1;
      pointsSum = firstRating;
   }
   
   public void rate(int newRating) {
      pointsSum += newRating;
      ratingsCount++;
   }
   
   public double getRating() {
      return Math.round((double)pointsSum/ratingsCount*100)/100.0;
   }
   
   public double getLength() {
      return length;
   }
   
   public String getTitle() {
      return title;   
   }
   
   public String getGenre() {
      return genre;
   }
   
   public String getMPAA() {
      return mpaa;
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