/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I - Spring Project 2024
//Student:      Harlee Liz Ramos
//Due date:     04/21/2024
//Program Name: MergeSort.java
/////////////////////////////////////////////////////////////////////

// Package declaration to organize code by functionality.
package project;

// Declaration of the MergeSort class that extends the abstract Sort class.
public class MergeSort extends Sort {
    // Private variable to count the number of comparisons made during sorting.
    private int comparisonCount = 0;

    // Overrides the sort method from the superclass to provide specific implementation for merge sort.
    @Override
    public void sort(Clothing[] clothingArray, int clothingCount) {
        // Base case: if the array part to be sorted is less than 2, return immediately.
        if (clothingCount < 2) {
            return;
        }
        // Find the middle point to divide the array into two halves.
        int mid = clothingCount / 2;
        // Creating temporary arrays to hold the left and right halves of the array.
        Clothing[] left = new Clothing[mid];
        Clothing[] right = new Clothing[clothingCount - mid];

        // Copying the data to temporary arrays.
        System.arraycopy(clothingArray, 0, left, 0, mid);
        System.arraycopy(clothingArray, mid, right, 0, clothingCount - mid);

        // Recursive calls to sort the two halves.
        sort(left, mid);
        sort(right, clothingCount - mid);

        // Merge the sorted halves.
        merge(clothingArray, left, right, mid, clothingCount - mid);
    }

    // Private method to merge two halves of the array.
    private void merge(Clothing[] clothingArray, Clothing[] left, Clothing[] right, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0; // Initialize pointers for left, right, and the main array.
        // Merge the temp arrays back into the main array as long as there are elements in both.
        while (i < leftSize && j < rightSize) {
            comparisonCount++; // Count each comparison.
            if (left[i].getId() <= right[j].getId()) {
                clothingArray[k++] = left[i++];
            } else {
                clothingArray[k++] = right[j++];
            }
        }
        // Copy the remaining elements of left, if any.
        while (i < leftSize) {
            clothingArray[k++] = left[i++];
        }
        // Copy the remaining elements of right, if any.
        while (j < rightSize) {
            clothingArray[k++] = right[j++];
        }
    }

    // Method to return the total number of comparisons made during the sorting process.
    @Override
    public int getComparisonCount() {
        return comparisonCount;
    }

    // Setter method for comparison count, useful for resetting or adjusting the count externally.
    public void setComparisonCount(int comparisonCount) {
        this.comparisonCount = comparisonCount;
    }

    // Override toString method to provide a string representation of the MergeSort object.
    @Override
    public String toString() {
        return "MergeSort{" + "comparisonCount=" + comparisonCount + '}';
    }
}
