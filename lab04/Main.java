/////////////////////////////////////////////////////////////////////
// CS 401 Introduction to Advanced Studies I
// Student:      Harlee Liz Ramos
// Due date:     02/14/2024
//Program Name: Main.java
/////////////////////////////////////////////////////////////////////

package lab04;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    	
        // Print current working directory
        System.out.println(System.getProperty("user.dir"));

        // Create a file object representing "file.txt" in the current working directory
        File file = new File(System.getProperty("user.dir") + "/emp.txt");
        
        
        //Print instruction to the use
        System.out.println("This java program represents an usage of the Stack data structure implementation.");
        
        System.out.println(" ");
        try {
            // Create an instance of EmployeeStack
            EmployeeStack MyStack = new EmployeeStack(30);

            // Create a Scanner to read from the file
            Scanner scanner = new Scanner(file);

            // Use the scanner to read data from the file
            while (scanner.hasNextLine()) {
            	
                // Read a line from the file
                String line = scanner.nextLine();

                // Split the line to extract ID and Name
                String[] parts = line.split("\\s+");
                
                // Check if there are enough parts to extract ID and Name
                if (parts.length >= 2) {
                	
                    long id = Long.parseLong(parts[0]);
                    
                    String name = parts[1];
    
                    // Create an Employee object
                    Employee employee = new Employee(id, name);
                    
                    // Store the employee object in the stack
                    MyStack.push(employee);      
                }
            }
            
            //implementation of scanner close method
            scanner.close();

            // Print top element from stack
            System.out.println("Top element from the stack: " + MyStack.peek());

            // Popping two elements from stack
            MyStack.pop();
            MyStack.pop();

            // Perform Top operation on stack. Then print the top element from stack again.
            System.out.println("Popping two elements from stack. "
            		+ "After popping. Top element from the stack: " + MyStack.peek());

            // Pushing new data manually and top element from the stack.
            Employee newEmployee = new Employee(1234567893, "Liz");
            
            
            //Implementation of method push
            MyStack.push(newEmployee);
            
            
            System.out.println("After pushing new data. "
            		+ "Top element after pushing new data: " + MyStack.peek());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid data format in the file.");
            e.printStackTrace();
        }
    }
}