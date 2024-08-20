/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     03/13/2024
//Program Name: Employee.java
/////////////////////////////////////////////////////////////////////

package lab06;

class Employee {
	private long id; // Private variable to store employee ID
	private String name; // Private variable to store employee name

	// Constructor Employee: Initializes an Employee object with the given ID and
	// name
	public Employee(long id, String name) {
		this.id = id; // Set the ID
		this.name = name; // Set the name
	}

	// Getter method: for retrieving the employee ID
	public long getId() {
		return id;
	}

	// Setter method: for updating the employee ID
	public void setId(long id) {
		this.id = id;
	}

	// Getter method: for retrieving the employee name
	public String getName() {
		return name;
	}

	// Setter method: for updating the employee name
	public void setName(String name) {
		this.name = name;
	}

	// Override the toString method to provide a string representation of the class
	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name;
	}
}