/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/27/2024
//Program Name: InfixToPostfixEvaluator.java
/////////////////////////////////////////////////////////////////////
package lab07;
import java.util.Stack;
public class InfixToPostfixEvaluator {
	/*Method InfixToPostfixEvaluator Converts an infix expression to a postfix
	 * expression.
	 * @param infix the infix expression to convert
	 * @return the equivalent postfix expression*/
	public static String infixToPostfix(String infix) {
		StringBuilder postfix = new StringBuilder();
		Stack<Character> operatorStack = new Stack<>(); // Stack to hold operators

		for (char c : infix.toCharArray()) {
			if (Character.isDigit(c)) {
				// Append operands directly to the postfix expression
				postfix.append(c);
			} else if (isOperator(c)) {
				// Handle operators using a stack
				while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(c)) {
					postfix.append(operatorStack.pop());
				}
				operatorStack.push(c);
			} else if (c == '(') {
				operatorStack.push(c); // Push opening parenthesis onto the stack
			} else if (c == ')') {
				// Pop operators until opening parenthesis is encountered
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					postfix.append(operatorStack.pop());
				}
				operatorStack.pop(); // Discard the opening parenthesis
			}
		}
		// Append any remaining operators from the stack to the postfix expression
		while (!operatorStack.isEmpty()) {
			postfix.append(operatorStack.pop());
		}
		return postfix.toString();
	}
	
	/*Method evaluatePostfix Evaluates a postfix expression.
	 * @param postfix the postfix expression to evaluate
	 * @return the result of the expression*/
	public static int evaluatePostfix(String postfix) {
		Stack<Integer> operandStack = new Stack<>(); // Stack to hold operands

		for (char c : postfix.toCharArray()) {
			if (Character.isDigit(c)) {
				// Push operands onto the stack
				int digit = Character.getNumericValue(c);
				operandStack.push(digit);
			} else {
				// Perform operations on operands from the stack
				int operand2 = operandStack.pop();
				int operand1 = operandStack.pop();
				int result = performOperation(operand1, operand2, c);
				operandStack.push(result);
			}
		}
		return operandStack.pop(); // Final result is at the top of the stack
	}
	/* Method precedence Returns the precedence of an operator.
	 * @param operator the operator to check
	 * @return the precedence of the operator */
	private static int precedence(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1; // Lower precedence for addition and subtraction
		case '*':
		case '/':
			return 2; // Higher precedence for multiplication and division
		default:
			return -1; // Invalid operator
		}
	}

	/* Method performOperation Performs an arithmetic operation.
	 * @param operand1 the first operand
	 * @param operand2 the second operand
	 * @param operator the operator to perform
	 * @return the result of the operation */
	private static int performOperation(int operand1, int operand2, char operator) {
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			return operand1 / operand2; // Assuming non-zero division
		default:
			throw new IllegalArgumentException("Invalid operator");
		}
	}

	/* Method isOperator Checks if a character is an operator.
	 * @param c the character to check
	 * @return true if the character is an operator, false otherwise */
	private static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}
}
