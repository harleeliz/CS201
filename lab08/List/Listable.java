/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/03/2024
//Program Name: Listable.java
/////////////////////////////////////////////////////////////////////

package lab08.List;

public interface Listable
// Objects of classes that implement this interface can be used with lists
{
	// Compares this Listable object to "other". If they are equal, 0 is returned.
	// If this is less than the argument, a negative value is returned.
	// If this is more than the argument, a positive value is returned.
	int compareTo(Listable other);

	// Returns a new object with the same contents as this Listable object.
	Listable copy();

	void printList();
}
