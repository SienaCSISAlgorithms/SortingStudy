/**
 * Implementation of the Insertion Sort algorithm that extends the SortingAlgorithm
 * abstract class. This class performs an iterative insertion sort while counting
 * the number of comparisons and swaps.
 * 
 * @author Jim Teresco via Copilot
 * @version Spring 2025
 */
public class InsertionSort extends SortingAlgorithm {

    /**
     * Constructor for the InsertionSort class.
     * 
     */
    public InsertionSort() {
        super();
    }

    /**
     * Performs the Insertion Sort algorithm on the array.
     */
    @Override
    public void sort() {
        long startTime = System.nanoTime(); // Start timing the sort

        for (int i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0) {
                comparisons++; // Increment comparison count
                if (array[j] > key) {
                    array[j + 1] = array[j];
                    swaps++; // Increment swap count
                    j--;
                } else {
                    break;
                }
            }
            array[j + 1] = key;
        }

        long endTime = System.nanoTime(); // End timing the sort
        time = endTime - startTime; // Calculate total time taken
    }

    /**
     * Returns the name of the sorting algorithm.
     * 
     * @return the name of the sorting algorithm
     */
    @Override
    public String getName() {
        return "insertion";
    }
}