public class StudentFiles_1Perrott {
   public static void main(String[] args) {
      Student alpha = new Student();
      alpha.initialize("Zee", 2042, "Martian College Prep");
      System.out.println(alpha.toString());
      alpha.changeSchool("Bellarmine College Prep");
      System.out.println("An Update To Zee's Profile Has Been Made:\n");
      System.out.println(alpha.toString());
      Student beta = new Student();
      beta.initialize("Sally Reese", 1984, "Orwell College");
      System.out.println(beta.toString());
      Student gamma = new Student(); 
      gamma.initialize("Bobby Jefferson", 2022, "Grants Pass High School");
      System.out.println(gamma.toString());
   }
}

class Student {
   private String name;
   private int year;
   private String school;
   public void initialize(String nomen, int annus, String scola) {
      name = nomen;
      year = annus;
      school = scola;
   }
   
   public String toString() {
      return (name + " is a member of the class of " + year + " at " + school + ".\n");
   }

   public void changeSchool(String scola) {
      school = scola;
   }
   
}