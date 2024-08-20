/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I - Spring Project 2024
//Student:      Harlee Liz Ramos
//Due date:     04/21/2024
//Program Name: StackUnderflowException.java
/////////////////////////////////////////////////////////////////////

package project;

public class StackUnderflowException extends RuntimeException {

    /*Default constructor for StackUnderflowException.
     * Creates a new exception object without a specific message.*/
    public StackUnderflowException ( ){
        super ( ); // Call the superclass constructor without arguments
    }

    /*Constructor for StackUnderflowException with a custom message.
     * @param message a specific message describing the exception*/
    public StackUnderflowException ( String message ){
        super ( message ); // Call the superclass constructor with the provided message
    }
}
