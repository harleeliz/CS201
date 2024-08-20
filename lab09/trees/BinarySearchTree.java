/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/10/2024
//Program Name: BinarySearchTree.java
/////////////////////////////////////////////////////////////////////
package lab09.trees;
import lab09.queues.LinkedUnbndQueue;
import lab09.stacks.LinkedStack;
import lab09.support.BSTNode;
/* A class representing a binary search tree.
 * @param <T> Type of elements stored in the binary search tree, must implement Comparable interface. */
public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T> {
	protected BSTNode<T> root; // reference to the root of this BST
	boolean found; // used by remove for traversals
	protected LinkedUnbndQueue<T> inOrderQueue; // queue of info
	protected LinkedUnbndQueue<T> preOrderQueue; // queue of info
	protected LinkedUnbndQueue<T> postOrderQueue; // queue of info

	// Constructor method. Constructs an empty binary search tree.
	public BinarySearchTree() {
		root = null;
	}

	/* Checks if the tree is empty.   * @return true if the tree is empty, otherwise false. */
	public boolean isEmpty() {
		return (root == null);
	}

	// Method to calculate size of the tree recursively
	private int recSize(BSTNode<T> tree) {
		if (tree == null)
			return 0;
		else
			return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
	}

	/* Method size Calculates the number of nodes in the tree.  * @return The number of nodes in the tree. */
	public int size() {
		return recSize(root);
	}
	
	// Method to calculate size of the tree iteratively
	public int size2() {
		int count = 0;
		if (root != null) {
			LinkedStack<BSTNode<T>> hold = new LinkedStack<BSTNode<T>>();
			BSTNode<T> currNode;
			hold.push(root);
			while (!hold.isEmpty()) {
				currNode = hold.top();
				hold.pop();
				count++;
				if (currNode.getLeft() != null)
					hold.push(currNode.getLeft());
				if (currNode.getRight() != null)
					hold.push(currNode.getRight());
			}
		}
		return count;
	}

	// Method to find the maximum depth of a binary search tree
	public static <T extends Comparable<T>> int findMaxDepth(BSTNode<T> root) {
		if (root == null) {
			return 0;
		} else {
			int leftDepth = findMaxDepth(root.getLeft());
			int rightDepth = findMaxDepth(root.getRight());
			return Math.max(leftDepth, rightDepth) + 1;
		}
	}

	
	// Boolean method recContains
	private boolean recContains(T element, BSTNode<T> tree) {
		// Check if the tree is null
		if (tree == null)
			return false;
		// Check if the element is less than the current node's value
		else if (element.compareTo(tree.getInfo()) < 0)
			return recContains(element, tree.getLeft());
		// Check if the element is greater than the current node's value
		else if (element.compareTo(tree.getInfo()) > 0)
			return recContains(element, tree.getRight());
		// If none of the above conditions are met, the element is found
		else
			return true;
	}


	// Boolean method contains
	public boolean contains(T element) {
		// Call the recursive contains method starting from the root node
		return recContains(element, root);
	}

	
	//Method T recGet
	private T recGet(T element, BSTNode<T> tree) {
		// Check if the tree is null
		if (tree == null)
			return null;
		// Check if the element is less than the current node's value
		else if (element.compareTo(tree.getInfo()) < 0)
			return recGet(element, tree.getLeft());
		// Check if the element is greater than the current node's value
		else if (element.compareTo(tree.getInfo()) > 0)
			return recGet(element, tree.getRight());
		// If none of the above conditions are met, return the current node's value
		else
			return tree.getInfo();
	}

	//Method T get
	public T get(T element) {
		// Call the recursive get method starting from the root node
		return recGet(element, root);
	}

	
	//Method BSTNode
	private BSTNode<T> recAdd(T element, BSTNode<T> tree) {
		// Check if the tree is null, if so create a new node with the given element
		if (tree == null)
			tree = new BSTNode<T>(element);
		// If the element is less than or equal to the current node's value, traverse left
		else if (element.compareTo(tree.getInfo()) <= 0)
			tree.setLeft(recAdd(element, tree.getLeft()));
		// If the element is greater than the current node's value, traverse right
		else
			tree.setRight(recAdd(element, tree.getRight()));
		// Return the modified tree
		return tree;
	}

	//Method add
	public void add(T element) {
		// Call the recursive add method starting from the root node
		root = recAdd(element, root);
	}
	
	//Private method getPredecessor
	private T getPredecessor(BSTNode<T> tree) {
		while (tree.getRight() != null)
			tree = tree.getRight();
		return tree.getInfo();
	}

	//Recursive helper method to remove a node from the BST
	private BSTNode<T> removeNode(BSTNode<T> tree) {

	    // If the node has no left child, return the right child (simplifying the tree)
	    if (tree.getLeft() == null) {
	        return tree.getRight();
	    }

	    // If the node has no right child, return the left child (simplifying the tree)
	    else if (tree.getRight() == null) {
	        return tree.getLeft();
	    }

	    // If the node has two children:
	    else {
	        // Find the in-order predecessor (largest element in the left subtree)
	        T data = getPredecessor(tree.getLeft());

	        // Replace the current node's data with the predecessor's data
	        tree.setInfo(data);

	        // Recursively remove the predecessor from the left subtree
	        tree.setLeft(recRemove(data, tree.getLeft()));
	    }

	    // Return the modified tree (with the node removed)
	    return tree;
	}

	//Recursive method to remove a specific element from the BST
	private BSTNode<T> recRemove(T element, BSTNode<T> tree) {

	    // If the tree is empty, element not found
	    if (tree == null) {
	        found = false;
	    } else {
	        // Search for the element recursively
	        if (element.compareTo(tree.getInfo()) < 0) {
	            // Search in the left subtree
	            tree.setLeft(recRemove(element, tree.getLeft()));
	        } else if (element.compareTo(tree.getInfo()) > 0) {
	            // Search in the right subtree
	            tree.setRight(recRemove(element, tree.getRight()));
	        } else {
	            // Element found, remove the current node

	            // Call the helper method to handle removing the node based on its children
	            tree = removeNode(tree);
	            found = true; // Set flag to indicate element was found
	        }
	    }

	    // Return the modified tree after the removal (may be null if element not found)
	    return tree;
	}

	//Public method to remove an element from the BST, calls the recursive method
	public boolean remove(T element) {
	    root = recRemove(element, root); // Start removal from the root
	    return found; // Return true if element was found and removed, false otherwise
	}
	
	/* Traversal methods to visit nodes in different orders: */
	
	//Recursive method to perform an in-order traversal, storing elements in a queue
	private void inOrder(BSTNode<T> tree) {
	    if (tree != null) {
	        // Visit left subtree first
	        inOrder(tree.getLeft());
	        // Process the current node (adding to queue for later retrieval)
	        inOrderQueue.enqueue(tree.getInfo());
	        // Visit right subtree
	        inOrder(tree.getRight());
	    }
	}

	//Recursive method to perform a pre-order traversal, storing elements in a queue
	private void preOrder(BSTNode<T> tree) {
	    if (tree != null) {
	        // Process the current node first (adding to queue)
	        preOrderQueue.enqueue(tree.getInfo());
	        // Visit left subtree
	        preOrder(tree.getLeft());
	        // Visit right subtree
	        preOrder(tree.getRight());
	    }
	}

	//Recursive method to perform a post-order traversal, storing elements in a queue
	private void postOrder(BSTNode<T> tree) {
	    if (tree != null) {
	        // Visit left subtree first
	        postOrder(tree.getLeft());
	        // Visit right subtree
	        postOrder(tree.getRight());
	        // Process the current node last (adding to queue)
	        postOrderQueue.enqueue(tree.getInfo());
	    }
	}

	//Public method to retrieve the next element in a specified traversal order
	public T getNext(int orderType) {
	    // Return the next element from the appropriate queue based on the traversal type
	    if (orderType == INORDER) {
	        return inOrderQueue.dequeue();
	    } else if (orderType == PREORDER) {
	        return preOrderQueue.dequeue();
	    } else if (orderType == POSTORDER) {
	        return postOrderQueue.dequeue();
	    } else {
	        // Invalid order type
	        return null;
	    }
	}

	/* Function to print in-order traversal of the tree.
	 * @param root The root of the tree. */
	public static <T extends Comparable<T>> void printInOrder(BSTNode<T> root) {
		if (root != null) {
			printInOrder(root.getLeft());
			System.out.print(root.getInfo() + " ");
			printInOrder(root.getRight());
		}
	}
	
	/* Function to print pre-order traversal of the tree.
	 * @param root The root of the tree. */
	public static <T extends Comparable<T>> void printPreOrder(BSTNode<T> root) {
		if (root != null) {
			System.out.print(root.getInfo() + " ");
			printPreOrder(root.getLeft());
			printPreOrder(root.getRight());
		}
	}

	/* Function to print post-order traversal of the tree.
	 * @param root The root of the tree. */
	public static <T extends Comparable<T>> void printPostOrder(BSTNode<T> root) {
		if (root != null) {
			printPostOrder(root.getLeft());
			printPostOrder(root.getRight());
			System.out.print(root.getInfo() + " ");
		}
	}

	/* Setter and Getters of the class BinarySearchTree */
	public BSTNode<T> getRoot() { // Get the root
		return root;
	}

	public void setRoot(BSTNode<T> root) { // Set the root
		this.root = root;
	}

	public boolean isFound() { // boolean method for return true/false if is found
		return found;
	}

	public void setFound(boolean found) { // Set Found
		this.found = found;
	}

	public LinkedUnbndQueue<T> getInOrderQueue() { // Get InOrderQueue
		return inOrderQueue;
	}

	public void setInOrderQueue(LinkedUnbndQueue<T> inOrderQueue) { // Set InOrderQueue
		this.inOrderQueue = inOrderQueue;
	}

	public LinkedUnbndQueue<T> getPreOrderQueue() { // Get PreOrderQueue
		return preOrderQueue;
	}

	public void setPreOrderQueue(LinkedUnbndQueue<T> preOrderQueue) { // Set PreOrderQueue
		this.preOrderQueue = preOrderQueue;
	}

	public LinkedUnbndQueue<T> getPostOrderQueue() { // Get PostOrderQueue
		return postOrderQueue;
	}

	public void setPostOrderQueue(LinkedUnbndQueue<T> postOrderQueue) { // Set PostOrderQueue
		this.postOrderQueue = postOrderQueue;
	}

	/* TODO Auto-generated method stub */
	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public int numberOfNodes() {
		return 0;
	}

	@Override
	public boolean isThere(Comparable item) {
		return false;
	}

	@Override
	public Comparable retrieve(Comparable item) {
		return null;
	}

	@Override
	public void insert(Comparable item) {
	}

	@Override
	public void delete(Comparable item) {
	}

	@Override
	public int reset(int orderType) {
		return 0;
	}

	@Override
	public Comparable getNextItem(int orderType) {
		return null;
	}
}
