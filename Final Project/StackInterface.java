/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I - Spring Project 2024
//Student:      Harlee Liz Ramos
//Due date:     04/21/2024
//Program Name: StackInterface.java
/////////////////////////////////////////////////////////////////////


package project;

public interface StackInterface < T > {
    T pop ( ) throws StackUnderflowException;
    // Throws StackUnderflowException if this stack is empty,
    // otherwise removes top element from this stack.

    T top ( ) throws StackUnderflowException;
    // Throws StackUnderflowException if this stack is empty,
    // otherwise returns top element from this stack.

    boolean isEmpty ( );
    // Returns true if this stack is empty, otherwise returns false.

    void push ( T element );

    int size ( );
}
