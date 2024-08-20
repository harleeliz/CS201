/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/03/2024
//Program Name: DoubleLinkedList.java
/////////////////////////////////////////////////////////////////////
package lab08.List;

import lab08.support.DLLNode;

public class DoubleLinkedList<T> {
	// Head and tail nodes of the list
	private DLLNode<T> head;
	private DLLNode<T> tail;
	// Size of the list
	private int size;

	// Constructor initializes an empty list
	public DoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	// Method to add an element to the list
	public void add(T element) {
		DLLNode<T> newNode = new DLLNode<>(element);
		if (head == null) {
			// If list is empty, new node becomes head and tail
			head = newNode;
			tail = newNode;
		} else {
			// Else, add new node to the end of the list
			newNode.setBack(tail);
			tail.setForward(newNode);
			tail = newNode;
		}
		size++;
	}

	// Method to check if an element exists in the list
	public boolean contains(T element) {
		DLLNode<T> current = head;
		while (current != null) {
			if (current.getInfo().equals(element)) {
				return true;
			}
			current = current.getForward();
		}
		return false;
	}

	// Method to remove an element from the list
	public boolean remove(T element) {
		DLLNode<T> current = head;
		while (current != null) {
			if (current.getInfo().equals(element)) {
				if (current == head) {
					// If current node is head, move head to next node
					head = head.getForward();
					if (head != null) {
						head.setBack(null);
					} else {
						tail = null;
					}
				} else if (current == tail) {
					// If current node is tail, move tail to previous node
					tail = tail.getBack();
					if (tail != null) {
						tail.setForward(null);
					} else {
						head = null;
					}
				} else {
					// If current node is in the middle, bypass it
					current.getBack().setForward(current.getForward());
					current.getForward().setBack(current.getBack());
				}
				size--;
				return true;
			}
			current = current.getForward();
		}
		return false;
	}

	// Method to print all elements in the list
	public void printList() {
		DLLNode<T> current = head;
		while (current != null) {
			System.out.println(current.getInfo());
			current = current.getForward();
		}
	}
}
