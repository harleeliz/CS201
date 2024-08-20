/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/27/2024
//Program Name: Stack.java
/////////////////////////////////////////////////////////////////////
package lab07.stacks;
//Generic Stack class
class Stack<T> {
 private T[] stackArray; // Array to store objects of type T
 private int top; // Variable top to represent the index of the top element in the stack
 private int capacity; // Capacity of the stack

 // Constructor method: Initializes the stack with a given capacity
 @SuppressWarnings("unchecked")
public Stack(int capacity) {
     this.capacity = capacity;
     stackArray = ((T[]) new Object[capacity]); // Create an array of objects of type T
     top = -1; // Initialize top to -1 (indicating an empty stack)
 }

 // Push method: adds an object onto the stack
 public void push(T obj) {
     if (top < capacity - 1) { // Check if the stack is not full
         stackArray[++top] = obj; // Increment top and add the object to the stack
     } else {
         System.out.println("*Error. Stack is full. Cannot push."); // Print message if the stack is full
     }
 }

 // Pop method: removes an object from the top of the stack
 public T pop() {
     if (top >= 0) { // Check if the stack is not empty
         return stackArray[top--]; // Return the top object and decrement top
     } else {
         System.out.println("*Error. Stack is empty. Cannot pop."); // Print message if the stack is empty
         return null;
     }
 }

 // Peek method: returns the object at the top of the stack without removing it
 public T peek() {
     if (top >= 0) { // Check if the stack is not empty
         return stackArray[top]; // Return the top object
     } else {
         System.out.println("Stack is empty."); // Print message if the stack is empty
         return null;
     }
 }
}
