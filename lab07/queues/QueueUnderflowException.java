/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/27/2024
//Program Name: QueueUnderflowException.java
/////////////////////////////////////////////////////////////////////


package lab07.queues;

@SuppressWarnings("serial")
//This class represents an exception that is thrown when an operation is performed on an empty queue.
//It extends RuntimeException.
class QueueUnderflowException extends RuntimeException {
 // Constructor for the QueueUnderflowException class.
 // It takes a message as a parameter, which is the detail message of the exception.
 public QueueUnderflowException(String message) {
     // Call the superclass constructor (RuntimeException) with the provided message.
     super(message);
 }
}
