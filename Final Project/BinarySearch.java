/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I - Spring Project 2024
//Student:      Harlee Liz Ramos
//Due date:     04/21/2024
//Program Name: BinarySearch.java
/////////////////////////////////////////////////////////////////////

// Package declaration
package project;
// Importing necessary Java libraries
import java.util.Random;    // For generating random numbers
import java.text.DecimalFormat;  // For formatting the output
// Declaration of the BinarySearch class
public class BinarySearch
{
    // Constant representing the size of the array to be searched
    static final int SIZE = 100;
    // Array of integers to hold values for searching
    static int[] values = new int[SIZE];

    // Initializes the values array with non-decreasing 'random' integers
    static void initValues() {
        Random rand = new Random();   // Random number generator
        values[0] = 0;    // Starting value of the array
        // Filling the array with non-decreasing random values
        for (int index = 1; index < SIZE; index++) {
            values[index] = values[index - 1] + rand.nextInt(4); // Increment by up to 3
        }
    }

    // Constructor of BinarySearch class
    public BinarySearch() {
        super();  // Calls the superclass constructor
        // This constructor is auto-generated and does not contain specific actions.
    }

    // Method to print the values in the values array
    static void printValues() {
        int value;  // Variable to store each value during iteration
        DecimalFormat fmt = new DecimalFormat("000"); // Formatter for numbers
        System.out.println("The values array is:");
        // Iterating through the array and printing each value
        for (int index = 0; index < SIZE; index++) {
            value = values[index];
            // New line after every 10 values
            if (((index + 1) % 10) == 0)
                System.out.println(fmt.format(value));
            else
                System.out.print(fmt.format(value) + " ");
        }
        System.out.println();
    }
    // Iterative implementation of binary search that returns the iteration count
    static int binarySearchIterative(int target, int first, int last) {
        int midpoint;
        int iterations = 0; // Initialize iteration counter
        while (first <= last) {
            iterations++; // Increment at each division
            midpoint = (first + last) / 2;
            if (target == values[midpoint]) {
                return iterations; // Return the number of iterations if found
            } else if (target > values[midpoint]) {
                first = midpoint + 1;
            } else {
                last = midpoint - 1;
            }
        }
        return -1; // Return -1 if not found
    }

    // Recursive implementation of binary search
    static boolean binarySearchRecursive(int target, int first, int last) {
        if (first > last)  // Base case: target not found
            return false;
        int midpoint = (first + last) / 2;
        if (target == values[midpoint])  // Target found
            return true;
        else if (target > values[midpoint])  // Target is greater, search in the right half
            return binarySearchRecursive(target, midpoint + 1, last);
        else                                // Target is less, search in the left half
            return binarySearchRecursive(target, first, midpoint - 1);
    }

    // Placeholder method for binary search in an array of Clothing objects
    public static int binarySearch(Clothing[] clothingArray, int i, int j, int id) {
        // TODO Auto-generated method stub
        return 0;  // This method is not implemented and returns 0
    }




}
