/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/10/2024
//Program Name: Main.java
/////////////////////////////////////////////////////////////////////

package lab09;
import lab09.trees.*;

public class Main {
    public static void main ( String[] args ) {
    	
    	
    	 System.out.println( "This lab is an implementation of differents method of the class BinarySeachTree, using Stacks and Queues" );
    	 
    	 
        // Create a binary search tree of numbers
        BinarySearchTree< Integer > example = new BinarySearchTree< Integer > ( );

        // Add elements to the binary search tree
        example.add ( 25 );
        example.add ( 15 );
        example.add ( 50 );
        example.add ( 10 );
        example.add ( 22 );
        example.add ( 35 );
        example.add ( 70 );
        example.add ( 4 );
        example.add ( 12 );
        example.add ( 18 );
        example.add ( 24 );
        example.add ( 31 );
        example.add ( 44 );
        example.add ( 66 );
        example.add ( 90 );

        // Find maximum depth of the binary search tree
        int maxDepth = BinarySearchTree.findMaxDepth ( example.getRoot ( ) );
        System.out.println ( "Maximum Depth of the Tree: " + maxDepth );

        // Calculate size of the tree recursively and iteratively
        int recursiveSize = example.size ( );
        int iterativeSize = example.size2();
        System.out.println ( "Size of the Tree (Recursive): " + recursiveSize );
        System.out.println("Size of the Tree (Iterative): " + iterativeSize);

        // Print traversal of the tree: In-order, Pre-order, and Post-order
        System.out.print ( "\nInorder:   " );
        BinarySearchTree.printInOrder ( example.getRoot ( ) );
        System.out.print ( "\nPreorder:  " );
        BinarySearchTree.printPreOrder ( example.getRoot ( ) );
        System.out.print ( "\nPostorder: " );
        BinarySearchTree.printPostOrder ( example.getRoot ( ) );
    }
}
