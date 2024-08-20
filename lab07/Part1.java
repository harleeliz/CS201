/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/27/2024
//Program Name: Part1.java
/////////////////////////////////////////////////////////////////////

package lab07;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import lab07.queues.FloatingFrontQueue;
import lab07.queues.QueueOverflowException;
public class Part1 {
	public static void main(String[] args) {
		// Create a queue of type Employee with a capacity of 30
		FloatingFrontQueue<Employee> floatingFrontQueue = new FloatingFrontQueue<>(30);

		// Print the current working directory
		System.out.println(System.getProperty("user.dir"));
		// File object for the file located in the current working directory named
		// "emp.txt"
		File file = new File(System.getProperty("user.dir") + "/emp.txt");

		// Print a brief description of the program for the use
		System.out.println("This java program represents an usage of the Queue data structure implementation.");
		System.out.println(" ");

		try {
			// Create a Scanner object to read the file
			Scanner scanner = new Scanner(file);
			int count = 0; // Counter to read only first 10 Employees

			// Read the file line by line
			while (scanner.hasNextLine() && count < 10) {
				String line = scanner.nextLine();
				// Split the line into parts using whitespace as the delimiter
				String[] parts = line.split("\\s+");

				// If the line has at least two parts (id and name)
				if (parts.length >= 2) {
					// Parse the id and name
					long id = Long.parseLong(parts[0]);
					String name = parts[1];

					// Create a new Employee object
					Employee employee = new Employee(id, name);

					// Add the employee to the queue
					floatingFrontQueue.enqueue(employee);

					// Increment the counter
					count++;
				}
			}
			// Close the scanner
			scanner.close();

		} catch (FileNotFoundException e) {
			// Catch for Handle the case where the file is not found
			System.err.println("File not found");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// Catch for Handle the case where the file contains invalid data
			System.err.println("Invalid data format in the file.");
			e.printStackTrace();
		} catch (QueueOverflowException e) {
			// Catch for Handle the case where the queue is full
			System.err.println("Queue is full");
			e.printStackTrace();
		}

		// Process the queue
		floatingFrontQueue.printQueue("Sorted Employee IDs and Names");

		// Print the employee at index 8
		try {
			System.out.println("Employee at index 8: " + floatingFrontQueue.getEmployeeIdAndNameAtIndex8());
		} catch (IndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
	}

}
