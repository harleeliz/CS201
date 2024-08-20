/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/03/2024
//Program Name: Part2.java
/////////////////////////////////////////////////////////////////////

package lab08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import lab08.List.CircularLinkedList;
import lab08.support.Employee;

public class Part2 {
	public static void main(String[] args) {

		System.out.println("This program is an implementation of the Circular LinkedList.");
		CircularLinkedList employeeList = new CircularLinkedList();

		File file = new File("emp.txt");

		try {
			Scanner scanner = new Scanner(file);
			int count = 0;
			while (scanner.hasNextLine() && count < 8) { // Insert first 8 elements
				String line = scanner.nextLine();
				String[] parts = line.split("\\s+");
				if (parts.length >= 2) {
					long id = Long.parseLong(parts[0]);
					String name = parts[1];
					Employee employee = new Employee(id, name);
					employeeList.insert(employee);
					count++;
				}
			}
			scanner.close();

			// Display elements after inserting
			System.out.println("Elements after insertion:");
			employeeList.display();

			// Delete one element by searching through ID (example)
			long idToDelete = 135792468; // Example ID to delete
			employeeList.deleteByID(idToDelete);

			// Display elements after deletion
			System.out.println("\nElements after deletion:");
			employeeList.display();
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.err.println("Invalid data format in the file.");
			e.printStackTrace();
		}
	}
}
