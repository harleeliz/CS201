/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/03/2024
//Program Name: LinkedList.java
/////////////////////////////////////////////////////////////////////

package lab08.List;

import java.util.Iterator;
import lab08.support.Employee;
import lab08.support.LLNode;

//Public class providing a basic implementation of a linked list.
public class LinkedList<T> implements ListInterface<T> {
	protected LLNode<T> front; // reference to the front of this list
	protected LLNode<T> rear; // reference to the rear of this list
	protected int numElements = 0; // number of elements in this list

// Variables used by find method
	protected boolean found; // true if target found, else false
	protected int targetIndex; // list index of target, if found
	protected LLNode<T> location; // node containing target, if found
	protected LLNode<T> previous; // node preceding location

// Constructor initializing the list.
	public LinkedList() {
		numElements = 0;
		front = null;
		rear = null;
	}

// Adds element to the end of this list.
	public boolean add(T element) {
		LLNode<T> newNode = new LLNode<T>(element);
		if (rear == null)
			front = newNode;
		else
			rear.setLink(newNode);
		rear = newNode;
		numElements++;
		return true;
	}

// Searches list for an occurrence of an element that equals target.
	protected void find(T target) {
		location = front;
		found = false;
		targetIndex = -1;

		while (location != null) {
			targetIndex++;
			if (location.getInfo().equals(target)) // if they match
			{
				found = true;
				return;
			} else {
				previous = location;
				location = location.getLink();
			}
		}
	}

// Returns the number of elements on this list.
	public int size() {
		return numElements;
	}

// Returns true if this list contains an element that equals target.
	public boolean contains(T target) {
		find(target);
		return found;
	}

// Removes an element from this list that equals target.
	public boolean remove(T target) {
		find(target);
		if (found) {
			if (front == location)
				front = front.getLink(); // remove first node
			else
				previous.setLink(location.getLink()); // remove node at location

			if (front == null)
				rear = null; // removed only element

			numElements--;
		}
		return found;
	}

// Returns an element from this list that equals target.
	public T get(T target) {
		find(target);
		if (found)
			return location.getInfo();
		else
			return null;
	}

// Returns true if this list is empty.
	public boolean isEmpty() {
		return (numElements == 0);
	}

// Returns false (list is unbounded).
	public boolean isFull() {
		return false;
	}

// Throws IndexOutOfBoundsException if passed an invalid index.
// Otherwise, adds element to this list at position index.
	public void add(int index, T element) {
		if ((index < 0) || (index > size()))
			throw new IndexOutOfBoundsException("Illegal index passed to LinkedList add method.\n");

		LLNode<T> newNode = new LLNode<T>(element);

		if (index == 0) // add to front
		{
			if (front == null) // adding to empty list
			{
				front = newNode;
				rear = newNode;
			} else {
				newNode.setLink(front);
				front = newNode;
			}
		} else if (index == size()) // add to rear
		{
			rear.setLink(newNode);
			rear = newNode;
		} else // add in interior part of list
		{
			LLNode<T> node = front;
			for (int i = 0; i < (index - 1); i++)
				node = node.getLink();
			newNode.setLink(node.getLink());
			node.setLink(newNode);
		}
		numElements++;
	}

// Throws IndexOutOfBoundsException if passed an invalid index.
// Otherwise, replaces element at position index with newElement.
	public T set(int index, T newElement) {
		if ((index < 0) || (index >= size()))
			throw new IndexOutOfBoundsException("Illegal index passed to LinkedList set method.\n");

		LLNode<T> node = front;
		for (int i = 0; i < index; i++)
			node = node.getLink();
		T hold = node.getInfo();
		node.setInfo(newElement);
		return hold;
	}

// Throws IndexOutOfBoundsException if passed an invalid index.
// Otherwise, returns the element at position index.
	public T get(int index) {
		if ((index < 0) || (index >= size()))
			throw new IndexOutOfBoundsException("Illegal index passed to LinkedList set method.\n");

		LLNode<T> node = front;
		for (int i = 0; i < index; i++)
			node = node.getLink();
		return node.getInfo();
	}

// If this list contains an element that equals target, returns its index.
// Otherwise, returns -1.
	public int indexOf(T target) {
		find(target);
		if (found)
			return targetIndex;
		else
			return -1;
	}

// Throws IndexOutOfBoundsException if passed an invalid index.
// Otherwise, removes element at position index and returns it.
	public T remove(int index) {
		if ((index < 0) || (index >= size()))
			throw new IndexOutOfBoundsException("Illegal index passed to LinkedList remove method.\n");

		T hold; // holds info for return
		if (index == 0) // remove the front node
		{
			hold = front.getInfo();
			front = front.getLink();
			if (numElements == 1) // removing only node
				rear = null;
		} else {
			// locate previous node
			LLNode<T> node = front;
			for (int i = 0; i < (index - 1); i++)
				node = node.getLink();
			hold = node.getLink().getInfo();
			if (node.getLink() == rear) // removing rear node
				rear = node;
			node.setLink(node.getLink().getLink());
		}

		numElements--;
		return hold;
	}

// Returns an Iterator over this list.
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private LLNode<T> prevPos = null; // node before node just returned
			private LLNode<T> currPos = null; // node just returned
			private LLNode<T> nextPos = front; // next node to return

			// Returns true if the iteration has more elements.
			public boolean hasNext() {
				return (nextPos != null);
			}

			// Returns the next element in the iteration.
			public T next() {
				if (!hasNext())
					throw new IndexOutOfBoundsException("Illegal invocation of next in LinkedList iterator.\n");

				T hold = nextPos.getInfo(); // holds info for return
				if (currPos != null)
					prevPos = currPos; // in case element was removed
				currPos = nextPos;
				nextPos = nextPos.getLink();
				return hold;
			}

			// Removes from the underlying representation the last element returned by this
			// iterator.
			public void remove() {
				if (currPos == null) // there is no last element returned by the iterator
					return;
				else {
					if (prevPos == null) // removing front element
					{
						front = nextPos;
						currPos = null;
						if (front == null) // removed only element
							rear = null;
					} else {
						prevPos.setLink(nextPos);
						currPos = null;
					}
					numElements--;
				}
			}
		};
	}

	public void printList() {
		if (front == null) {
			System.out.println("Empty list.");
			return;
		}

		LLNode<T> current = front;
		while (current != null) {
			System.out.println(current.getInfo());
			current = current.getLink();
		}
	}

	@Override
	public int lengthIs() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isThere(Listable item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Listable retrieve(Listable item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Listable item) {

	}

	public void delete(long id) {
		LLNode<Employee> current = (LLNode<Employee>) front;
		LLNode<Employee> previous = null;

		while (current != null) {
			if (current.getInfo().getId() == id) {
				if (previous == null) {
					// If the node to be deleted is the first node
					front = (LLNode<T>) current.getLink();
					if (front == null) {
						// If the list becomes empty after deletion
						rear = null;
					}
				} else {
					previous.setLink(current.getLink());
					if (current.getLink() == null) {
						// If the node to be deleted is the last node
						rear = (LLNode<T>) previous;
					}
				}
				numElements--;
				return; // Exit the method after deleting the first occurrence of the ID
			}
			previous = current;
			current = current.getLink();
		}
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public Listable getNextItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(long T) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Listable item) {
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
