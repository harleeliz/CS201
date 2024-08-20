/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     03/13/2024
//Program Name: QueueOverflowException.java
/////////////////////////////////////////////////////////////////////

package lab06;

// This class represents an exception that is thrown when an operation is performed on a full queue.
// It extends RuntimeException.
@SuppressWarnings( "serial" )
public class QueueOverflowException extends RuntimeException {
    // Constructor for the QueueOverflowException class.
    // It takes a message as a parameter, which is the detail message of the exception.
    public QueueOverflowException(String message) {
        // Call the superclass constructor (RuntimeException) with the provided message.
        super(message);
    }
}

// This class represents an exception that is thrown when an operation is performed on an empty queue.
// It extends RuntimeException.
@SuppressWarnings("serial")
class QueueUnderflowException extends RuntimeException {
    // Constructor for the QueueUnderflowException class.
    // It takes a message as a parameter, which is the detail message of the exception.
    public QueueUnderflowException(String message) {
        // Call the superclass constructor (RuntimeException) with the provided message.
        super(message);
    }
}
