/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/03/2024
//Program Name: Part3.java
/////////////////////////////////////////////////////////////////////

package lab08;

import java.io.File;
import java.util.Scanner;
import lab08.List.DoubleLinkedList;
import lab08.support.Employee;

public class Part3 {
	public static void main(String[] args) {

		System.out.println("This program is an implementation of the Double LinkedList.");

		DoubleLinkedList<Employee> employeeList = new DoubleLinkedList<>();

		File file = new File("emp.txt");

		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split("\\s+");
				if (parts.length >= 2) {
					long id = Long.parseLong(parts[0]);
					String name = parts[1];
					Employee employee = new Employee(id, name);
					employeeList.add(employee);
				}
			}
			scanner.close();
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}

		// Add employees to the list
		employeeList.add(new Employee(456911875, "Mariana"));
		employeeList.add(new Employee(456911876, "Carlos"));
		employeeList.add(new Employee(456911878, "Selena"));

		// Print the list
		System.out.println("Employees in the list:");
		employeeList.printList();

		// Check if the list contains a specific employee
		Employee searchEmployee = new Employee(456911875, "Mariana");
		System.out.println("\nDoes the list contain " + searchEmployee + "? " + employeeList.contains(searchEmployee));

		// Remove an employee from the list
		Employee employeeToRemove = new Employee(456911876, "Carlos");
		boolean removed = employeeList.remove(employeeToRemove);

		if (removed) {
			System.out.println("\nEmployee " + employeeToRemove + " successfully removed.");
		} else {
			System.out.println("\nEmployee " + employeeToRemove + " not found in the list.");
		}

		// Print the updated list
		System.out.println("\nEmployees in the list after removing " + employeeToRemove + ":");
		employeeList.printList();
	}
}
