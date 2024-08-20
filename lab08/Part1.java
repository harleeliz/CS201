/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/03/2024
//Program Name: Part1.java
/////////////////////////////////////////////////////////////////////
package lab08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import lab08.List.LinkedList;
import lab08.List.ListInterface;
import lab08.support.Employee;

public class Part1 {
	public static void main(String[] args) {

		System.out.println("This program is an implementation of the LinkedList.");
		// Create a LinkedList to hold the employees
		ListInterface<Employee> employeeList = new LinkedList<>();

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
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			e.printStackTrace();
			return; // Exiting the program if file is not found
		} catch (NumberFormatException e) {
			System.err.println("Invalid data format in the file.");
			e.printStackTrace();
			return; // Exiting the program if invalid data format
		}

		// Sort the list using insertion sort
		insertionSort(employeeList);

		// Print the sorted list
		System.out.println("\nSorted List:");
		employeeList.printList();

		// Delete an employee with ID 120365872 from the list
		long idToDelete = 120365872;
		employeeList.delete(idToDelete);

		// Sort the list again after deletion
		insertionSort(employeeList);

		// Print the sorted list
		System.out.println("\nSorted List after deletion:");
		employeeList.printList();

	}

	// Method for sort list using Insertion Sort
	private static void insertionSort(ListInterface<Employee> list) {
		for (int i = 1; i < list.size(); i++) {
			Employee key = list.get(i);
			if (key != null) {
				int j = i - 1;

				while (j >= 0 && key.getId() < list.get(j).getId()) {
					list.set(j + 1, list.get(j));
					j--;
				}

				list.set(j + 1, key);
			}
		}
	}
}