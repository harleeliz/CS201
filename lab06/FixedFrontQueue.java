/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     03/13/2024
//Program Name: FixedFrontQueue.java
/////////////////////////////////////////////////////////////////////
package lab06;

// This class implements a Queue using a fixed front approach.
public class FixedFrontQueue<T> implements Queue<T> {
	// Array to store the elements in the queue.
	private T[] queue;
	// Index of the last element in the queue (also known as the rear of the queue).
	private int rear = -1;
	// Maximum number of elements that can be stored in the queue.
	private final int capacity;

	// Constructor for the FixedFrontQueue class.
	@SuppressWarnings("unchecked")
	public FixedFrontQueue(int capacity) {
		// Set the capacity of the queue.
		this.capacity = capacity;
		// Initialize the queue array with the specified capacity.
		this.queue = (T[]) new Object[capacity];
	}

	// Method to add an element to the rear of the queue.
	public void enqueue(T element) throws QueueOverflowException {
		// If the queue is full, throw a QueueOverflowException.
		if (isFull()) {
			throw new QueueOverflowException("Queue is full");
		}
		// Add the element to the rear of the queue and increment the rear index.
		queue[++rear] = element;
	}

	// T dequeue: Method to remove an element from the front of the queue.
	public T dequeue() throws QueueUnderflowException {
		// If the queue is empty, throw a QueueUnderflowException.
		if (isEmpty()) {
			throw new QueueUnderflowException("Queue is empty");
		}
		// Store the front element of the queue.
		T element = queue[0];
		// Shift all the elements in the queue to the front.
		for (int i = 0; i < rear; i++) {
			queue[i] = queue[i + 1];
		}
		// Set the last element of the queue to null.
		queue[rear] = null;
		// Decrement the rear index.
		rear--;
		// Return the front element that was removed.
		return element;
	}
	
	
	

	// isEmpty: Method to check if the queue is empty.
	public boolean isEmpty() {
		// The queue is empty if the rear index is -1.
		return rear == -1;
	}

	// isFUll: Method to check if the queue is full.
	public boolean isFull() {
		// The queue is full if the rear index is equal to the capacity minus 1.
		return rear == capacity - 1;
	}
}
