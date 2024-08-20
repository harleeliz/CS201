/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I - Spring Project 2024
//Student:      Harlee Liz Ramos
//Due date:     04/21/2024
//Program Name: LinearSearch.java
/////////////////////////////////////////////////////////////////////

// Package declaration, groups related classes and interfaces.
package project;

// Declaration of the LinearSearch class.
public class LinearSearch {
    // Static method named linearSearch that takes an array of Clothing objects and an integer id as parameters.


    public static int linearSearch(Clothing[] array, int id) {
        int iterations = 0; // Counter for iterations
        for (int i = 0; i < array.length; i++) {
            iterations++; // Increment the counter each loop
            if (array[i] != null && array[i].getId() == id) {
                return iterations; // Return the iteration count instead of the index
            }
        }
        return -1; // Item not found, still return -1
    }


}
