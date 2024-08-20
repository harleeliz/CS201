/////////////////////////////////////////////////////////////////////
// CS 401 Introduction to Advanced Studies I
// Student:      Harlee Liz Ramos
// Due date:     02/07/2024
// Program Name: ArrayGenerator.java
/////////////////////////////////////////////////////////////////////
package Lab03;

public class ArrayGenerator {
    
    // Worker method to generate a random array of integers.
    public static int[] generateRandomArray(int length, int min, int max) {

        // Declaration of an integer array variable BaseArray with the specified length.
        int[] BaseArray = new int[length];

        // Iterate through the array to fill it with random integers.
        for(int i = 0; i < length; ++i) {
            /* This loops generates a random integer within the specified range (min to max).
             * Math.random() returns a random double
             * (max - min + 1) calculates the range of possible values.
             * Multiplying the random double by this range and casting it to an integer ensures a random integer within the range.
             * The addition of the min is for ensure that the random integer falls within the specified minimum and maximum range.*/
            BaseArray[i] = (int)(Math.random() * (double)(max - min + 1)) + min;
        }

        // Return the generated array.
        return BaseArray;
    }
}
