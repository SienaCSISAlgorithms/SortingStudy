/**
 * Implementation of the Heap Sort algorithm that extends the SortingAlgorithm
 * abstract class. This class sorts the array using a max-heap while counting
 * the number of comparisons and swaps.
 * 
 * Note: Heap Sort is an in-place sorting algorithm.
 * 
 * @author Jim Teresco via Copilot
 * @version Spring 2025
 */
public class HeapSort extends SortingAlgorithm {

    /**
     * Constructor for the HeapSort class.
     * 
     */
    public HeapSort() {
        super();
    }

    /**
     * Performs the Heap Sort algorithm on the array.
     */
    @Override
    public void sort() {
        long startTime = System.nanoTime(); // Start timing the sort

        // Step 1: Build a max-heap
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, size, i);
        }

        // Step 2: Extract elements from the heap one by one
        for (int i = size - 1; i > 0; i--) {
            // Move the current root (largest element) to the end
            swap(array, 0, i);
            swaps++; // Increment swap count

            // Call heapify on the reduced heap
            heapify(array, i, 0);
        }

        long endTime = System.nanoTime(); // End timing the sort
        time = endTime - startTime; // Calculate total time taken
    }

    /**
     * Heapifies a subtree rooted at the given index.
     * 
     * @param array the array representing the heap
     * @param heapSize the size of the heap
     * @param rootIndex the index of the root of the subtree
     */
    private void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // Initialize largest as root
        int leftChild = 2 * rootIndex + 1; // Left child index
        int rightChild = 2 * rootIndex + 2; // Right child index

        // Check if the left child is larger than the root
        if (leftChild < heapSize) {
            comparisons++; // Increment comparison count
            if (array[leftChild] > array[largest]) {
                largest = leftChild;
            }
        }

        // Check if the right child is larger than the largest so far
        if (rightChild < heapSize) {
            comparisons++; // Increment comparison count
            if (array[rightChild] > array[largest]) {
                largest = rightChild;
            }
        }

        // If the largest is not the root, swap and continue heapifying
        if (largest != rootIndex) {
            swap(array, rootIndex, largest);
            swaps++; // Increment swap count

            // Recursively heapify the affected subtree
            heapify(array, heapSize, largest);
        }
    }

    /**
     * Swaps two elements in the array.
     * 
     * @param array the array
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Returns the name of the sorting algorithm.
     * 
     * @return the name of the sorting algorithm
     */
    @Override
    public String getName() {
        return "heap";
    }
}