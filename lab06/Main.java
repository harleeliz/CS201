/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     03/13/2024
//Program Name: Main.java
/////////////////////////////////////////////////////////////////////

package lab06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Create two queues of type Employee with a capacity of 30
		FixedFrontQueue<Employee> fixedFrontQueue = new FixedFrontQueue<>(30);
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

					// Add the employee to both queues
					fixedFrontQueue.enqueue(employee);
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

		// Process both queues
		processQueue("Fixed Front Queue", fixedFrontQueue);
		processQueue("Floating Front Queue", floatingFrontQueue);
	}

	private static void processQueue(String queueType, Queue<Employee> queue) {
		// Print the initial contents of the queue
		System.out.println(queueType + " initial contents:");
		printQueue(queue); // Prints the current elements in the queue

		try {
			// Dequeue three elements from the queue
			queue.dequeue();
			queue.dequeue();
			queue.dequeue();
		} catch (QueueUnderflowException e) {
			// Catch for Handle the case where the queue is empty during dequeue operations
			System.err.println("Queue is empty during dequeue operations.");
			e.printStackTrace();
		}

		// Print the contents of the queue after the dequeues
		System.out.println(queueType + " contents after 3 dequeues:");
		printQueue(queue); // Prints the elements after dequeuing thrice
	}

	private static void printQueue(Queue<Employee> queue) {
		// Create a temporary queue to hold the elements while printing
		Queue<Employee> tempQueue;
		if (queue instanceof FixedFrontQueue) {
			tempQueue = new FixedFrontQueue<>(30);
		} else if (queue instanceof FloatingFrontQueue) {
			tempQueue = new FloatingFrontQueue<>(30);
		} else {
			return; // Or handle other types of queues
		}

		// Print and enqueue the elements to the temporary queue
		while (!queue.isEmpty()) {
			try {
				Employee employee = queue.dequeue();
				System.out.println(employee);
				tempQueue.enqueue(employee);
			} catch (QueueUnderflowException | QueueOverflowException e) {
				e.printStackTrace();
			}
		}

		// Refill the original queue from the temporary queue
		while (!tempQueue.isEmpty()) {
			try {
				queue.enqueue(tempQueue.dequeue());
			} catch (QueueUnderflowException | QueueOverflowException e) {
				e.printStackTrace();
			}
		}
	}
}
