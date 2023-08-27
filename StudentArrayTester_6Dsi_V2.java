import java.util.Scanner;
import java.util.ArrayList;
/**
   @author Dylan.Dsilva22
   AListA5: List o'Students LAB Dos
   
   Main class, test and run the Club class
 
 */
public class StudentArrayTester_6Dsi_V2 {
	public static void main(String[] args) {
		
		Club Teeology = new Club();
		Scanner scanni = new Scanner (System.in);
		
		System.out.println("Ayo, you are now in charge of the \"Teeology\" Club \n");
		System.out.println("(Previously members are aready been reinstatded)\n"
							+ "Beware, only a certain amount of student can be emmited, "
							+ "even when students are dropped.");
		
		
		Boolean looped = true;
		while(looped) {
			System.out.println("\nWhat would you like to do? type the number below");
			System.out.println("1 - view the current members names");
			System.out.println("2 - add a new member");
			System.out.println("3 - Find the tallest member");
			System.out.println("4 - update a sudents units and grade point ");
			System.out.println("5 - Drop a student from the club ");
			
			

			String tehResponce = scanni.nextLine();
			int finalResponce = Integer.valueOf(tehResponce);
			if(finalResponce == 1)
				System.out.println(Teeology);
			else if(finalResponce == 2)
				Teeology.add(Teeology.addStudent());
			else if(finalResponce == 3)
				System.out.println(Teeology.findtTallest()); 
			else if(finalResponce == 4) {
				System.out.println("Which student would you like to add grade points?");
				Teeology.drop();
				String responce = scanni.nextLine();
				int tehPerson= Integer.valueOf(responce);
				
				System.out.println("How many units did this person take?");
				
				String answer = scanni.nextLine();
				int tehGrade= Integer.valueOf(answer);
				
				System.out.println("What was the grade point for this person?");
				String response = scanni.nextLine();
				int tehPoints= Integer.valueOf(response);
				
				Teeology.changeGPA(tehPerson, tehGrade, tehPoints);
			}	
			else if (finalResponce == 5) {
				System.out.println("Which student would you like to drop?");
				String droppedName = scanni.nextLine();
				Teeology.drop(Teeology.findStudent(droppedName));
			}
			System.out.println("Do you want to continue? yes or no");
			String responce2you = scanni.nextLine();
			if(responce2you.toLowerCase().substring(0,1).equals("y")) {
				continue;
			}
			else {
				looped = false;
			}
		}
	}
}


/**
  this class Club puts the students into an arrayList,
  add a student to the club 
  returns the tallest student
  removes a selected student from the class
*/
class Club{
	private ArrayList<Student> tehClubHouse; //arrayList of the students
	private int numStudent; // the total num of students in the club
	private String className = "Teeology"; 
	private Scanner scannum = new Scanner (System.in);
	
	// Initializes the five members
	public  Club(){
		tehClubHouse = new ArrayList<Student>();
		tehClubHouse.add( new Student( "Jack", 12, 67, 4, 18)); 
		tehClubHouse.add( new Student( "Jill", 11, 55, 3, 12));
		tehClubHouse.add( new Student( "Joyce", 9, 73, 4, 10));
		tehClubHouse.add( new Student( "John", 12, 69, 5, 22));
		tehClubHouse.add( new Student( "Stacy ", 12, 71, 4, 16));
		
		for( int n = 0; n < tehClubHouse.size(); n++) {
			 numStudent++; 
		}
	}
	
	/**
	   take in the constructors for the students class 
	   @return a new student
	 */
	public Student addStudent() {
		if (tehClubHouse.size() > 11) {
			System.out.println("ERROR! To many Students in the class aready!");
			System.exit(0);
		}
		
		System.out.println("What is students name?");
		String newName = scannum.nextLine();
		
		System.out.println("What is what is the students graduation year?");
		String strYear = scannum.nextLine();
		int newYear = Integer.valueOf(strYear);
		
		System.out.println("What is the height of the student, in inches?");
		String strHeight = scannum.nextLine();
		int newHeight = Integer.valueOf(strHeight);
		
		System.out.println("How many units this student taking?");
		String strUnitsAtp = scannum.nextLine();
		int newUnitsAtp = Integer.valueOf(strUnitsAtp);
		
		System.out.println("What is the students grade point average?");
		String strGrade = scannum.nextLine();
		int newGrade = Integer.valueOf(strGrade);
		
		Student NewStudent = new Student(newName,newYear,newHeight,newUnitsAtp,
				newGrade);
		return NewStudent;	
	}
	/**
	   @param newStudent
	   add the student to the tehClubHouse
	 */
	public void add(Student newStudent) {
		tehClubHouse.add(newStudent);
		numStudent++;
	}
	
	/**
	   sorts thought the array to find the tallest member
	   @return the tallest student object 
	 */
	public Student findtTallest() {
		Student tallest = tehClubHouse.get(0);
			for( int i = 0; i < tehClubHouse.size(); i++ ) {
				if( tallest.getHeight() < tehClubHouse.get(i).getHeight() ) {
					tallest = tehClubHouse.get(i);
				}
			}
		return tallest;
	}
	/**
	   list the member of the club and a number associated to them
	 */
	public void drop() {
		int numTotal = 1;
		for( int i = 0; i <tehClubHouse.size(); i++ ) {
			System.out.println(numTotal + " - " + tehClubHouse.get(i).getName());
			numTotal++;
		}
	}
	/**
	   checks the students name with the array list remove the student, 
	   effective dropping the student 
	   @param name - the student that will be compared to the array 
	 */
	public void drop( Student name) {
		Student dropName = name;
		int droppedPos = 0; 
		for( int i = 0; i < tehClubHouse.size(); i++ ) {
			if( tehClubHouse.get(i).getName().equals(dropName.getName())) {
				droppedPos = i; 
			}
		}
		
		if( droppedPos !=0) {
			tehClubHouse.remove(droppedPos);
			numStudent--;
			System.out.println("Student Dropped");
		} else {
			System.out.println("No Student matches the name you just entered, "
					 + "please try again");
		}
	}
	
	/**
	   @param the name of the students
	   finds the corresponding student that matches the name
	   @return the corresponding student object
	 */
	public Student findStudent( String name) {
		String bbname = name;
		Student tehStudent = tehClubHouse.get(0);
		for(int i = 0; i <tehClubHouse.size(); i++) {
			if (tehClubHouse.get(i).getName().equals(bbname)) {
				tehStudent = tehClubHouse.get(i); 
			}
		}
		return tehStudent;
	}
   
	/**
	   @param placement - the object position of the said student object
	   @param units - the amount of units the students taken
	   @param points - the amount of points the students achieved
	   updates the GPA of the corresponding student object
	 */
	public void changeGPA( int placement, int units, int points) {
		tehClubHouse.get(placement-1).reportGrade(units, points);
	}
	
	/**
	   This toString prints out the name of the club and the members 
	 */
	public String toString ( ) {
		String output = className +" club\n";
		output += "Club Members:\n";
		String ttlNames = "";
		for( int i = 0; i < tehClubHouse.size(); i++ ) {
			ttlNames +=  "\t" + tehClubHouse.get(i).getName() + "\n";
		}
		output += ttlNames; 
		return output;
	}
}



/**
	Students Class:
	Initiates a Student object with variables like
	name, year of school, height(in inches), units and grade point average
	returns Student name, height and GPA
	updates the specific Students units attempted and grade point average
	to string to print out everything about the Student
*/

class Student{
	private String name; // the name of the student
	private int schoolYear;
	private int height; // the height of the student in inches
	private int unitsAttempted; 
	private int gradePoints; 
	private double gpa;

	/**
	   @param reName - the name of the student
	   @param reSchoolYear - the year of the student graduating
	   @param reHeight - the height of the student
	   @param reUnitsAttempted - the amount of units attempted
	   @param reGradePoints - the amount of points received 
	   this construction initalized the Student object
	 */
	public Student(String reName, int reSchoolYear, int reHeight, int reUnitsAttempted,
				   int reGradePoints) {
		name = reName;
		schoolYear = reSchoolYear;
		height = reHeight; 
		unitsAttempted = reUnitsAttempted;
		gradePoints = reGradePoints;
	}
   
	/**
	  @return the name of the student object
	 */
	public String getName() {
		return name;
	}
   
	/**
	  @return the height of the student object
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	  calculates the GPA of the student
	  @return the GPA of the student object
	 */
	public double getGPA() {
		gpa = (double)(gradePoints/unitsAttempted);
		return gpa;
	}
	
	/**
	   @param units - the new units acquired
	   @param gradePointsEarned - the amount of points obtained
	   adds the new units and points the Student object
	 */
	public void reportGrade( int units, int gradePointsEarned ) {
		unitsAttempted += units;
		gradePoints += gradePointsEarned;
	}
	
	/**
	   This toString prints out the information for the Student
	 */
	public String toString( ) {
		String extrema1;
		String extrema2;
		String extrema3;
		String extrema4;
		
		
		extrema1 = "Name: " + name;
		
		extrema2 =  "\nYear: " + schoolYear + " year";
		extrema3 = "\nheight: " + height;
		
		double gpa = gradePoints/unitsAttempted;
		extrema4 = "\nGPA:" + String.format("%.2f",gpa); 
		
		int length1 = extrema1.length();
		int length2 = extrema2.length();
		int length3 = extrema3.length();
		int length4 = extrema4.length();
		
		
		int largest = Math.max(length1, Math.max(length2, Math.max(length3, length4)));
		
		String line = "";
		for( int i = 0; i <largest; i++) {
			  line += "=";
		}
		
		String output = line + "\n";
		output += "Name: " + name;
		output+= "\nYear: " + schoolYear+ " year";
		output+= "\nHeigh( in inches): " + height;
		output+= "\nGPA: " + String.format("%.2f",gpa);
		output += "\n" + line + "\n";
		return output; 
	}
}