/////////////////////////////////////////////////////////////////////
// CS 401 Introduction to Advanced Studies I
// Student:      Harlee Liz Ramos
// Due date:     02/21/2024
// Program Name: JacobsthalCalculator.java
/////////////////////////////////////////////////////////////////////
package Lab05;

public class JacobsthalCalculator {
	
    // This method calculates the nth Jacobsthal number using recursion.
    public long Jacobsthal_recursive(int n) {
    	
    	// Base cases
    	if (n == 0 )   // The 0th Jacobsthal number is 0.
            return 0;
    	
        if (n == 1) // The 1st Jacobsthal number is 1.
            return 1;
        
        //Case for apply recursion
        // For n > 1, the nth Jacobsthal number is the sum of the (n-1)th Jacobsthal number and double the (n-2)th Jacobsthal number.
        return Jacobsthal_recursive(n - 1) + 2 * Jacobsthal_recursive(n - 2);
    }
    
    // This method calculates the nth Jacobsthal number using iteration.
    public long[] Jacobsthal_iterative(int n) {
        long arr[] = new long[n+1];  // Array to store the Jacobsthal numbers.
        arr[0] = 0;  // The 0th Jacobsthal number is 0.
        if (n > 0) {
            arr[1] = 1;  // The 1st Jacobsthal number is 1. When n > 0
        }
      
     // For n > 1, the sum of the (n-1)th Jacobsthal number and double the (n-2)th Jacobsthal number.
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + 2 * arr[i - 2];
        }
        // Return the array of Jacobsthal numbers.
        return arr;
    }
    // This method prints the first n Jacobsthal numbers using recursion.
    public void Jacobsthal_printer_recursive(int n) {
        for (int i = 0; i <= n; i++) {  // For loop for print each Jacobsthal number.
            System.out.print(Jacobsthal_recursive(i) + " ");
        }
    }
    
    // This method prints the first n Jacobsthal numbers using iteration.
    public void Jacobsthal_printer_iterative(int n) {
        // Calculate the first n Jacobsthal numbers using the iterative method.
        long[] arr = Jacobsthal_iterative(n);
        for (int i = 0; i <= n; i++) { // For loop for print each Jacobsthal number.
            System.out.print(arr[i] + " ");
        }
    }
}
