/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I - Spring Project 2024
//Student:      Harlee Liz Ramos
//Due date:     04/21/2024
//Program Name: CS401prj.java
/////////////////////////////////////////////////////////////////////


// Import statements for utility classes and other custom classes.
package project;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


// The main class for the project, managing clothing items.
public class CS401prj {
    // Stack to hold the clothing items, initialized to a max size of 300.
    private ArrayStack clothingStack = new ArrayStack ( 300 );


    // CS401prj method that acts as the program's entry point.
    public static void main ( String[] args ) {
        CS401prj project = new CS401prj ( );
        project.run ( );
    }

    // This method controls the overall flow of the application.
    private void run ( ) {
        Scanner scanner = new Scanner ( System.in );

        // Read data from file and populate the stack
        File file = new File ( "Clothing_Stock.txt" );
        try {
            Scanner fileScanner = new Scanner ( file );
            fileScanner.nextLine ( ); // Skip the header line.
            while ( fileScanner.hasNextLine ( ) ) {
                String   line  = fileScanner.nextLine ( );
                String[] parts = line.split ( "\t" ); // Split the line into parts.
                if ( parts.length >= 2 ) {
                    int      id          = Integer.parseInt ( parts[ 0 ] );
                    String   description = parts[ 1 ];
                    Clothing clothing    = new Clothing ( id ,description );
                    clothingStack.push ( clothing ); // Add the new item to the stack.
                }
            }
            fileScanner.close ( );
        } catch ( FileNotFoundException e ) {
            System.err.println ( "File not found" );
            e.printStackTrace ( );
            return;
        } catch ( NumberFormatException e ) {
            System.err.println ( "Invalid data format in the file." );
            e.printStackTrace ( );
            return;
        }



        
        
        

        // CS401prj interaction loop for user commands.
        boolean exit = false;
        while ( ! exit ) {

            // Menu for user interaction.
            System.out.println ( "◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤ ´MENU´ ◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤" );
            System.out.println ( "This java application represents a Clothing Stock for a Clothing Store." );
            System.out.println ( "1. Display clothing stock" );
            System.out.println ( "2. Sorting" );
            System.out.println ( "3. Searching" );
            System.out.println ( "4. Add Data" );
            System.out.println ( "5. Delete Data" );
            System.out.println ( "6. Update Data" );
            System.out.println ( "7. Restore Data" );
            System.out.println ( "8. Analyze Data" );
            System.out.println ( "9. Exit" );
            System.out.print ( "Enter your choice: " );

            int choice = scanner.nextInt ( );
            switch ( choice ) {
                case 1: // Display the current stock.
                    System.out.println ( "───── ❝ NOTE: This is the current stock ❞ ─────." );
                    printClothingList ( );  // Print the list of clothing items
                    break;
                case 2: // Perform sorting operations.
                    System.out.println ( "───── ❝ WARNING: Your selections will modify the order of the clothing stock ❞ ─────." );
                    performSorting ( );
                    break;
                case 3:// Perform search operations.
                    System.out.println ( "───── ❝ NOTE:  ❞ ─────." );
                    performSearching ( );
                    break;
                case 4: // Add new data.

                    addData ( );
                    System.out.println ( "───── ❝ WARNING: New data has been added.❞ ─────." );
                    break;
                case 5:// Delete existing data.

                    deleteData ( );
                    System.out.println ( "───── ❝ WARNING: Some data has been deleted.❞ ─────." );
                    break;
                case 6: // Update existing data.

                    updateData ( );
                    System.out.println ( "───── ❝ WARNING: Some data will be updated.❞ ─────." );
                    break;
                case 7: // Restore data to its original state.

                    restoreData ( );
                    System.out.println ( "───── ❝ WARNING: The clothing stock will be restored to its original form.❞ ─────." );
                    break;
                case 8:

                    analyzeData();
                    System.out.println ( "───── ❝ NOTE: The contents of the stock has been counted ❞ ─────." );
                    break;
                case 9: // Analyze data.
                    System.out.println ( "───── ❝ Closing program ❞ ─────." );
                    exit = true;
                    break;
                default: // Exit the program.
                    System.out.println ( "───── ❝Invalid choice. Please enter a number between 1 and 9❞ ─────." );
            }
        }
    }
    
    
 // Method to validate the user input
    private int getValidChoice(Scanner scanner) {
        int input;
        while (true) {
        
            input = scanner.nextInt();
            if (input >= 1 && input <= 6) {
                return input; // Valid input, return the value
            }
            System.out.println("Invalid choice. Please enter a number between 1 and 6.");
        }
    }
    
    

// Method to perform sorting operations and compare two sorting algorithms based on user choice.
    private void performSorting ( ) {
        // Create a new Scanner object to read input from the standard input stream.
        Scanner scanner = new Scanner ( System.in );
        // Display options for sorting algorithms to the user.
        System.out.println ( "───── ❝Choose two sorting algorithms to compare:❞ ─────." );
        System.out.println ( "1: Bubble Sort, 2: Heap Sort, 3: Insertion Sort, 4: Merge Sort, 5: Quick Sort, 6: Selection Sort" );
        // Prompt the user to enter their choice for the first sorting algorithm.
        System.out.print ( "Enter choice for the first algorithm: " );
        int choice1 = getValidChoice(scanner); // Ensure the choice is valid
        
        // Prompt the user to enter their choice for the second sorting algorithm.
        System.out.print ( "Enter choice for the second algorithm: " );
        int choice2 = getValidChoice(scanner); // Ensure the choice is valid

        // Initialize an array to store Clothing items from the stack. The size of the array is based on the current size of the stack.
        Clothing[] clothingArray = new Clothing[ clothingStack.size ( ) ];
        int        idx           = 0; // Index used for placing elements into the array.
        // Loop to transfer all items from the stack to the array.
        // This empties the stack and fills the array with the stack's elements.
        while ( ! clothingStack.isEmpty ( ) ) {
            // Remove the top item from the stack and add it to the array.
            clothingArray[ idx++ ] = ( Clothing ) clothingStack.pop ( );
        }

        // Begin sorting with the first chosen algorithm.
        long startTime = System.nanoTime(); // Record the start time in nanoseconds.
        Runtime.getRuntime().gc(); // Suggest the JVM to initiate garbage collection to minimize memory usage impact before sorting.
        long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // Calculate used memory before sorting starts.
        Sort sort1 = chooseSort(choice1); // Instantiate the first sorting algorithm based on user's choice.
        sort1.sort(clothingArray, clothingArray.length); // Execute the sorting algorithm on the clothing array.
        long endTime = System.nanoTime(); // Record the end time in nanoseconds.
        long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // Calculate used memory after sorting ends.
        long memoryUsed1 = endMemory - startMemory; // Determine the amount of memory used by the sorting process.
        long duration1 = endTime - startTime; // Calculate the duration of the sorting process in nanoseconds.


        // Begin sorting with the second chosen algorithm on a clone of the original array to ensure identical data sets.
        Clothing[] clothingArrayForSort2 = clothingArray.clone(); // Create a copy of the original array to avoid sorting already sorted data.
        startTime = System.nanoTime(); // Record start time for the second sorting.
        Runtime.getRuntime().gc(); // Suggest the JVM to initiate garbage collection again before the second sort.
        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // Memory used before the second sort starts.
        Sort sort2 = chooseSort(choice2); // Instantiate the second sorting algorithm.
        sort2.sort(clothingArrayForSort2, clothingArrayForSort2.length); // Execute the second sorting algorithm.
        endTime = System.nanoTime(); // Record end time for the second sorting.
        endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // Memory used after the second sort ends.
        long memoryUsed2 = endMemory - startMemory; // Determine the memory used for the second sorting process.
        long duration2 = endTime - startTime; // Calculate the duration of the second sorting process.


        // Print decorative lines for visual separation and display the sorting results.
        System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
        System.out.println("Sorting completed. Comparing results...");
        System.out.println("Results for " + sort1.getClass().getSimpleName() + ": " + duration1 + " ns, "
                                   + sort1.getComparisonCount() + " comparisons, " + memoryUsed1 + " bytes used.");
        System.out.println("Results for " + sort2.getClass().getSimpleName() + ": " + duration2 + " ns, "
                                   + sort2.getComparisonCount() + " comparisons, " + memoryUsed2 + " bytes used.");



        // Repopulate the stack with the sorted data from the first sort to maintain state across the application.
        for (int i = 0; i < clothingArray.length; i++) {
            clothingStack.push(clothingArray[i]);
        }


        // Output the sorted list for visual confirmation, formatted in two columns.
        System.out.println("Sorted list from the first algorithm:");
        for (int i = 0; i < clothingArray.length; i++) {
            String leftColumn = clothingArray[i].toString(); // Format the current item for the left column.
            String rightColumn = (i + 1 < clothingArray.length) ? clothingArray[i + 1].toString() : ""; // Prepare the next item for the right column, if available.
            System.out.printf("%-50s %-50s %n", leftColumn, rightColumn); // Print both columns
            if (i + 1 < clothingArray.length) { // Print both columns formatted to a fixed width.
                i++;// Increment the loop counter to skip the next item since it's already printed.
            }
        }

        System.out.println("\n"); // Add an extra newline for better readability between sections.


        // Print sorted list from the second sort in two columns
        System.out.println("Sorted list from the second algorithm:");
        for (int i = 0; i < clothingArrayForSort2.length; i++) {
            String leftColumn = clothingArrayForSort2[i].toString();
            String rightColumn = (i + 1 < clothingArrayForSort2.length) ? clothingArrayForSort2[i + 1].toString() : "";
            System.out.printf("%-50s %-50s %n", leftColumn, rightColumn);
            if (i + 1 < clothingArrayForSort2.length) { // Skip to next pair
                i++;
            }
        }

    }

    // Method to choose and instantiate a sorting algorithm based on user input.
    private Sort chooseSort(int choice) {
        // Use a switch statement to handle multiple sorting algorithm choices based on the integer 'choice'.
        switch (choice) {
            case 1:
                // If the choice is 1, instantiate and return a new BubbleSort object.
                return new BubbleSort();
            case 2:
                // If the choice is 2, instantiate and return a new HeapSort object.
                return new HeapSort();
            case 3:
                // If the choice is 3, instantiate and return a new InsertionSort object.
                return new InsertionSort();
            case 4:
                // If the choice is 4, instantiate and return a new MergeSort object.
                return new MergeSort();
            case 5:
                // If the choice is 5, instantiate and return a new QuickSort object.
                return new QuickSort();
            case 6:
                // If the choice is 6, instantiate and return a new SelectionSort object.
                return new SelectionSort();
            default:
                // If the choice does not match any known sorting algorithm, return null.
                return null;
        }
    }


    // Method to print the list of clothing items from the stack.
    private void printClothingList() {
        // Check if the stack is empty before attempting to print.
        if (clothingStack.isEmpty()) {
            System.out.println("The clothing stack is currently empty.");
            return; // Exit the method early if there are no items to display.
        }

        // Create a temporary stack to hold items while printing to preserve the order in the original stack.
        ArrayStack<Clothing> tempStack = new ArrayStack<>(300);
        System.out.println("\nList of Clothing Items:");

        // Flag to help print items in pairs on each line.
        boolean isPair = false;

        // Loop until all items are removed from the original stack.
        while (!clothingStack.isEmpty()) {
            Clothing clothing = (Clothing) clothingStack.pop(); // Pop the top item from the stack.
            tempStack.push(clothing); // Push the item to the temporary stack to preserve order.

            // Check if it's the first item of a pair.
            if (!isPair) {
                System.out.printf("%-50s", clothing);  // Print the first item and wait for the second.
                isPair = true;  // Set flag indicating the first item of a pair has been printed.
            } else {
                System.out.printf("\t\t%-50s\n", clothing);  // Print the second item and move to the next line.
                isPair = false; // Reset flag after printing both items in a pair.
            }
        }

        // If there was an odd number of items, move to a new line after printing the last item.
        if (isPair) {
            System.out.println();
        }

        // Restore items to the original stack from the temporary stack to maintain the original order.
        while (!tempStack.isEmpty()) {
            clothingStack.push(tempStack.pop()); // Move items back to the original stack.
        }
    }



    private void performSearching() {
        Scanner scanner = new Scanner(System.in);
        boolean found = false;
        
        while (!found) {
        
        System.out.println("Enter the ID of the clothing item to search for:");
        int id = scanner.nextInt();

        // Prepare an array from the stack for searching
        Clothing[] clothingArray = new Clothing[clothingStack.size()];
        int idx = 0;
        while (!clothingStack.isEmpty()) {
            clothingArray[idx++] = (Clothing) clothingStack.pop();
        }

        // Memory and time measurements
        Runtime runtime = Runtime.getRuntime();
        long startTime, endTime;
        long memoryBefore, memoryAfter;



        // Results
        System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");

        // Linear Search
        runtime.gc();
        memoryBefore = runtime.freeMemory();
        startTime = System.nanoTime();
        int linearSearchResult = LinearSearch.linearSearch(clothingArray, id);
        endTime = System.nanoTime();
        memoryAfter = runtime.freeMemory();
        
        
        
     // Re-push items to the stack to maintain original order
        for (Clothing clothing : clothingArray) {
            clothingStack.push(clothing);
        }

        if (linearSearchResult == -1) {
            System.out.println("The ID is not in the stock. Try again.");
        } else {
        
        
        System.out.println ( "" );
        System.out.println("Linear search result: " + (linearSearchResult == -1 ? "Not Found" : "Found in " + linearSearchResult + " iterations"));
        System.out.println("Linear search took " + (endTime - startTime) + " nanoseconds.");
        System.out.println("Linear search memory usage: " + (memoryBefore - memoryAfter) + " bytes");
        found = true;  // Exit the loop if the item is found
        }
        // Binary Search
        Arrays.sort(clothingArray, (c1, c2) -> Integer.compare(c1.getId(), c2.getId()));
        runtime.gc();
        memoryBefore = runtime.freeMemory();
        startTime = System.nanoTime();
        int binarySearchResult = BinarySearch.binarySearch(clothingArray, 0, clothingArray.length - 1, id);
        endTime = System.nanoTime();
        memoryAfter = runtime.freeMemory();
        System.out.println ( "" );
        System.out.println("Binary search result: " + (binarySearchResult == -1 ? "Not Found" : "Found in " + binarySearchResult + " iterations"));
        System.out.println("Binary search took " + (endTime - startTime) + " nanoseconds.");
        System.out.println("Binary search memory usage: " + (memoryBefore - memoryAfter) + " bytes");

        // Hash Table Search
        HashMap <Integer, Clothing> clothingMap = HMap.createClothingMap ( clothingArray );
        runtime.gc();
        memoryBefore = runtime.freeMemory();
        startTime = System.nanoTime();
        int hashSearchResult = HMap.hashTableSearch(clothingMap, id);
        endTime = System.nanoTime();
        memoryAfter = runtime.freeMemory();
        System.out.println ( "" );
        System.out.println("Hash table search result: " + (hashSearchResult == -1 ? "Not Found" : "Found in " + hashSearchResult + " iterations"));
        System.out.println("Hash table search took " + (endTime - startTime) + " nanoseconds.");
        System.out.println("Hash table search memory usage: " + (memoryBefore - memoryAfter) + " bytes");

        System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");


    }}


    // Method to add new clothing data to the stack. This involves user interaction to enter clothing details.
    private void addData() {
        // Create a Scanner object to read input from the console.
        Scanner scanner = new Scanner(System.in);
        int id = 0;  // Initialize a variable to store the clothing ID.
        boolean valid = false;  // Flag to check the validity of the entered ID.

        // Loop until a valid integer is entered for the ID.
        while (!valid) {
            System.out.println("Enter Clothing ID (must be an integer):");  // Prompt user to enter an ID.
            String input = scanner.nextLine();  // Read the full line of input to handle integers correctly.
            try {
                id = Integer.parseInt(input);  // Try to convert the input string to an integer.
                valid = true;  // Set the flag to true if the conversion is successful, indicating a valid integer has been entered.
            } catch (NumberFormatException e) {
                // Handle the case where the input is not a valid integer.
                System.out.println("Incorrect ID format. Please enter a valid integer.");
            }
        }

        System.out.println("Enter Description:");  // Prompt user to enter a description for the clothing.
        String description = scanner.nextLine();  // Read the description from the user input.
        Clothing clothing = new Clothing(id, description);  // Create a new Clothing object with the provided ID and description.
        clothingStack.push(clothing);  // Push the newly created clothing item onto the stack.
        System.out.println("Data added successfully.");  // Confirm to the user that the data was added successfully.
    }



    // Method to delete a clothing item from the stack based on the user-provided ID.
    private void deleteData() {
        // Check if the stack is empty before attempting to delete any item.
        if (clothingStack.isEmpty()) {
            System.out.println("No data to delete.");  // Inform the user that there are no items to delete.
            return;  // Exit the method early as there is nothing to delete.
        }

        // Create a Scanner object to read input from the user.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Clothing ID to delete:");  // Prompt the user to enter the ID of the clothing item they want to delete.
        int id = scanner.nextInt();  // Read the integer ID input from the user.

        // Temporary stack to hold items temporarily while searching for the item to delete.
        ArrayStack<Clothing> tempStack = new ArrayStack<>(300);
        boolean found = false;  // Flag to indicate whether the item was found.

        // Loop through all items in the clothing stack.
        while (!clothingStack.isEmpty()) {
            Clothing clothing = (Clothing) clothingStack.pop();  // Pop each item from the stack for checking.

            if (clothing.getId() != id) {
                tempStack.push(clothing);  // If the item is not the one to be deleted, push it to the temporary stack.
            } else {
                found = true;  // If the item is the one to be deleted, set the flag to true and do not push it back.
            }
        }

        // Restore the items from the temporary stack back to the main stack, excluding the deleted item.
        while (!tempStack.isEmpty()) {
            clothingStack.push(tempStack.pop());  // Pop each item from the temporary stack and push it back to the main stack.
        }

        // Inform the user of the result.
        if (found) {
            System.out.println("Item deleted successfully.");  // If the item was found and deleted, inform the user.
        } else {
            System.out.println("Item not found.");  // If the item was not found, inform the user.
        }
    }



    private void updateData ( ) {
        if ( clothingStack.isEmpty ( ) ) {
            System.out.println ( "No data to update." );
            return;
        }
        Scanner scanner = new Scanner ( System.in );
        System.out.println ( "Enter Clothing ID to update:" );
        int id = scanner.nextInt ( );
        scanner.nextLine ( ); // Consume newline
        ArrayStack tempStack = new ArrayStack ( 300 );
        boolean    found     = false;
        while ( ! clothingStack.isEmpty ( ) ) {
            Clothing clothing = ( Clothing ) clothingStack.pop ( );
            if ( clothing.getId ( ) == id ) {
                System.out.println ( "Enter new description:" );
                String newDescription = scanner.nextLine ( );
                clothing.setDescription ( newDescription );
                found = true;
            }
            tempStack.push ( clothing );
        }
        // Restore items back to main stack
        while ( ! tempStack.isEmpty ( ) ) {
            clothingStack.push ( tempStack.pop ( ) );
        }
        if ( found ) {
            System.out.println ( "Item updated successfully." );
        }
        else {
            System.out.println ( "Item not found." );
        }
    }


    private void restoreData() {
        // Empty the stack first
        while (!clothingStack.isEmpty()) {
            clothingStack.pop();
        }

        // Read data from file and re-populate the stack
        File file = new File("Clothing_Stock.txt");
        try {
            Scanner fileScanner = new Scanner(file);
            fileScanner.nextLine(); // Skip header
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\t");
                if (parts.length >= 2) {
                    int id = Integer.parseInt(parts[0]);
                    String description = parts[1];
                    Clothing clothing = new Clothing(id, description);
                    clothingStack.push(clothing); // Push to stack
                }
            }
            fileScanner.close();

            // Now the stack is restored to initial state, print it out
            printClothingList();

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Invalid data format in the file.");
            e.printStackTrace();
        }
    }


    private void analyzeData ( ) {
        // The size of the stack is the count of clothing items.
        int count = clothingStack.size ( );
        System.out.println("Total number of clothing items in stock: " + count);

    }
}
