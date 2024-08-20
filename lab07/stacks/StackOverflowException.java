/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/27/2024
//Program Name: StackOverflowException.java
/////////////////////////////////////////////////////////////////////
package lab07.stacks;

@SuppressWarnings("serial")
public class StackOverflowException extends RuntimeException {

  /*Default constructor for StackOverflowException.
   * Creates a new exception object without a specific message.*/
  public StackOverflowException() {
    super(); // Call the superclass constructor without arguments
  }

  /*Constructor for StackOverflowException with a custom message.
   * @param message a specific message describing the exception */
  public StackOverflowException(String message) {
    super(message); // Call the superclass constructor with the provided message
  }
}
