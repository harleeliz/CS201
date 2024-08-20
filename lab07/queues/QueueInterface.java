/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/27/2024
//Program Name: QueueInterface.java
/////////////////////////////////////////////////////////////////////


package lab07.queues;

public interface QueueInterface<T>

{
  T dequeue() throws QueueUnderflowException;
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.

  boolean isEmpty();
  // Returns true if this queue is empty; otherwise, returns false.

void enqueue(T element);
}




