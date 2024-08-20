/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/27/2024
//Program Name: StackUnderflowException.java
/////////////////////////////////////////////////////////////////////
package lab07.stacks;
@SuppressWarnings("serial")
public class StackUnderflowException extends RuntimeException {

  /*Default constructor for StackUnderflowException.
   * Creates a new exception object without a specific message.*/
  public StackUnderflowException() {
    super(); // Call the superclass constructor without arguments
  }

  /*Constructor for StackUnderflowException with a custom message.
   * @param message a specific message describing the exception*/
  public StackUnderflowException(String message) {
    super(message); // Call the superclass constructor with the provided message
  }
}
