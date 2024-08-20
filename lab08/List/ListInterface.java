/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/03/2024
//Program Name: ListInterface.java
/////////////////////////////////////////////////////////////////////

package lab08.List;

import lab08.collections.CollectionInterface;
import lab08.support.Employee;

public interface ListInterface<T> extends Iterable<T>, CollectionInterface<T> {
	boolean isFull();
	// Effect: Determines whether this list is full.
	// Postcondition: Return value = (this list is full)

	int lengthIs();
	// Effect: Determines the number of elements on this list.
	// Postcondition: Return value = number of elements on this list

	boolean isThere(Listable item);
	// Effect: Determines if element matching item is on this list.
	// Postcondition: Return value = (element with the same key as item is on this
	// list)

	Listable retrieve(Listable item);
	// Effect: Returns a copy of the list element with the same key as item.
	// Preconditions: Item is on this list.
	// Postcondition: Return value = (list element that matches item)

	void insert(Listable item);
	// Effect: Adds a copy of item to this list.
	// Preconditions: This list is not full.
	// Element matching item is not on this list.
	// Postcondition: Copy of item is on this list.

	void delete(long idToDelete);
	// Effect: Deletes the element of this list whose key matches item's key.
	// Preconditions: One and only one element on list has a key matching item's
	// key.
	// Postcondition: No element on list has a key matching the argument item's key.

	void reset();
	// Effect: Initializes current position for an iteration through this list.
	// Postcondition: Current position is first element on this list.

	Listable getNextItem();
	// Effect: Returns a copy of the element at the current position on this list
	// and advances the value of the current position
	// Preconditions: Current position is defined.
	// There exists a list element at current position.
	// No list transformers called since most recent call to reset.
	// Postconditions: Return value = (a copy of element at current position)
	// If current position is the last element then current position is
	// set to the beginning of this list, otherwise it is updated to
	// the next position.

	void printList();

	void set(int i, Employee employee);
}
