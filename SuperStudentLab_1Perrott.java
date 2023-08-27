// Name: Samuel Perrott
// Assignment: Inherits-A1: Student Lab

/**
   A tester class that demonstrates inheritance
   through creating objects of the Student
   and Person classes.
*/
public class SuperStudentLab_1Perrott {
   
   /**
      Main method that creates Person and Student objects
      and then calls their toString methods.
   */
   public static void main(String[] args) {
      Person p1 = new Person("George Wilson", 123.5, 40);
      System.out.println(p1 + "\n----------------");
      
      Student s = new Student("Charles Blinsky", 101.4, 13, 9, 100, 25);
      System.out.println(s + "\n----------------");
      
      Person p2 = new Student("Wendy Bou", 100, 15, 10, 100, 20);
      System.out.println(p2);
   }

}

/**
   A Person class whose objects represent unique people with
   distinct names, heights, and ages.
*/
class Person {

   private String name;
   private double height;
   private int age;
   
   /**
      Constructs a person object by initializing
      the fields of the Person class.
      
      @param name the person's name
      @param height the person's height
      @param age the person's age
   */
   public Person(String name, double height, int age) {
      this.name = name;
      this.height = height;
      this.age = age;
   }
   
   public String toString() {
      return name + " is " + height + " cm tall and " + age + " years old.";
   }

}

/**
   Each object of this class represents a student with
   a unique name, height, age, GPA, and grade level.
   GPA is calculated by dividing grade points by
   units attempted. The toString method lists out the
   student's name, height, age, GPA, and grade level.
*/
class Student extends Person {

   private int unitsAttempted;
   private double gradePoints;
   private int yearInSchool;
   
   /**
      Constructs a student object by initializing
      the Person instance variables name, height, and age
      as well as the Student-specific variables yearInSchool,
      unitsAttempted, gradePoints.
      
      @param name the name of the person
      @param height the height of said person
      @param age the age of said person
      @param yearInSchool the student's grade level
      @param gradePoints the total number of grade points said student earned
      @param unitsAttempted the total number of units said student attempted
   */
   public Student(String name, double height, int age, int yearInSchool,
                  double gradePoints, int unitsAttempted) {
   
      super(name, height, age);
      this.yearInSchool = yearInSchool;
      this.gradePoints = gradePoints;
      this.unitsAttempted = unitsAttempted;
   
   }
   
   /**
      Calculates the GPA of the student from the
      total gradePoints the student earned divided by
      the number of units said student attempted.
      
      @return the student's GPA as a double
   */
   public double getGPA() {
      return gradePoints/unitsAttempted;
   }
   
   @Override
   /**
      Overrides Person toString to also include
      GPA and Year in School in addition to 
      name, height, and age.
      
      @return the student's info.
   */
   public String toString() {
      return super.toString() + "\nGPA: "
             + getGPA() + "\nYear in School: "
             + yearInSchool;
   }
   
}
