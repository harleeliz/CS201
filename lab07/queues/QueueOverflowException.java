/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/27/2024
//Program Name: QueueOverflowException.java
/////////////////////////////////////////////////////////////////////


package lab07.queues;

// This class represents an exception that is thrown when an operation is performed on a full queue.
// It extends RuntimeException.

@SuppressWarnings("serial")
public class QueueOverflowException extends RuntimeException {
    // Constructor for the QueueOverflowException class.
    // It takes a message as a parameter, which is the detail message of the exception.
    public QueueOverflowException(String message) {
        // Call the superclass constructor (RuntimeException) with the provided message.
        super(message);
    }
}

