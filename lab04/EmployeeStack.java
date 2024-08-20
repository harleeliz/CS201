/////////////////////////////////////////////////////////////////////
// CS 401 Introduction to Advanced Studies I
// Student:      Harlee Liz Ramos
// Due date:     02/14/2024
//Program Name: EmployeeStack.java
/////////////////////////////////////////////////////////////////////

package lab04;

//Stack class EmployeeStack
class EmployeeStack {
    private Employee[] stackArray; // Array to store employee objects
    
    private int top; // Variable top to represent the index of the top element in the stack
    

    // Constructor method: Initializes the stack with a given capacity
    public EmployeeStack(int capacity) {
        stackArray = new Employee[capacity]; // Create an array of Employee objects
        top = -1; // Initialize top to -1 (indicating an empty stack)
    }

    
    // Push method: adds an employee onto the stack
    public void push(Employee employee) {
        if (top < stackArray.length - 1) { //logic statement to check if the top is less than the length of the array
            stackArray[++top] = employee; // Increment top and add the employee to the stack
        } else {
            System.out.println("*Error. Stack is full. Cannot push."); // Print message to display an error message if the stack is full
        }
    }

    // Pop method: removes an employee from the top of the stack
    public Employee pop() {
        if (top >= 0) { //Logical statement to check if the stack it's not empty
            return stackArray[top--]; // Return the top employee and decrement top
        } else {
            System.out.println("*Error. Stack is empty. Cannot pop."); // Display an error message if the stack is empty
            return null;
        }
    }

    // Peek me at the top employee without removing them from the stack
    public Employee peek() {
        if (top >= 0) { //Logical statement to check if the stack it's not empty
            return stackArray[top]; // Return the top employee
        } else {
            System.out.println("Stack is empty."); // Display a message if the stack is empty
            return null;
        }
    }
}
