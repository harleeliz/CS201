/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I - Spring Project 2024
//Student:      Harlee Liz Ramos
//Due date:     04/21/2024
//Program Name: Clothing.java
/////////////////////////////////////////////////////////////////////



// Defines the package name for organizational purposes, helping to group related classes.
package project;

// Declaration of the Clothing class.
public class Clothing {
    // Private variables to hold the clothing item's ID and description, encapsulating the data.
    private int id;
    private String description;

    // Constructor to initialize a Clothing object with an ID and a description.
    public Clothing(int id, String description) {
        this.id = id;  // Sets the id of this clothing item.
        this.description = description;  // Sets the description of this clothing item.
    }

    // Method to retrieve the ID of the clothing item.
    public int getId() {
        return id;  // Returns the private id field.
    }

    // Method to set or update the ID of the clothing item.
    public void setId(int id) {
        this.id = id;  // Updates the id field with the given value.
    }

    // Method to retrieve the description of the clothing item.
    public String getDescription() {
        return description;  // Returns the private description field.
    }

    // Method to set or update the description of the clothing item.
    public void setDescription(String description) {
        this.description = description;  // Updates the description field with the given value.
    }

    // Override the toString method to provide a string representation of the Clothing object.
    @Override 
    public String toString() {
        // Constructs a string that includes both the id and description of the clothing.
        return "id " + id + ", description '" + description + '\'';
    }
}
