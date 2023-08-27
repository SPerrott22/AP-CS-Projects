// Name: Samuel Perrott
// Assignment: AListA5: List o'Students LAB Dos 

import java.util.ArrayList;
/** 
   StudentListTester class that tests out
   methods of the Team class and Student
   class.
   
   @author Samuel Perrott
*/

public class StudentListTester_1Perrott {

   public static void main(String[] args) {
   
      Team purple = new Team("Purple");
      System.out.println("Original Team\n" + purple);
      purple.drop("John Barnes");
      System.out.println("\nJohn Barnes was kicked from Team "
                         + purple.getName() + ".");
      Student transfer = new Student("Sally Evans", 130, 12, 4.0, 1);
      transfer.reportGrade(99, 310.0);
      purple.add(transfer);
      System.out.println("\n" + transfer.getName() + " was added to Team "
                         + purple.getName() + ".");
      System.out.println("\nNew Team\n" + purple);
      System.out.println("\nThe tallest student in Team " + purple.getName()
                         + " is " + purple.findTallest().getName() + ",\nwho"
                         + " is " + purple.findTallest().getHeight()
                         + " cm tall.");
   }

}

/**
   Each object of this class represents a student with
   a unique name, height, GPA, and grade level.
   New grades can be reported via reportGrade
   and the student's name, height, and GPA
   can be accessed through getName, getHeight, and
   getGPA, respectively. The toString method lists
   out the student's name, height, GPA, and grade
   level.
*/
class Student {

   private String name;
   private double height;
   private int unitsAttempted;
   private double gradePoints;
   private int yearInSchool;
   
   public Student(String name, double height, int yearInSchool,
                  double gradePoints, int unitsAttempted) {
   
      this.name = name;
      this.height = height;
      this.yearInSchool = yearInSchool;
      this.gradePoints = gradePoints;
      this.unitsAttempted = unitsAttempted;
   
   }
   
   public void reportGrade(int units, double gradePointsEarned) {
      unitsAttempted += units;
      gradePoints += gradePointsEarned;
   }
   
   public String getName() {
      return name;
   }
   
   public double getHeight() {
      return height;
   }
   
   public double getGPA() {
      return gradePoints/unitsAttempted;
   }
   
   public String toString() {
      return "\nName: " + name + "\nHeight: " + height + " cm" + "\nGPA: "
             + getGPA() + "\nYear in School: "
             + yearInSchool;
   }

}

/**
   Instances of this class represent teams of students.
   Each team is auto-initiated with 5 students. Members
   can be added and dropped using the add and drop methods,
   respectively. Additionally, a findTallest method
   returns the tallest student in the team. 
*/
class Team {
   
   private String name;
   private ArrayList<Student> students;
   
   public Team(String name) {
      this.name = name;
      students = new ArrayList<>(5);
      students.add(new Student("Bill Stevens", 105, 12, 40.5, 10));
      students.add(new Student("John Barnes", 103, 11, 49.9, 10));
      students.add(new Student("Harvey Vanderski", 108, 12, 45.5, 10));
      students.add(new Student("Hugh Wyn", 200, 9, 30.5, 10));
      students.add(new Student("Greg Thimble", 150.4, 10, 35.5, 10));
   }
   
   public void add(Student newStudent) {
      students.add(newStudent);
   }
   
   public void drop(String name) {
      int indexToDrop = -1;
      for (int i = 0; i < students.size(); i++) {
         if (students.get(i).getName() == name) indexToDrop = i;
      }
      if (indexToDrop > -1) students.remove(indexToDrop);
      else System.out.println("Sorry, no student with that name was found.");
   }
   
   public Student findTallest() {
      Student tallest = students.get(0);
      for (int i = 1; i < students.size(); i++) {
         if (students.get(i).getHeight() > tallest.getHeight())
            tallest = students.get(i); 
      }
      return tallest;
   }
   
   public String getName() {
      return name;
   }
   
   public String toString() {
      String roster = "Team Name: " + name + "\nMembers:";
      for (Student s : students) {
         roster += "\n" + s;
      }
      return roster;
   }

}