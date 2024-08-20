/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/10/2024
//Program Name: LLNode.java
/////////////////////////////////////////////////////////////////////
package lab09.support;
/* This class represents a single node in a singly linked list.
 * It holds a generic data element ('T') and a reference ('link')
 * to the next node in the list.
 * @param <T> The type of data stored in the node. */
public class LLNode< T > {

    // The data element stored in this node.
    public T info;

    // The reference to the next node in the linked list.
    public LLNode < T > link;

    /* Constructor for LLNode. Initializes the 'info' field with the provided data
     * and sets the 'link' to null (indicating no next node).
     * @param info The data to store in the node. */
    public LLNode ( T info ) {
        this.info = info;
        link = null;
    }

    /* Sets the data element ('info') of this node.
     * @param info The new data to store. */
    public void setInfo ( T info ) {
        this.info = info;
    }

    /*Returns the data element ('info') stored in this node.
     * @return The data element stored in the node. */
    public T getInfo ( ) {
        return info;
    }

    /* Sets the reference ('link') to the next node in the linked list.
     * @param link The reference to the next node.*/
    public void setLink ( LLNode < T > link ) {
        this.link = link;
    }

    /* Returns the reference ('link') to the next node in the linked list.
     * @return The reference to the next node. */
    public LLNode < T > getLink ( ) {
        return link;
    }
}