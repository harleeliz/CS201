/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/03/2024
//Program Name: CircularLinkedList.java
/////////////////////////////////////////////////////////////////////

package lab08.List;

import java.util.Iterator;
import lab08.support.Employee;
import lab08.support.LLNode;

// Circular Linked List implementation
public class CircularLinkedList<T> implements ListInterface<T> {
	protected LLNode<T> list; // Reference to the last node on the list
	protected int numElements; // Number of elements in the list
	protected LLNode<T> currentPos; // Pointer to the current position for iteration

	// Variables set by the find method
	protected boolean found; // Indicates if an element is found during search
	protected LLNode<T> location; // Reference to the node containing the found element
	protected LLNode<T> previous; // Reference to the node preceding the found element

	// Constructor to initialize the list
	public CircularLinkedList() {
		numElements = 0;
		list = null; // Initially, the list is empty
		currentPos = null;
	}

	// Add element to the end of the list
	public boolean add(T element) {
		LLNode<T> newNode = new LLNode<T>(element);
		if (list == null) {
			// Adding element to an empty list
			list = newNode;
			newNode.setLink(list); // Since it's a circular list, the new node points to itself
		} else {
			// Adding element to a non-empty list
			newNode.setLink(list.getLink());
			list.setLink(newNode);
			list = newNode; // Updating the reference to the last node
		}
		numElements++;
		return true;
	}

	// Search for an element in the list
	protected void find(T target) {
		location = list;
		found = false;

		if (list != null) {
			do {
				// Move to the next node
				previous = location;
				location = location.getLink();

				// Check for a match
				if (location.getInfo().equals(target))
					found = true;
			} while ((location != list) && !found); // Continue until reaching the end of the list or finding the
													// element
		}
	}

	// Return the number of elements in the list
	public int size() {
		return numElements;
	}

	// Check if the list contains a certain element
	public boolean contains(T element) {
		find(element);
		return found;
	}

	// Remove an element from the list
	public boolean remove(T element) {
		find(element);
		if (found) {
			if (list == list.getLink()) // if single-element list
				list = null;
			else if (previous.getLink() == list) // if removing last node
				list = previous;
			previous.setLink(location.getLink()); // remove node
			numElements--;
		}
		return found;
	}

	// Get an element from the list
	public T get(T element) {
		find(element);
		if (found)
			return location.getInfo();
		else
			return null;
	}

	// Display the elements in the list
	public void display() {
		if (list != null) {
			LLNode<T> currentNode = list.getLink(); // Skip the last node
			while (currentNode != list) {
				System.out.println(currentNode.getInfo().toString());
				currentNode = currentNode.getLink();
			}
		}
	}

	// Delete an element from the list by ID
	public void deleteByID(long id) {
		LLNode<T> currentNode = list;
		boolean deleted = false;
		do {
			if (((Employee) currentNode.getLink().getInfo()).getId() == id) {
				delete(currentNode.getLink().getInfo());
				deleted = true;
				break;
			}
			currentNode = currentNode.getLink();
		} while (currentNode != list);

		if (!deleted) {
			System.out.println("Employee with ID " + id + " not found.");
		}
	}

	@Override
	public Iterator<T> iterator() {
		// Iterator not implemented yet, returns null
		return null;
	}

	public void delete(Listable item) {
		// Delete method not implemented yet
		// Needs to be implemented according to ListInterface
	}

	// Override methods from ListInterface
	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return numElements == 0;
	}

	@Override
	public int lengthIs() {
		return numElements;
	}

	@Override
	public boolean isThere(Listable item) {
		return contains((T) item);
	}

	@Override
	public Listable retrieve(Listable item) {
		return (Listable) get((T) item);
	}

	@Override
	public void insert(Listable item) {
		add((T) item);
	}

	public void delete(T t) {
		remove((T) t);
	}

	@Override
	public void reset() {
		currentPos = list;
	}

	@Override
	public Listable getNextItem() {
		if (currentPos == null) {
			return null;
		} else {
			currentPos = currentPos.getLink();
			return (Listable) currentPos.getInfo();
		}
	}

	@Override
	public T get(long T) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long idToDelete) {
		// TODO Auto-generated method stub

	}

	@Override
	public void set(int i, Employee employee) {
		// TODO Auto-generated method stub

	}

	public void delete(Employee employee) {
		// TODO Auto-generated method stub

	}

}
