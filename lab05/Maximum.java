/////////////////////////////////////////////////////////////////////
// CS 401 Introduction to Advanced Studies I
// Student:      Harlee Liz Ramos
// Due date:     02/21/2024
// Program Name: Maximun.java
/////////////////////////////////////////////////////////////////////
package Lab05; 

public class Maximum {

    // This method finds the maximum element in an array using recursion
    public static int maximum(int A[], int size) {
        // Base case: if size is 1, return the only element because is the smallest possible subproblem
        if (size == 1) {
        	
        	  // Return the first and only element at the index 0.
            return A[0]; 
         
        } else {
            // Recursive case: return the maximum of the last element and the maximum of the rest of the array
            // The problem was broken down into smaller subproblems
            return Math.max(A[size - 1], maximum(A, size - 1));  // Compare the last element with the maximum of the rest of the array
        }
    }

   
    public static void main(String args[]) {
        int A[] = {10, -20, 1, 2, 0, 5, 100};  //Array to find the maximum of
        int s = maximum(A, A.length);  //Calling the maximum method on the array
        System.out.println(s);
    }
}
