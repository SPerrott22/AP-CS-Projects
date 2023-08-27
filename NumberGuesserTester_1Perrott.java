/**
   A short program to practice random numbers, numeric input, if statements  allowing the user to guess a secret number.
   @author Samuel Perrott
*/

import java.util.Scanner; // import Scanner class to obtain user input

/**
   A tester class to test the NumberGuesser class.
*/
public class NumberGuesserTester_1Perrott {
   /**
      Main method.
      @param args array of String
   */
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in); // Create an instance of Scanner class and specify input location.
      NumberGuesser zeroInput = new NumberGuesser(input); // Create instance of NumberGuesser with default constructor (user doesn't set upper bound).
      boolean answer = false; // User's guess.
      int x = 0; // Number of guesses.
      System.out.println("Please guess a number between 0 and 9, inclusive.");
      do {
         answer = zeroInput.play();
         x += 1;
      } while (answer == false); // loops until user guesses correctly.
      System.out.println("You took "+x+" attempt(s).");
      
      System.out.print("Enter a positive upper bound: ");
      int upperBound = input.nextInt(); // Upper bound determined by user.
      NumberGuesser userInput = new NumberGuesser(upperBound, input);
      answer = false;
      x = 0;
      System.out.println("Please guess a number between 0 and "+(upperBound - 1)+" inclusive.");
      do {
         answer = userInput.play();
         x += 1;
      } while (answer == false);
      System.out.println("You took "+x+" attempt(s).");
   }
}

/**
   A number guesser class that stores the number to be guessed and has a play method.
*/

class NumberGuesser {
   private double numberToGuess;
   private Scanner input;
   /**
      The default constructor sets the number to guess to be a random value from 1 to 10.
      @param in Scanner object
   */
   public NumberGuesser(Scanner in) {
      numberToGuess = (int)(Math.random()*10);
      input = in;
   }
   /**
      The 2nd constructor takes an int parameter (called max) and creates a random number from 1 to max (including max as a possibility).
      @param max the excluded upper bound for the NumberToGuess
      @param in Scanner object
   */
   public NumberGuesser(int max, Scanner in) {
      numberToGuess = (int)(Math.random()*max);
      input = in;
   }
   /**
      A method play that return true or false depending on whether the user guesses the correct number.
      @return boolean true or false guess
   */
   public boolean play() {
      boolean correctGuess = false;
      int guess = input.nextInt();
      if (guess > numberToGuess) {
         System.out.println("Lower");
      } else if (guess < numberToGuess) {
         System.out.println("Higher");
      } else {
         System.out.println("Congrats! You got it correct!");
         correctGuess = true;
      }
      return correctGuess;
   }   
}   
      