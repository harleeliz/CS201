/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/27/2024
//Program Name: Part2.java
/////////////////////////////////////////////////////////////////////

package lab07;

public class Part2 {

	public static void main(String[] args) {
		// Array of infix expressions to be evaluated
		String[] infixExpressions = { "1+9*3", "9+6-3*2+5", "5+2-8/2+6-7+6*3" };

		// Loop through each infix expression
		for (String infix : infixExpressions) {
			// Convert infix expression to postfix expression
			String postfix = InfixToPostfixEvaluator.infixToPostfix(infix);

			// Print the infix expression
			System.out.println("Infix: " + infix);

			// Print the converted postfix expression
			System.out.println("Postfix: " + postfix);

			// Evaluate the postfix expression
			int evaluation = InfixToPostfixEvaluator.evaluatePostfix(postfix);

			// Print the result of the evaluation
			System.out.println("Evaluation: " + evaluation);

			// Add an empty line for better readability between expressions
			System.out.println();
		}
	}
}
