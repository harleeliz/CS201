/////////////////////////////////////////////////////////////////////
// CS 401 Introduction to Advanced Studies I
// Student:      Harlee Liz Ramos
// Due date:     02/21/2024
// Program Name: Main.java
/////////////////////////////////////////////////////////////////////

package Lab05;
import java.util.*;
import java.text.DecimalFormat;

public class Main {

public static void main(String[] args) {
	//Scanner object to read input from the user.
	Scanner scan = new Scanner(System.in); 
	
	//Decimal object format
	DecimalFormat df = new DecimalFormat("#0.00"); 
	
	System.out.print("Please enter the value of n: "); // Prompt the user to enter the value of n
	int n = scan.nextInt();  // Read and store the integer value.
	System.out.println();
	
	
	//Recursive approach
	JacobsthalCalculator test = new JacobsthalCalculator(); //Creation object of the JacobsthalCalculator class
	
	long startTime1 = System.currentTimeMillis(); // Record the start time before executing the recursive method
	
	test.Jacobsthal_recursive(n); // Call the recursive method
	
	long endTime1 = System.currentTimeMillis(); // Record the end time after executing the recursive method
	
	System.out.print("Recursive version: ");
	test.Jacobsthal_printer_recursive(n); // Print the Jacobsthal sequence using the recursive method
	System.out.println();
	
	long executionTime1 = endTime1 - startTime1; // Calculate the execution time for the recursive method.
	
	System.out.println("Time taken to execute recursive version: "+df.format(executionTime1)+" ms"); // Print the final result
	
	System.out.println();
	
	//Iterative approach
	long startTime2 = System.currentTimeMillis(); // Record the start time before executing the iterative method
	
	test.Jacobsthal_iterative(n); // Call the iterative method
	
	long endTime2 = System.currentTimeMillis();  // Record the end time after executing the iterative method
	
	System.out.print("Interative version:");
	test.Jacobsthal_printer_iterative(n); // Print the Jacobsthal sequence using the iterative method
	System.out.println();
	
	long executionTime2 = endTime2 - startTime2;  // Calculate the execution time for the iterative method.
	
	System.out.println("Time taken to execute iterative version: "+df.format(executionTime2)+" ms"); // Print the final result
     
 }

}

