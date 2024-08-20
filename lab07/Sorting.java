/////////////////////////////////////////////////////////////////////
//CS 401 Introduction to Advanced Studies I
//Student:      Harlee Liz Ramos
//Due date:     04/27/2024
//Program Name: Sorting.java
/////////////////////////////////////////////////////////////////////
package lab07;
class Sorting {
	/* Method SelectionSort
	 * Method SelectionSort Sorts an array of Employee objects using Selection Sort
	 * algorithm. It repeatedly finds the minimum element in the
	 * unsorted subarray and swaps it with the first element of the unsorted
	 * subarray.
	 *
	 * @param array the array of Employee objects to sort
	 * @param low the starting index of the subarray to sort
	 * @param high the ending index of the subarray to sort */
	public static void SelectionSort(Employee[] array, int low, int high) {
		for (int i = low; i <= high; i++) {
			int minIndex = i;
			for (int j = i + 1; j <= high; j++) {
				if (array[j].getId() < array[minIndex].getId()) {
					minIndex = j;
				}
			}
			// Swap the elements found with minimum id
			Employee temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}

	/* Method binarySearch Searches for a specific Employee object in a sorted array
	 * using binary search.
	 * It works by repeatedly dividing the search interval in half.
	 * It compares the key with the middle element.
	 * If the key is smaller, it searches in the left half; if the key is greater, it searches in
	 * the right half.
	 *
	 * @param array the sorted array of Employee objects to search
	 * @param key the id of the Employee object to search for
	 * @return the index of the Employee object in the array, or -1 if not found */
	public static int binarySearch(Employee[] array, long key) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			long midVal = array[mid].getId();
			if (midVal < key) {
				low = mid + 1;
			} else if (midVal > key) {
				high = mid - 1;
			} else {
				return mid; // Found
			}
		}
		return -1; // Not found
	}
}
