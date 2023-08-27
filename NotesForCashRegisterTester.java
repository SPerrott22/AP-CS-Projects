// Samuel Perrott
// LoopsA1: Bell Mkt Coin Chgr

import java.util.Scanner;

/**
   Implement a program that directs a cashier how to give change.
   The program has two inputs: the amount due and the amount received from the customer.
   Display the dollars, quarters, dimes, nickels, and pennies that the customer should receive in return.
   In order to avoid roundoff errors, the program user should supply both amounts in pennies, for example 274 instead of 2.74.
   
   @author Samuel Perrott
*/
public class NotesForCashRegisterTester {

   /**
      In main, test it out, get input from the user and test it out.
      
      @param args is an array of Strings
   */
   public static void main(String[] args) {
      System.out.println("---------------------CASH REGISTER--------------------------/n/t/t/tBy Samuel Perrott");
      CashRegister bellMarketCoinChanger = new CashRegister();
   
      System.out.format("%.2f", number);
   
      Scanner input = new Scanner(System.in);
      // Testing it out
      System.out.println("DEMO:");
      System.out.println("A person gives $3 to the cashier for a bracelet that costs $2.37"); 
      Register.calculateChange(300,237);
      
      // Get input from user
      System.out.println("\nNow it's your turn!!!");
      boolean moreToBuy = true;
      // Use while loop to continue running the program so long as the user has more entries to calculate
      while (moreToBuy) { 
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
         
         System.out.println("\nWould you like to calculate another entry (Y/N)?");
         
         String answer = input.next();
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
class CashRegister {
   private int quarters, dimes, nickels, pennies, amountDue;
   public CashRegister() {
      quarters = 100;
      dimes = 100;
      nickels = 100;
      pennies = 100;
      amountDue = 100;
   }
   
   public void purchase(int itemPrice) {
      amountDue += itemPrice;
   }
   
   public int total() {
      return amountDue;
   }
   /**
      calculateChange will take 2 arguments: 1 amount of money given and 2 the total purchase amount.
      You can assume that the amount given is bigger or same as purchase amount.
      It will display the # of coins of each type to give out in change.
      
      @param given represents amount of money the customer hands to the cashier
      @param due represents the official price of the purchase
   */
   public static void calculateChange(int given, int due) {
      int change = given - due;
      System.out.println("\nHere is your change:\n");
      
      int q = change/25;
      quarters -= q;
      System.out.println("Quarters: " + q);
      change -= q*25;
      
      int d = change/10;
      dimes -= d;
      System.out.println("Dimes: " + d);
      change -= d*10;
      
      int n = change/5;
      nickels -= n;
      System.out.println("Nickels: " + n);
      change -= n*5;
      
      pennies -= change;
      System.out.println("Pennies: " + change);
   }
   
   public String toString() {
      return "Amount Left in Register:\nQuarters: " + quarters + "\nDimes: " + dimes + "\nNickels: " + nickels + "\nPennies: " + pennies);
   }
}


            
            System.out.print("Please enter item code: ");
            code = input.next().charAt(0);
            
            switch (code) {
               case 'A':
                  purchase(300);
                  break;
               case 'B':
                  purchase(500);
                  break;
               case 'C':
            }
                  
      char code = 'C';
      
      System.out.println("\t\t\tBell Breakfast Menu\n---------------------------------");
      System.out.println("Code\tName\t\t\t\t\tPrice");
      System.out.println("A\tHot Dog\t\t\t\t\t$3.00\nB\tBreakfast Burrito\t\t$5.00\nC\tCustom Entry\t\t\tUser Input\n");
      