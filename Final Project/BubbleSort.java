/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I - Spring Project 2024
//Student:      Harlee Liz Ramos
//Due date:     04/21/2024
//Program Name: BubbleSort.java
/////////////////////////////////////////////////////////////////////

// Defines the package for the class, which helps in organizing related classes.
package project;

// Declaration of the BubbleSort class, which extends a base class named Sort.
public class BubbleSort extends Sort {
    // A private instance variable to keep track of the number of comparisons made during the sorting process.
    private int comparisonCount = 0;

    // Override annotation indicates that this method overrides a method in the superclass.
    @Override
    public void sort(Clothing[] clothingArray, int clothingCount) {
        boolean swapped; // Boolean flag to keep track of whether a swap has occurred in the current pass.
        do {
            swapped = false; // Initialize swapped to false at the start of each pass.
            // Loop through the array from the second element to the last element of the subarray defined by clothingCount.
            for (int i = 1; i < clothingCount; i++) {
                comparisonCount++; // Increment the count of comparisons for each comparison made.
                // Check if two adjacent items are in the wrong order.
                if (clothingArray[i - 1].getId() > clothingArray[i].getId()) {
                    // Call the swap method if the current item is less than the previous item.
                    swap(clothingArray, i - 1, i);
                    swapped = true; // Set swapped to true indicating a swap was made.
                }
            }
        } while (swapped); // Continue passes until no swaps are made on a new pass.
    }

    // Method to swap two elements in the array.
    public void swap(Clothing[] array, int index1, int index2) {
        Clothing temp = array[index1]; // Temporary storage of the first element.
        array[index1] = array[index2]; // Overwrite the first element with the second element.
        array[index2] = temp; // Set the second element with the value from temporary storage.
        // Debugging line commented out which would show the swap details.
    }

    // Method to get the current count of comparisons made.
    @Override
    public int getComparisonCount() {
        return comparisonCount;
    }

    // Setter method to reset or update the comparison count.
    public void setComparisonCount(int comparisonCount) {
        this.comparisonCount = comparisonCount;
    }

    // Override the toString method to provide a string representation of the BubbleSort object.
    @Override
    public String toString() {
        return "BubbleSort{" + "comparisonCount=" + comparisonCount + '}';
    }
}

