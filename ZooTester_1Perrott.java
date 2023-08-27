// Name: Samuel Perrott
// Assignment: Inherits-A5: Zoo Lab
 
import java.util.List;
import java.util.ArrayList;

public class ZooTester_1Perrott {
   public static void main(String[] args) {
      List<Animal> animals = new ArrayList<>();
      animals.add(new Animal("Joe"));
      animals.add(new Zebra());
      animals.add(new Zebra("Zellie", 20));
      animals.add(new Dolphin("Dora", 120.5));
      animals.add(new AtlanticSpotted("Marianne", 100.5, 99));
      animals.add(new Panda("Po", 515.5));
      animals.add(new Lion("Simba", 381));
      
      for (Animal a : animals) {
         System.out.println(a);
         a.speak();
      }
      
      System.out.println();
      Zebra zellie = (Zebra)animals.get(2);
      zellie.gallop();
      
      System.out.println();      
      Dolphin dora = (Dolphin)animals.get(3);
      dora.blowhole();

      System.out.println();      
      AtlanticSpotted marianne = (AtlanticSpotted)animals.get(4);
      marianne.blowhole();
      marianne.bubbles();

      System.out.println();      
      Panda po = (Panda)animals.get(5);
      po.eatBamboo();

      System.out.println();      
      Lion simba = (Lion)animals.get(6);
      simba.pounce();
      
   }
}

class Animal {
   private String name;
   
   public Animal(String name) {
      this.name = name;
   }
   
   public void speak() {}
   
   public String toString() {
      return name;
   }
}

class Zebra extends Animal {
   private int stripesCount;
   
   public Zebra() {
      super(null);
   }
   
   public Zebra(String name, int stripesCount) {
      super(name);
      this.stripesCount = stripesCount;
   }
   
   @Override
   public String toString() {
      return "This zebra's name is " + super.toString() + " and has " + stripesCount + " stripes.";
   }
   
   public void gallop() {
      System.out.println("The zebra " + super.toString() + " galloped.");
   }
   
   @Override
   public void speak() {
      System.out.println("Neigh");
   }
}

class Dolphin extends Animal {
   private double length;
   public Dolphin() {
      super(null);
   }
   public Dolphin(String name, double length) {
      super(name);
      this.length = length;
   }
   
   public void blowhole() {
      System.out.println(super.toString() + " just spewed water!");
   }

   @Override
   public void speak() {
      System.out.println("Chirp");
   }
   
   @Override
   public String toString() {
      return "This dolphin's name is " + super.toString() + " and is " + length + " inches long.";
   }
}

class AtlanticSpotted extends Dolphin {
   private int spotsCount;
   public AtlanticSpotted() {
      super();
   }
   
   public AtlanticSpotted(String name, double length, int spotsCount) {
      super(name, length);
      this.spotsCount = spotsCount;
   }
   
   @Override
   public String toString() {
      return super.toString() + " Also, the dolphin has " + spotsCount + " spots.";
   }
   
   public void bubbles() {
      System.out.println("Bubbles appeared.");
   }
}

class Panda extends Animal {
   private double pounds;
   
   public Panda() {
      super(null);
   }
   
   public Panda(String name, double pounds) {
      super(name);
      this.pounds = pounds;
   }
   
   @Override
   public void speak() {
      System.out.println("Burp");
   }
   
   public void eatBamboo() {
      System.out.println("Yummy");
   }
   
   @Override
   public String toString() {
      return "This panda's name is " + super.toString() + " and weighs " + pounds + " pounds.";
   }
}

class Lion extends Animal {
   private int hairsCount;
   public Lion() {
      super(null);
   }
   public Lion(String name, int hairsCount) {
      super(name);
      this.hairsCount = hairsCount;
   }
   
   public void pounce() {
      System.out.println(super.toString() + " pounced on you.");
   }
   
   @Override
   public void speak() {
      System.out.println("Rrooaaarrr!!");
   }
   
   @Override
   public String toString() {
      return "This lion's name is " + super.toString() + " and has " + hairsCount + " hairs.";
   }
}