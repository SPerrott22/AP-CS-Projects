import java.util.Scanner;

/**
   password guesser program. Allows the user to guess the password.
   @author Samp
*/
public class PasswordTester_1Perrott {
   public static void main(String[] args) {
      PasswordGuesser pwd = new PasswordGuesser("password1");
      System.out.println(pwd.play());
   }
}
/**
*/
class PasswordGuesser {
   private String password;
   private Scanner input;
   /**
      initializes password using value provided by user and the scanner for input.
      @param passwordToGuess the password the user needs to guess.
   */
   public PasswordGuesser(String passwordToGuess) {
      password = passwordToGuess;
      input = new Scanner(System.in);
   }
   /**
      allows the user opportunity to guess the password.
      @return true if user guessed correctly, else false
   */
   public boolean play() {
      System.out.println("Get ready to guess my password...");
      System.out.print("What is your guess? ");
      String guess = input.nextLine();
      
      if (guess.equals(password)) {
         return true;
      } else {
         return false;
      }
      
   }
}