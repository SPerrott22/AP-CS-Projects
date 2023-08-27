// Samuel Perrott
// LoopsA1: Bell Mkt Coin Chgr

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode; 

/**
   Tester class with main method that tests CashRegister class.
*/
public class CashRegisterTester_1Perrott {
   /**
      Main method of tester class that creates an instance of CashRegister and tests it.
      Then, the remaining coinage in the till is outputted after all transactions are completed.
      
      @param args is array of String.
   */
   public static void main(String[] args) {
      System.out.println("\n\t\t\tWelcome to Samuel Perrott's Mind-Blowing Cash Register Program");
      System.out.println("********************************************************************************\n");
      CashRegister bellMarketCoinChanger = new CashRegister();
      bellMarketCoinChanger.run();
      System.out.println(bellMarketCoinChanger);
      System.out.println("\nThank you for time! Have a nice day!");
   }
}

/**
   CashRegister class that stores a certain amount of coins and provides change for transactions.
*/
class CashRegister {
   private int quarters, dimes, nickels, pennies, totalDue;
   
   /**
      CashRegister constructor that sets all coin counts to 100.
   */
   public CashRegister() {
      quarters = 100;
      dimes = 100;
      nickels = 100;
      pennies = 100;
   }
   
   /**
      Your register will have a run method that provides
      the user interface to the register and allows purchases
      to be made continually until the user doesn't want to make
      any more purchases.
   */
   public void run() {
      Scanner input = new Scanner(System.in);
      boolean again = true;
      boolean anotherItem = true;
      boolean fraud = false;
      int penniesGiven = 0;

      do {
         totalDue = 0;
         anotherItem = true;
         while (anotherItem) {

            System.out.print("Please enter price of item: ");
            BigDecimal price = new BigDecimal(input.next());
            purchase(price.movePointRight(2).intValue());
            
            System.out.print("Would you like to add another item to your cart (Y/N)? ");
            if (!input.next().toUpperCase().equals("Y"))
               anotherItem = false;
         }     
             
         System.out.print("Your total bill is: " + total());

         do {
            System.out.print("\nPlease enter your payment: ");
                     
            do {
               BigDecimal given = new BigDecimal(input.next());
               penniesGiven = given.movePointRight(2).intValue();
               
               if (penniesGiven < totalDue) {
                  fraud = true;
                  System.out.print("You must pay more.\nPlease re-enter your payment: ");
               } else {
                  fraud = false;
               }
               
            } while (fraud); 
         } while (!calculateChange(penniesGiven));
         
         System.out.print("\nWould you like to complete another transaction (Y/N)? ");
         if (!input.next().toUpperCase().equals("Y"))
            again = false;
      } while (again);
   }
   
   public void purchase(int itemPrice) {
      totalDue += itemPrice;
   }
   
   /**
      A method that outputs the correct change for the transaction
      in terms of the number of quarters, dimes, nickels and pennies to be given to the customers.
      And, of course, the value of coins held are updated correctly.
      
      @param tenderGiven represents the value of the payment received in hundredths of a dollar.
   */
   public boolean calculateChange(int tenderGiven) {
      int change = tenderGiven - totalDue;
      
      int q = change/25;
      if (q > quarters) {
         System.out.println("Sorry. We do not have enough quarters to provide change.");
         System.out.println("Please re-enter your payment and provide exact change.");
         return false;
      }
      quarters -= q;
      change -= q*25;
      
      int d = change/10;
      if ((d > dimes) || (d > 2)) {
         System.out.println("Sorry. We do not have enough dimes to provide change.");
         System.out.println("Please re-enter your payment and provide exact change.");
         return false;
      }
      dimes -= d;
      change -= d*10;
      
      int n = change/5;
      if ((n > nickels) || (n > 1)) {
         System.out.println("Sorry. We do not have enough nickels to provide change.");
         System.out.println("Please re-enter your payment and provide exact change.");
         return false;
      }
      nickels -= n;
      change -= n*5;

      if ((change > pennies) || (change > 4)) {
         System.out.println("Sorry. We do not have enough pennies to provide change.");
         System.out.println("Please re-enter your payment and provide exact change.");
         return false;
      }      
      pennies -= change;
      
      System.out.println("\nHere is your change:\n");
      System.out.println("Quarters: " + q);
      System.out.println("Dimes: " + d);
      System.out.println("Nickels: " + n);
      System.out.println("Pennies: " + change);
      return true;

   }
   
   public String toString() {
      return "\nAmount Left in Register:\nQuarters: " + quarters + "\nDimes: " + dimes + "\nNickels: " + nickels + "\nPennies: " + pennies;
   }

   /**
      A method total that should return the total amount due for a transaction.
      
      @return String the bill in dollars
   */
   public String total() {
      BigDecimal bill = new BigDecimal (totalDue);
      bill = bill.movePointLeft(2).setScale(2, RoundingMode.HALF_UP);
      return bill.toString();
   }
}