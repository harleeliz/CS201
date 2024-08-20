/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I - Spring Project 2024
//Student:      Harlee Liz Ramos
//Due date:     04/21/2024
//Program Name: SelectionSort.java
/////////////////////////////////////////////////////////////////////

// Defines the package name, which helps organize the codebase by grouping similar classes.
package project;

// Declaration of the SelectionSort class that extends the abstract Sort class.
public class SelectionSort extends Sort {
    // Private variable to count the number of comparisons made during the sorting process.
    private int comparisonCount = 0;

    // Overrides the sort method from the superclass to provide specific implementation for selection sort.
    @Override
    public void sort(Clothing[] clothingArray, int clothingCount) {
        // Iterate over each element in the array except the last one.
        for (int i = 0; i < clothingCount - 1; i++) {
            int minIndex = i; // Assume the current index is the minimum.
            // Search the rest of the array to find the smallest element.
            for (int j = i + 1; j < clothingCount; j++) {
                comparisonCount++; // Increment comparison count for each comparison made.
                // If the current element is less than the assumed minimum, update minIndex.
                if (clothingArray[j].getId() < clothingArray[minIndex].getId()) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the current position.
            swap(clothingArray, minIndex, i);
        }
    }

    // Returns the total number of comparisons made during the sorting process.
    @Override
    public int getComparisonCount() {
        return comparisonCount;
    }

    // Setter method for comparison count, allows external setting of the comparison count, useful for testing or resetting.
    public void setComparisonCount(int comparisonCount) {
        this.comparisonCount = comparisonCount;
    }

    // Override toString method to provide a string representation of the SelectionSort object.
    @Override
    public String toString() {
        return "SelectionSort{" + "comparisonCount=" + comparisonCount + '}';
    }
}
