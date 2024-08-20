/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/27/2024
//Program Name: ArrayBoundedQueue.java
/////////////////////////////////////////////////////////////////////
package lab07.queues;
public class ArrayBoundedQueue<T> implements BoundedQueueInterface<T> {
	protected final int DEFCAP = 100; // Default capacity for the queue if no size is specified.
	protected T[] queue; // Array to hold the elements of the queue.
	protected int numElements = 0; // Number of elements currently in the queue.
	protected int front = 0; // Index of the front element in the queue.
	protected int rear; // Index of the rear element in the queue.

	/* Default constructor ArrayBoundedQueue
	 * creates a queue with the default capacity. */
	public ArrayBoundedQueue() {
		queue = (T[]) new Object[DEFCAP]; // Initialize queue with default capacity
		rear = DEFCAP - 1; // Set rear to the last index of the empty queue
	}

	/*Constructor that creates a queue with a specified maximum size.
	 * @param maxSize the maximum size of the queue */
	public ArrayBoundedQueue(int maxSize) {
		queue = (T[]) new Object[maxSize]; // Initialize queue with specified size
		rear = maxSize - 1; // Set rear to the last index of the empty queue
	}

	/* Transformer method T dequeue Adds an element to the rear of the queue.
	 * @param element the element to add
	 * @throws QueueOverflowException if the queue is full */
	public void enqueue(T element) {
		if (isFull()) {
			throw new QueueOverflowException("Enqueue attempted on a full queue.");
		} else {
			rear = (rear + 1) % queue.length; // Calculate new rear index using circular array
			queue[rear] = element; // Add element to the rear
			numElements = numElements + 1; // Increment the element count
		}
	}

	/* Transformer method T dequeue
	 * Removes and returns the element at the front of the queue.
	 * @return the element at the front of the queue
	 * @throws QueueUnderflowException if the queue is empty */
	public T dequeue() {
		if (isEmpty()) {
			throw new QueueUnderflowException("Dequeue attempted on empty queue.");
		} else {
			T toReturn = queue[front]; // Store the front element
			queue[front] = null; // Remove the front element
			front = (front + 1) % queue.length; // Calculate new front index using circular array
			numElements = numElements - 1; // Decrement the element count
			return toReturn; // Return the removed element
		}
	}

	/* Observer method isEmpty
	 * Checks if the queue is empty.
	 * @return true if the queue is empty, false otherwise */
	public boolean isEmpty() {
		return (numElements == 0); // No elements in the queue
	}

	/*Observer method isFull
	 * Checks if the queue is full.
	 * @return true if the queue is full, false otherwise */
	public boolean isFull() {
		return (numElements == queue.length); // Queue has reached its maximum capacity
	}
}
