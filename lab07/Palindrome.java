/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/27/2024
//Program Name: Palindrome.java
/////////////////////////////////////////////////////////////////////

package lab07;
import lab07.stacks.ArrayBoundedStack;
import lab07.stacks.StackInterface;
import lab07.queues.ArrayBoundedQueue;
import lab07.queues.QueueInterface;
public class Palindrome {

	/*Method Palindrome Checks if a given string is a palindrome. A palindrome is a
	 * word or phrase that reads the same backward as forward.
	 * @param candidate the string to check for palindrome
	 * @return true if the string is a palindrome, false otherwise*/
	public static boolean test(String candidate) {
		char ch; // Character variable to hold each character in the string
		int length = candidate.length(); // Get the length of the string

		// Variables to hold characters from the stack and queue
		char fromStack;
		char fromQueue;

		// Flag to track if the string is still a potential palindrome
		boolean stillPalindrome = true;

		// Create a stack and a queue to hold characters from the string
		StackInterface<Character> stack = new ArrayBoundedStack<>(length);
		QueueInterface<Character> queue = new ArrayBoundedQueue<>(length);

		// Iterate through the characters in the string
		for (int i = 0; i < length; i++) {
			ch = candidate.charAt(i);

			// Only consider alphanumeric characters (letters and numbers)
			if (Character.isLetter(ch)) {
				// Convert characters to lowercase for case-insensitive comparison
				ch = Character.toLowerCase(ch);

				// Push the character onto the stack and enqueue it in the queue
				stack.push(ch);
				queue.enqueue(ch);
			}
		}

		// Check if the characters match while the stack is not empty and the string
		// might be a palindrome
		while (stillPalindrome && !stack.isEmpty()) {
			// Pop the character from the stack
			fromStack = stack.top();
			stack.pop();

			// Dequeue the character from the queue
			fromQueue = queue.dequeue();

			// If the characters don't match, the string is not a palindrome
			if (fromStack != fromQueue) {
				stillPalindrome = false;
			}
		}
		// Return true if all characters matched, indicating a palindrome
		return stillPalindrome;
	}
}
