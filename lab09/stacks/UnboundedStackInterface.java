/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/10/2024
//Program Name: UnboundedStackInterface.java
/////////////////////////////////////////////////////////////////////
package lab09.stacks;
public interface UnboundedStackInterface<T> extends StackInterface<T>

{
  void push(T element);
  // Places element at the top of this stack.

}
