import java.util.ArrayList;

public class StockExchange {
   private static ArrayList<Company> companies = new ArrayList<>();
   public static void main(String[] args) {
      companies.add(new Company("PYPL"));
      companies.add(new Company("MSFT"));
      companies.add(new Company("AMZN"));
      for (Company c : companies) {
         System.out.println(c);
      }
      rally(25);
      System.out.println();
      for (Company c : companies) {
         System.out.println(c);
      }
   }
   public static void rally(int percent) {
      for (Company c : companies) {
         Stock s = c.getStock();
         s.change((int)(percent/100.0 * s.getValue()));
      }
   }
}

class Company {
   private String name;
   private Stock stock;
   
   public Company(String companyName) {
      name = companyName;
      stock = new Stock((int)(Math.random()*51) + 50);
      // initialize stock value to random # from 50 to 100: [50, 100]
   }
   
   public String toString() {return name + ": $" + stock.getValue();}
   
   public Stock getStock() {return stock;}
}

class Stock {
   private int value;
   public Stock(int value) {this.value = value;}
   public int getValue() {return value;}
   public void change(int amount) {value += amount;}
}