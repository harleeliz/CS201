/////////////////////////////////////////////////////////////////////
// CS 401 Introduction to Advanced Studies I
// Student:      Harlee Liz Ramos
// Due date:     01/31/2024
// Program Name: Main.java
/////////////////////////////////////////////////////////////////////
package Lab02;

//This package contains the scanner, array list and comparator.
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// Creating an ArrayList to store Student objects
		List<Student> StudentArrayList = new ArrayList<Student>();
		
		// Creating a scanner reference variable for an object  to take user input
		Scanner userInput = new Scanner(System.in);
		  
		// Informing the user about the program
		System.out.println("This program will compare two students' names.");	
		
		// Loop to take input for two students
		for(int i = 0; i < 2; i++) {
			// Asking for student's ID
			System.out.println("Input the Student's ID");
			System.out.println("**Note: Please only input integer numbers. No not add letters or symbols.");
			int StudentID = userInput.nextInt();

			// Asking for student's name
			System.out.println("Input the Student's Name");
			userInput.nextLine(); // consume newline left-over
			String StudentName = userInput.nextLine();
	
			// Adding the new Student object to the ArrayList
			StudentArrayList.add(new Student(StudentName, StudentID));
		}
		//Print of an enter
		System.out.println();
		
		// Print instruction for the user
		System.out.println("Your input was:");
		
		// Sorting the ArrayList using the InfoComparator from the Student class
		Collections.sort(StudentArrayList, Student.InfoComparator);
			
		// Printing the sorted list of students
		for(Student str: StudentArrayList) {
			System.out.println(str);
		}
		
		
		// Getting the first and second students from the sorted list
		Student student1 = StudentArrayList.get(0);
		Student student2 = StudentArrayList.get(1);
		
		//Print of an enter
		System.out.println();
		
		System.out.println("Comparation result");
		
		// Comparing the names and IDs of the two students and printing appropriate messages
		if(student1.getName().equals(student2.getName()) && student1.getIdentification() == student2.getIdentification()) {
			System.out.println("Identifications and Names are the same");
		} else if(student1.getName().equals(student2.getName())) {
			System.out.println("Both Names matched, however IDs are not equal");
		} else if(student1.getIdentification() == student2.getIdentification()) {
			System.out.println("Both IDs matched, however Names are not equal");
		} else {
			System.out.println("Names and ID's are not equal");
		}
		
		// Closing the scanner reference variable for an object 
		userInput.close();
	}
}
