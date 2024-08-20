/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/27/2024
//Program Name: Part3.java
/////////////////////////////////////////////////////////////////////
package lab07;
import java.util.Scanner;
public class Part3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char choice;
		do {
			// Prompt user to enter a string
			System.out.println("Enter a string to check if it's a palindrome:");
			String input = scanner.nextLine();

			// Check if the string is a palindrome using the Palindrome.test method
			if (Palindrome.test(input)) {
				System.out.println("The string is a palindrome.");
			} else {
				System.out.println("The string is not a palindrome.");
			}
			// Ask user if they want to continue
			System.out.println("Do you want to continue? (Y/N):");
			System.out.println("**Message: You can input Y or y for yes. ");
			System.out.println("Your answer: ");
			choice = scanner.nextLine().charAt(0); // Read the first character of the input and convert it to uppercase
													// for case-insensitive comparison
		} while (Character.toUpperCase(choice) == 'Y'); // Continue loop if user enters 'Y' (or 'y')
		scanner.close(); // Close the Scanner object to avoid resource leaks
	}
}
