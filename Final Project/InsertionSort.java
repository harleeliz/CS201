/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I - Spring Project 2024
//Student:      Harlee Liz Ramos
//Due date:     04/21/2024
//Program Name: InsertionSort.java
/////////////////////////////////////////////////////////////////////

// Package declaration specifying where the class belongs within the project structure.
package project;

// Definition of the InsertionSort class that extends an abstract Sort class.
public class InsertionSort extends Sort {
    // Private variable to count the number of comparisons made during sorting.
    private int comparisonCount = 0;

    // Overrides the sort method defined in the abstract superclass Sort.
    // This method specifically sorts an array of Clothing objects using the insertion sort algorithm.
    @Override
    public void sort(Clothing[] clothingArray, int clothingCount) {
        // Loop through each element in the array starting from the second element.
        for (int i = 1; i < clothingCount; i++) {
            // The key is the item to be inserted in the sorted sublist.
            Clothing key = clothingArray[i];
            // Start comparing with the previous item.
            int j = i - 1;

            // While there are elements in the sorted array and the current element is greater than the key
            while (j >= 0) {
                comparisonCount++; // Increment the count for each comparison made.
                if (clothingArray[j].getId() > key.getId()) {
                    // Shift elements that are greater than the key to one position ahead of their current position
                    clothingArray[j + 1] = clothingArray[j];
                    j--; // Move backwards in the list.
                }
                else {
                    // Break the loop if we find an element smaller than the key since the key must be inserted here.
                    break;
                }
            }
            // Place the key after the element just smaller than it.
            clothingArray[j + 1] = key;
        }
    }

    // Returns the total number of comparisons made during the sorting process.
    @Override
    public int getComparisonCount() {
        return comparisonCount;
    }

    // Setter method to manually adjust the comparison count if necessary.
    public void setComparisonCount(int comparisonCount) {
        this.comparisonCount = comparisonCount;
    }

    // Overrides the toString method to return a string representation of the InsertionSort object,
    // specifically showing the number of comparisons.
    @Override
    public String toString() {
        return "InsertionSort{" + "comparisonCount=" + comparisonCount + '}';
    }
}
