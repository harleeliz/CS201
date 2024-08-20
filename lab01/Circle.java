/////////////////////////////////////////////////////////////////////
// CS 401 Introduction to Advanced Studies I
// Student:      Harlee Liz Ramos
// Due date:     01/24/2024
// Program Name: Circle.java
/////////////////////////////////////////////////////////////////////

package Laboratory1;
/* The circle class represents the shape circle
 */
//and provides methods for radius manipulation and area calculation
public class Circle {
	
	
 // Global variable declaration
 private double radius;
	
 // Overloaded constructor
 public Circle(double radius) {
     setRadius(radius);
 }

 // Getter for the radius --> get the value of the radius
 public double getRadius() {
     return radius;
 }

 // Setter for the radius --> set the value of the radius
 public void setRadius(double radius) {
     this.radius = radius;
 }

 // Worker method to perform the calculation of the area
 public double calculateArea() {
     // This line initializes and declares a double area variable that will store the value of the operation
     double area = Math.PI * Math.pow(radius, 2);
     // Return the calculated area
     return area;
 }

 @Override
 /* The method toString is a representation of the Circle class
  * This method returns instructions to the user, then displays the input value provided by the user.
  * This method implements the formatting for String with a precision of 2-digits numbers.
  * Lastly the method calls the worker method calculateAre() in order to display the resultant value of the area formula. */
 public String toString() {
     return "The area of the circle with radius "
     		+ String.format("%.2f",getRadius())
     		+ " is: "+ String.format("%.2f",calculateArea()); 
 }
}
