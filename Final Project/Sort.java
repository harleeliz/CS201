/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I - Spring Project 2024
//Student:      Harlee Liz Ramos
//Due date:     04/21/2024
//Program Name: Sort.java
/////////////////////////////////////////////////////////////////////

// Defines the package where the class is located, helping to organize the codebase.
package project;

// Import statement for utility functions from Java's Arrays class.
import java.util.Arrays;

// Declaration of an abstract class named Sort. Abstract classes cannot be instantiated directly and must be subclassed.
public abstract class Sort {

    // Abstract method that must be implemented by any subclass. It specifies how to sort an array of Clothing objects.
    public abstract void sort(Clothing[] clothingArray, int clothingCount);

    // Abstract method that returns the number of comparisons made during the sorting process. This is used for analyzing sorting efficiency.
    public abstract int getComparisonCount();

    // Protected method that can be accessed by subclasses of Sort. It swaps two elements in an array.
    protected void swap(Clothing[] array, int index1, int index2) {
        Clothing temp = array[index1];  // Temporary storage for the first element.
        array[index1] = array[index2];  // Overwrite the first element with the second element.
        array[index2] = temp;           // Set the second element with the value from temporary storage.
    }

    // Static method to measure and return the execution time of sorting in nanoseconds. It is useful for performance testing.
    public static long measureSortingTime(Clothing[] clothingArray, Sort sortAlgorithm) {
        Clothing[] copyArray = Arrays.copyOf(clothingArray, clothingArray.length);  // Create a copy of the array to avoid altering the original data.
        long startTime = System.nanoTime();  // Record the start time of sorting.
        sortAlgorithm.sort(copyArray, copyArray.length);  // Perform the sorting using the specified sorting algorithm.
        long endTime = System.nanoTime();  // Record the end time of sorting.
        return endTime - startTime;  // Calculate and return the duration of sorting.
    }

    // Static method to print elements of the Clothing array. This method is useful for debugging and verifying the correctness of sorting.
    public static void printClothingArray(Clothing[] array, int count) {
        for (int i = 0; i < count; i++) {
            if (array[i] != null) {  // Ensure the object is not null to avoid NullPointerException.
                System.out.println(array[i]);  // Print the Clothing object using its toString method.
            }
        }
    }

    // Override the default toString method to provide a simple string representation of an instance of Sort or its subclasses.
    @Override
    public String toString() {
        return "Sort{}";  // Returns a string that represents any instance of Sort or its subclasses.
    }
}
