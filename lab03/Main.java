/////////////////////////////////////////////////////////////////////
// CS 401 Introduction to Advanced Studies I
// Student:      Harlee Liz Ramos
// Due date:     02/07/2024
// Program Name: Main.java
/////////////////////////////////////////////////////////////////////


package Lab03;

import java.util.Arrays;

public class Main {
	
	
	//Declaration of global variables for each test
	private static long test1, test2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println ( "This java application will use the sorting algorithm" );
        System.out.println ( "Testing to sort a random array with the Selection Sort" );
        //Print instruction for the user
        
        
        /* Declaration and initialization of an array variable numbers1 that will implement the method
         generateRandomArray of the class ArrayGenerator, with the set values for the random array.*/
        int[] numbers1 = ArrayGenerator.generateRandomArray ( 10_000 , 0 , 10_000 );
        //System.out.println("Unsorted Array: " + Arrays.toString( numbers1));
        
        //Declaration and initialization of a variable startTime1, that will store the time for generating the random array
        long startTime1 = System.nanoTime();
        long startTime2 = System.currentTimeMillis ( );
        
        //Implementation of the method selectionSort of the class SelectionSort
		SelectionSort.selectionSort ( numbers1 );
		
		//Declaration and initialization of a variable endTime1, that will store the time of generate the new sort array
		long endTime1 = System.nanoTime();
        long endTime2 = System.currentTimeMillis ( );
       
        
        //Initialization of a variable test1 that will perform the difference between the start and end time and provide the time that took to sort the array.
		test1 = endTime1 - startTime1;
		test2 = endTime2 - startTime2;
        
        
		//Print of the result in nanoseconds and milliseconds
        System.out.println ( );
        System.out.println ( "The sort took:  " + ( test1) + " ns" );
        System.out.println ( "The sort took:  " + ( test2 ) + " ms" );
	}

}
