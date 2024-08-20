/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/27/2024
//Program Name: BoundedQueueInterface.java
/////////////////////////////////////////////////////////////////////
package lab07.queues;
public interface BoundedQueueInterface<T> extends QueueInterface<T>

{
	void enqueue(T element) throws QueueOverflowException;
	// Throws QueueOverflowException if this queue is full;
	// otherwise, adds element to the rear of this queue.

	boolean isFull();
	// Returns true if this queue is full; otherwise, returns false.
}
