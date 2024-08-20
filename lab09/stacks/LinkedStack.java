/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/10/2024 
//Program Name: LinkedStack.java
/////////////////////////////////////////////////////////////////////
package lab09.stacks;
import lab09.support.LLNode;

public class LinkedStack<T> implements UnboundedStackInterface<T> {
	protected LLNode<T> top; // reference to the top of this stack

	public LinkedStack() {
		top = null;
	}

	public void push(T element)
	// Places element at the top of this stack.
	{
		LLNode<T> newNode = new LLNode<T>(element); // Create a new node with the provided element.
		newNode.setLink(top); // Set the link of the new node to the current top of the stack.
		top = newNode; // Update the top reference to point to the newly added node.
	}

	public void pop()
	// Throws StackUnderflowException if this stack is empty,
	// otherwise removes top element from this stack.
	{
		if (!isEmpty()) // Check if the stack is not empty.
		{
			top = top.getLink(); // Move the top reference to the next node in the stack.
		} else
			throw new StackUnderflowException("Pop attempted on an empty stack."); // Throw exception if pop is
																					// attempted on an empty stack.
	}

	public T top()
	// Throws StackUnderflowException if this stack is empty,
	// otherwise returns top element from this stack.
	{
		if (!isEmpty()) // Check if the stack is not empty.
			return top.getInfo(); // Return the element stored in the top node.
		else
			throw new StackUnderflowException("Top attempted on an empty stack."); // Throw exception if top is
																					// attempted on an empty stack.
	}

	public boolean isEmpty()
	// Returns true if this stack is empty, otherwise returns false.
	{
		if (top == null) // Check if the top reference is null, indicating an empty stack.
			return true; // Return true if the stack is empty.
		else
			return false; // Return false if the stack is not empty.
	}
}
