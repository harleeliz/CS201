/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I - Spring Project 2024
//Student:      Harlee Liz Ramos
//Due date:     04/21/2024
//Program Name: HMap.java
/////////////////////////////////////////////////////////////////////

// Package declaration to specify the namespace of the class.
package project;

// Import statement for the HashMap class from the java.util package, used for storing key-value pairs.
import java.util.HashMap;

// Declaration of the HMap class.
public class HMap {

    // Static method to create and return a HashMap that stores Clothing objects with their IDs as keys.
    public static HashMap<Integer, Clothing> createClothingMap(Clothing[] array) {
        // Create a new HashMap to store Clothing objects, where Integer is the key type (ID) and Clothing is the value.
        HashMap<Integer, Clothing> map = new HashMap<>();

        // Loop through each element in the provided array of Clothing objects.
        for (Clothing clothing : array) {
            // Check if the current Clothing object is not null to avoid inserting null values into the map.
            if (clothing != null) {
                // Add the Clothing object to the map, using its ID as the key and the object itself as the value.
                map.put(clothing.getId(), clothing);
            }
        }
        // Return the fully populated HashMap.
        return map;
    }

    // Static method that performs a search in the HashMap for a Clothing object by its ID and returns the number of iterations.
    public static int hashTableSearch(HashMap<Integer, Clothing> map, int id) {
        int iterations = 1; // Initialize the iterations count. In a hash table, lookups are typically O(1) operation.

        // Attempt to retrieve the Clothing object from the map using the provided ID.
        Clothing found = map.get(id); // get() method returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.

        // Check if the Clothing object was found in the map.
        if (found != null) {
            // If found, return the number of iterations (usually 1, as hashmap lookups are direct access).
            return iterations;
        }
        // Return -1 if the Clothing object is not found, indicating a failed search.
        return -1;
    }
}
