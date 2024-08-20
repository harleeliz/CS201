/////////////////////////////////////////////////////////////////////
// CS 401 Introduction to Advanced Studies I
// Student:      Harlee Liz Ramos
// Due date:     02/07/2024
// Program Name: SelectionSort.java
/////////////////////////////////////////////////////////////////////

package Lab03;

public class SelectionSort {
   
    // Method to perform the selection sort algorithm on an integer array.
	
    public static void selectionSort(int[] numbers) {
    	
    	// Calculate the length of the array.
        int reference_length = numbers.length; 
        
        for (int i = 0; i < reference_length - 1; ++i) {
        	
        // Initialize min with the current element.
            int min = numbers[i]; 
         // Initialize the index of the minimum element.
            int index_Min = i; 

            for (int j = i + 1; j < reference_length; ++j) {
                // Find the minimum element and its index in the remaining unsorted part.
                if (numbers[j] < min) {
                    min = numbers[j];
                    index_Min = j;
                }
            }
            // Swap the current element with the minimum element.
            swap(numbers, i, index_Min);
        }
    }

    // Private method to swap two elements in the array.
    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

}
