/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     03/13/2024
//Program Name: Queue.java
/////////////////////////////////////////////////////////////////////

package lab06;

// This interface defines the operations that a Queue data structure should have.
public interface Queue<T> {
    // Method to add an element to the queue.
    // Throws QueueOverflowException if the operation fails.
    void enqueue(T element) throws QueueOverflowException;

    // Method to remove and return the front element from the queue.
    // Throws QueueUnderflowException if the operation fails.
    T dequeue() throws QueueUnderflowException;

    // Method to check if the queue is empty.
    // Returns true if the queue is empty, false otherwise.
    boolean isEmpty();

    // Method to check if the queue is full.
    // Returns true if the queue is full, false otherwise.
    boolean isFull();
}
