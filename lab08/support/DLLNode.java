/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Professor:    Michael Yonshik Choi, PhD
//TA:			Tarun Sai Yakkala
//Student:      Harlee Liz Ramos
//Due date:     04/03/2024
//Program Name: DLLNode.java
/////////////////////////////////////////////////////////////////////
package lab08.support;
/* This class represents a node in a doubly linked list.
 * It holds a generic data element ('T') and references to both
 * the next ('forward') and previous ('back') nodes in the list.
 * @param <T> The type of data stored in the node. */
public class DLLNode<T> {

	//The data element stored in this node.
	private T info;

	//The reference to the next node in the linked list.
	private DLLNode<T> forward;

	//The reference to the previous node in the linked list.
	private DLLNode<T> back;

	/* Constructor for DLLNode. Initializes the 'info' field with the provided data
	 * and sets both 'forward' and 'back' to null (indicating no connections).
	 * @param info The data to store in the node.*/
	public DLLNode(T info) {
		this.info = info;
		forward = null;
		back = null;
	}

	/*Sets the data element ('info') of this node.
	 * @param info The new data to store.*/
	public void setInfo(T info) {
		this.info = info;
	}

	/*Returns the data element ('info') stored in this node. 
	 * @return The data element stored in the node. */
	public T getInfo() {
		return info;
	}

	/*Sets the reference to the next node ('forward') in the linked list.
	 * @param forward The reference to the next node.
	 */
	public void setForward(DLLNode<T> forward) {
		this.forward = forward;
	}

	/*Sets the reference to the previous node ('back') in the linked list.
	 * @param back The reference to the previous node.*/
	public void setBack(DLLNode<T> back) {
		this.back = back;
	}

	/* Returns the reference to the next node ('forward') in the linked list. 
	 * @return The reference to the next node.*/
	public DLLNode getForward() {
		return forward;
	}

	/* Returns the reference to the previous node ('back') in the linked list. 
	 * @return The reference to the previous node.*/
	public DLLNode getBack() {
		return back;
	}
}
