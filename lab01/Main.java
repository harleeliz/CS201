/////////////////////////////////////////////////////////////////////
// CS 401 Introduction to Advanced Studies I
// Student:      Harlee Liz Ramos
// Due date:     01/24/2024
// Program Name: Main.java
/////////////////////////////////////////////////////////////////////

package Laboratory1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create a Scanner instance variable to get user input
        Scanner userInputText = new Scanner(System.in);

        // These lines represent print instructions for the user
        System.out.println("This program will calculate the area of a circle");
        System.out.println();
        System.out.println("Circle area calculator");
        System.out.print("* Enter the radius of a circle: ");

        // Get the radius input from the user
        double radiusInputValue = userInputText.nextDouble();

        // Create a Circle instance variable with the user-provided radius
        Circle operation1 = new Circle(radiusInputValue);

        /*In this print the method toString of the class Circle is being implemented,
         then the final value will display the return value of the toString method.*/
        System.out.print(operation1.toString());
      
    }
}
