/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/27/2024
//Program Name: BoundedStackInterface.java
/////////////////////////////////////////////////////////////////////
package lab07.stacks;

public interface BoundedStackInterface<T> extends StackInterface<T>

{
  void push(T element) throws StackOverflowException;
  // Throws StackOverflowException if this stack is full,
  // otherwise places element at the top of this stack.

  boolean isFull();
  // Returns true if this stack is full, otherwise returns false.
  
}
