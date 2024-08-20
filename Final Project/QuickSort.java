/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I - Spring Project 2024
//Student:      Harlee Liz Ramos
//Due date:     04/21/2024
//Program Name: QuickSort.java
/////////////////////////////////////////////////////////////////////
// Specifies the package where the class is located, which helps organize similar classes.
package project;

// Declaration of the QuickSort class that extends the abstract Sort class.
public class QuickSort extends Sort {
    // Private variable to count the number of comparisons made during sorting.
    private int comparisonCount = 0;

    // Override the sort method from the superclass to provide specific implementation for quick sort.
    @Override
    public void sort(Clothing[] clothingArray, int clothingCount) {
        // Start the quick sort process from the first to the last index of the array.
        quickSort(clothingArray, 0, clothingCount - 1);
    }

    // Recursive quick sort method.
    private void quickSort(Clothing[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index.
            int pivotIndex = partition(array, low, high);
            // Recursively apply quick sort to the left of the pivot.
            quickSort(array, low, pivotIndex - 1);
            // Recursively apply quick sort to the right of the pivot.
            quickSort(array, pivotIndex + 1, high);
        }
    }
    // Method to partition the array into two parts.
    private int partition(Clothing[] array, int low, int high) {
        // The pivot is chosen to be the element at the high index.
        Clothing pivot = array[high];
        // Pointer for the greater element
        int i = (low - 1);  // place for the right position of pivot found so far

        // From low to high-1
        for (int j = low; j < high; j++) {
            comparisonCount++; // Increment comparison count for each comparison.
            // If current element is smaller than the pivot, increment the low pointer
            // and swap the current element with the element at low pointer.
            if (array[j].getId() <= pivot.getId()) {
                i++;
                swap(array, i, j);  // Swap elements at i and j
            }
        }
        // Swap the pivot element with the element at i+1.
        swap(array, i + 1, high);
        // Return the index of the pivot element after swaps.
        return i + 1;
    }

    // Method to get the current count of comparisons made during sorting.
    @Override
    public int getComparisonCount() {
        return comparisonCount;
    }
    // Setter method for comparison count, useful for resetting or adjusting the count externally.
    public void setComparisonCount(int comparisonCount) {
        this.comparisonCount = comparisonCount;
    }
    // Override toString method to provide a string representation of the QuickSort object.
    @Override
    public String toString() {
        return "QuickSort{" + "comparisonCount=" + comparisonCount + '}';
    }
}
