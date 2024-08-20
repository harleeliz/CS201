/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/10/2024  
//Program Name: UnboundedQueueInterface.java
/////////////////////////////////////////////////////////////////////
package lab09.queues;

public interface UnboundedQueueInterface<T> extends QueueInterface<T>

{
	void enqueue(T element);
	// Adds element to the rear of this queue.
}
