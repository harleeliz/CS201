/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     03/13/2024
//Program Name: FloatingFrontQueue.java
/////////////////////////////////////////////////////////////////////

package lab06;

// This class implements a Queue using a floating front approach.
public class FloatingFrontQueue<T> implements Queue<T> {
	// Array to store the elements in the queue.
	private T[] queue;
	// Index of the first element in the queue (also known as the front of the
	// queue).
	private int front = 0;
	// Index of the last element in the queue (also known as the rear of the queue).
	private int rear = -1;
	// The number of elements currently in the queue.
	private int size = 0;
	// Maximum number of elements that can be stored in the queue.
	private final int capacity;

	// Constructor for the FloatingFrontQueue class.
	@SuppressWarnings("unchecked")
	public FloatingFrontQueue(int capacity) {
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
		// Calculate the new rear index and add the element to the rear of the queue.
		rear = (rear + 1) % capacity;
		queue[rear] = element;
		// Increment the size of the queue.
		size++;
	}

	// Method to remove an element from the front of the queue.
	public T dequeue() throws QueueUnderflowException {
		// If the queue is empty, throw a QueueUnderflowException.
		if (isEmpty()) {
			throw new QueueUnderflowException("Queue is empty");
		}
		// Store the front element of the queue.
		T element = queue[front];
		// Set the front element of the queue to null.
		queue[front] = null;
		// Calculate the new front index.
		front = (front + 1) % capacity;
		// Decrement the size of the queue.
		size--;
		// Return the front element that was removed.
		return element;
	}

	
	
	
	
	// Method to check if the queue is empty.
	public boolean isEmpty() {
		// The queue is empty if the size is 0.
		return size == 0;
	}

	// Method to check if the queue is full.
	public boolean isFull() {
		// The queue is full if the size is equal to the capacity.
		return size == capacity;
	}
}
