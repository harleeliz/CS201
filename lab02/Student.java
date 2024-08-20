/////////////////////////////////////////////////////////////////////
// CS 401 Introduction to Advanced Studies I
// Student:      Harlee Liz Ramos
// Due date:     01/31/2024
// Program Name: Student.java
/////////////////////////////////////////////////////////////////////
package Lab02;


//This package contains the scanner, arraylist and comparator.
import java.util.*;
public class Student {
	
	// Private global variables for student's name and identification number
	private String name;
	private int identification;

		// Constructor method of the Student class
		public Student (String name, int identification) {
			this.name = name;
			this.identification = identification;	
		}

		// Getter method --gets the student's name
		public String getName() {
			return this.name;
		}

		// Setter method --sets for the student's name
		public void setName(String name) {
			this.name = name;	
		}

		// Getter method --gets the student's identification number
		public int getIdentification() {
			return this.identification;
		}

		// Setter method --sets the student's identification number
		public void setIdentification(int identification) {
			this.identification = identification;	
		}

		// Comparator method for comparing two students based on their name and identification number
		public static Comparator<Student> InfoComparator = new Comparator<Student>() {
			public int compare(Student student1, Student student2) {
				// Convert names to uppercase for case-insensitive comparison
				String Stu_Name_1 = student1.getName().toUpperCase();
				String Stu_Name_2 = student2.getName().toUpperCase();
			
				// If names are equal, compare by identification number
				if(Stu_Name_1.compareTo(Stu_Name_2) == 0) {
					int Stu_Identification_1 = student1.getIdentification();
					int Stu_Identification_2 = student2.getIdentification();
					return Stu_Identification_1 - Stu_Identification_2;
				}
				// Otherwise, compare by name
				else return Stu_Name_1.compareTo(Stu_Name_2);
			}
		};

		// Overriding the toString method to print student's name and identification number
		@Override
		public String toString() {
			return "Student [Name= " + name + ", ID= " + identification + "]";
		}
	}

