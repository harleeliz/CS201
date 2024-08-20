/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I - Spring Project 2024
//Student:      Harlee Liz Ramos
//Due date:     04/21/2024
//Program Name: HeapSort.java
/////////////////////////////////////////////////////////////////////

// Defines the package name for organizational purposes, grouping related sorting classes.
package project;

// Declaration of the HeapSort class, extending a base class Sort.
public class HeapSort extends Sort {
    // Private instance variable to keep track of the number of comparisons made during sorting.
    private int comparisonCount = 0;

    // Override the sort method from the superclass to provide specific implementation for heap sort.
    @Override
    public void sort(Clothing[] clothingArray, int clothingCount) {
        // Build the heap (rearrange the array) starting from the middle to the root.
        for (int i = clothingCount / 2 - 1; i >= 0; i--) {
            heapify(clothingArray, clothingCount, i);
        }
        // One by one extract elements from the heap and rebuild the heap.
        for (int i = clothingCount - 1; i > 0; i--) {
            // Move current root to end (swap the root with the last item).
            swap(clothingArray, 0, i);
            // call max heapify on the reduced heap.
            heapify(clothingArray, i, 0);
        }
    }

    // Method to ensure the subtree rooted at 'i' is a heap.
    private void heapify(Clothing[] clothingArray, int heapSize, int i) {
        int largest = i;  // Initialize largest as root
        int left    = 2 * i + 1;  // left child
        int right   = 2 * i + 2;  // right child

        // If left child is larger than root, update largest.
        if (left < heapSize) {
            comparisonCount++;  // Increment comparison counter
            if (clothingArray[left].getId() > clothingArray[largest].getId()) {
                largest = left;
            }
        }

        // If right child is larger than current largest, update largest.
        if (right < heapSize) {
            comparisonCount++;  // Increment comparison counter
            if (clothingArray[right].getId() > clothingArray[largest].getId()) {
                largest = right;
            }
        }

        // If largest is not root, swap with root and continue heapifying.
        if (largest != i) {
            swap(clothingArray, i, largest);
            heapify(clothingArray, heapSize, largest);
        }
    }

    // Method to return the number of comparisons made during sorting.
    @Override
    public int getComparisonCount() {
        return comparisonCount;
    }

    // Setter method for comparison count, useful for resetting or adjusting the count externally.
    public void setComparisonCount(int comparisonCount) {
        this.comparisonCount = comparisonCount;
    }

    // Override toString method to provide a string representation of the HeapSort object.
    @Override
    public String toString() {
        return "HeapSort{" + "comparisonCount=" + comparisonCount + '}';
    }
}
