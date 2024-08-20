/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I - Spring Project 2024
//Student:      Harlee Liz Ramos
//Due date:     04/21/2024
//Program Name: ArrayStack.java
/////////////////////////////////////////////////////////////////////

// Defines the package name which organizes classes into namespaces.
package project;



// Importing the Arrays utility class for array operations such as printing the array content.
import java.util.Arrays;

// ArrayStack class declaration, implementing a generic StackInterface. 
// The <T> notation signifies that this class is generic and can work with any object type.
public class ArrayStack<T> implements StackInterface<T> {
    // Array used to store the stack's elements. It's an Object array to accommodate any type.
    private final Object[] stack;
    // Index of the top element in the stack. It's initialized to -1 to indicate that the stack is empty.
    private int topIndex = -1;

    // Constructor to initialize the stack with a specific maximum size.
    public ArrayStack(int maxSize) {
        // The stack's maximum size is set at construction and cannot be changed later because the array is final.
        stack = new Object[maxSize];
    }

    // Method to add an item to the top of the stack.
    @Override
    public void push(T item) {
        // First, check if the stack is full.
        if (!isFull()) {
            topIndex++; // Increment topIndex to point to the next empty slot.
            stack[topIndex] = item; // Store the item in the array at the position of topIndex.
        } else {
            // If the stack is full, throw an exception to indicate stack overflow.
            throw new StackOverflowException("Push attempted on a full stack.");
        }
    }

    // Method to remove and return the top item of the stack.
    @Override
    public T pop() {
        // Check if the stack is empty.
        if (!isEmpty()) {
            T item = (T) stack[topIndex]; // Retrieve the top item by casting it to type T.
            stack[topIndex] = null; // Clear the reference at topIndex to prevent memory leaks.
            topIndex--; // Decrement topIndex to remove the top element.
            return item; // Return the popped item.
        } else {
            // If the stack is empty, throw an exception to indicate stack underflow.
            throw new StackUnderflowException("Pop attempted on an empty stack.");
        }
    }

    // Method to get the top item of the stack without removing it.
    @Override
    public T top() {
        if (!isEmpty()) {
            return (T) stack[topIndex]; // Return the top item after casting it to type T.
        } else {
            throw new StackUnderflowException("Top attempted on an empty stack.");
        }
    }

    // Method to check if the stack is empty.
    @Override
    public boolean isEmpty() {
        return topIndex == -1; // The stack is empty if topIndex is -1.
    }

    // Method to return the number of items in the stack.
    @Override
    public int size() {
        return topIndex + 1; // Size is topIndex + 1 because topIndex is zero-based.
    }

    // Helper method to check if the stack is full.
    public boolean isFull() {
        return topIndex == (stack.length - 1); // The stack is full if topIndex is at the last position of the array.
    }

    // Method to get the underlying array of the stack. Primarily for internal or testing use.
    public Object[] getStack() {
        return stack;
    }

    // Getter method for topIndex.
    public int getTopIndex() {
        return topIndex;
    }

    // Setter method for topIndex. This allows changing the topIndex, usually for testing or internal adjustments.
    public void setTopIndex(int topIndex) {
        this.topIndex = topIndex;
    }

    // Overridden toString method to provide a string representation of the stack's state.
    @Override
    public String toString() {
        // Utilizes Arrays.toString to format the stack array as a string.
        return "ArrayStack{" + "stack=" + Arrays.toString(stack) + ", topIndex=" + topIndex + '}';
    }
}
