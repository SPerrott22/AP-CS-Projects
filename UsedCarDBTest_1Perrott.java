import java.util.ArrayList;

public class UsedCarDBTest_1Perrott {
  public static void main(String[] args) {
    UsedCarDB db = new UsedCarDB();

    db.addCarListing(new UsedCar("SUV", "fair", 12999.99));
    db.addCarListing(new UsedCar("SUV", "good", 13000));
    db.addCarListing(new UsedCar("SUV", "good", 14000));
    db.addCarListing(new UsedCar("SUV", "fair", 19000));
    db.addCarListing(new UsedCar("sedan", "fair", 7000));
    db.addCarListing(new UsedCar("sedan", "fair", 9000));
    db.addCarListing(new UsedCar("sedan", "good", 8000));
    db.addCarListing(new UsedCar("sedan", "good", 11000));
    db.addCarListing(new UsedCar("sedan", "excellent", 10000));
    db.addCarListing(new UsedCar("sedan", "good", 14000));
    db.addCarListing(new UsedCar("sedan", "excellent", 21000));
    db.addCarListing(new UsedCar("sedan", "excellent", 20000));
    db.addCarListing(new UsedCar("convertible", "fair", 13000));
    db.addCarListing(new UsedCar("coupe", "excellent", 80000));

    db.print();

    System.out.println(db.cheapest("SUV", "good"));
    System.out.println(db.cheapest("sedan", "excellent"));


    System.out.println(db.choices(14000, 22000, "SUV", "good"));
    System.out.println(db.choices(8000, 12000, "sedan", "good"));
    System.out.println(db.choices(8000, 20000, "sedan", "excellent"));
  }
}


class UsedCarDB
{
  ArrayList<UsedCar> carList; // contains UsedCars in increasing order of price

  public UsedCarDB()  {
    carList = new ArrayList<>();
  }

  /**
     Adds car to carList maintaining the nondecreasing order of price
  */
   public void addCarListing(UsedCar car)  {
      int i = 0;
      if (carList.size() != 0) {
         while (i < carList.size() && carList.get(i).price() <= car.price()) {
            i++;
         }
      }
      carList.add(i, car);
   }
/*   
   public void addCarListing(UsedCar car) {
      carList.add(car);
      int mindex = 1;
      for (int i = 0; i < carList.size() - 1; i++) {
         mindex = i;
         for (int j = i + 1; j < carList.size(); j++)
            if (carList.get(j).price() < carList.get(mindex).price()) mindex = j;
         carList.set(i, carList.set(mindex, carList.get(i)));

      }
   }*/

  /**
     @return the car listing that is the cheapest of those with matching
              type and condition or null if no cars with given type & cond
  */
   public UsedCar cheapest(String type, String condition)  {
      for (UsedCar car : carList) {
         if (car.carType().equals(type) && car.condition().equals(condition)) return car;
      }
      return null;
   }

  /**
    @return list of all cars with the given condition and type that are priced
          within the range [low, high]
  */
   public ArrayList choices(double low, double high, String type, String condition)  {
      ArrayList<UsedCar> options = new ArrayList<>();
      int lowIndex = 0;
      while (carList.get(lowIndex).price() < low) {
         lowIndex++;
      }
      int highIndex = carList.size() - 1;
      while (carList.get(highIndex).price() > high) {
         highIndex--;
      }
      for (int i = lowIndex; i <= highIndex; i++) {
         if (carList.get(i).carType().equals(type) && carList.get(i).condition().equals(condition)) options.add(carList.get(i));
      }
      return options; 
   }

   public void print()  {
      for(int index = 0; index < carList.size(); index++)
         System.out.println(carList.get(index));
         System.out.println();
      }
   }

class UsedCar  {
  private String myType;
  private String myCondition;
  private double myPrice;

  public UsedCar(String type, String condition, double price) {
    myType = type;
    myCondition = condition;
    myPrice = price;
  }

  public String carType()  {
    return myType;  // SUV, Sedan, Coupe, or Convertible
  }

  public String condition()  {
    return myCondition; // fair, good, or excellent
  }

  public double price()  {
    return myPrice;
  }

  public String toString()  {
    return carType() + " " + condition() + " " + price();
  }
}
