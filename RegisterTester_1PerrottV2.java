import java.util.Scanner;

/**
   Implement a program that directs a cashier how to give change.
   The program has two inputs: the amount due and the amount received from the customer.
   Display the dollars, quarters, dimes, nickels, and pennies that the customer should receive in return.
   In order to avoid roundoff errors, the program user should supply both amounts in pennies, for example 274 instead of 2.74.
   
   @author Samuel Perrott
*/
public class RegisterTester_1PerrottV2 {

   /**
      In main, test it out, get input from the user and test it out.
      
      @param args is an array of Strings
   */
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      boolean moreToBuy = true;
      // Use while loop to continue running the program so long as the user has more entries to calculate
      while (moreToBuy) { 
         // Get user input
         System.out.print("\nEnter total purchase amount (in pennies): ");
         int price = input.nextInt();
         System.out.print("Please enter the amount of money paid (in pennies): ");
         int payment = input.nextInt();
         
         // Validate the data entered: print out error message if the amount given is less than the purchase amount
         if (payment < price) {
            System.out.println("Don't scam me. You must pay more.");
         } else {
            Register.calculateChange(payment, price);
         }
         
         System.out.print("\nWould you like to calculate another entry (Y/N)? ");
         
         String answer = input.next();
         // I use next() instead of nextLine() to circumvent the <ENTER> problem
         if (!answer.toUpperCase().equals("YES") && !answer.toUpperCase().equals("Y")) {
            moreToBuy = false;
            System.out.println("\nThank you for your time. Have a nice day!");
         }
      }
   }
}
/**
   Register class representing the cash register at a store.
   You're fine with no instance variables nor constructors.... just one method
*/
class Register {
   /**
      calculateChange will take 2 arguments: 1 amount of money given and 2 the total purchase amount.
      You can assume that the amount given is bigger or same as purchase amount.
      It will display the # of coins of each type to give out in change.
      
      @param given represents amount of money the customer hands to the cashier
      @param due represents the official price of the purchase
   */
   public static void calculateChange(int given, int due) {
      int change = given - due;
      int dollars = change/100;
      System.out.println("\nHere is your change:\n");
      System.out.println("Dollars: " + dollars);
      change -= dollars*100;
      int quarters = change/25;
      System.out.println("Quarters: " + quarters);
      change -= quarters*25;
      int dimes = change/10;
      System.out.println("Dimes: " + dimes);
      change -= dimes*10;
      int nickels = change/5;
      System.out.println("Nickels: " + nickels);
      change -= nickels*5;
      System.out.println("Pennies: " + change);
   }
}