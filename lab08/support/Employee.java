/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Professor:    Michael Yonshik Choi, PhD
//TA:			Tarun Sai Yakkala
//Student:      Harlee Liz Ramos
//Due date:     04/03/2024
//Program Name: Employee.java
/////////////////////////////////////////////////////////////////////
package lab08.support;

import lab08.List.Listable;

public class Employee implements Listable {
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

	// Override the equals method to compare Employee objects by their ID and name
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Employee employee = (Employee) obj;
		return id == employee.id && name.equals(employee.name);
	}

	@Override
	public int compareTo(Listable other) {
		// TODO Auto-generated method stub
		return 0;

	}

	@Override
	public Listable copy() {
		// TODO Auto-generated method stub
		return null;
	}

	// Override the printList method to print the details of the employee
	@Override
	public void printList() {
		System.out.println(toString());
	}
}