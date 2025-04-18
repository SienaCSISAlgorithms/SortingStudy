/**
 * Implementation of the Merge Sort algorithm that extends the SortingAlgorithm
 * abstract class. This class performs an iterative merge sort while counting
 * the number of comparisons and swaps.
 * 
 * Note: Merge Sort is a stable sorting algorithm.
 * 
 * @author Jim Teresco via Copilot
 * @version Spring 2025
 */
public class MergeSort extends SortingAlgorithm {

    /**
     * Constructor for the MergeSort class.
     * 
     * @param array the array to be sorted
     */
    public MergeSort(int[] array) {
        super(array);
    }

    /**
     * Performs the Merge Sort algorithm on the array.
     */
    @Override
    public void sort() {
        long startTime = System.nanoTime(); // Start timing the sort

        // Temporary array for merging
        int[] temp = new int[size];

        // Iterative merge sort: start with subarrays of size 1, then double the size
        for (int width = 1; width < size; width *= 2) {
            for (int i = 0; i < size; i += 2 * width) {
                int left = i;
                int mid = Math.min(i + width, size);
                int right = Math.min(i + 2 * width, size);

                merge(array, temp, left, mid, right);
            }
        }

        long endTime = System.nanoTime(); // End timing the sort
        time = endTime - startTime; // Calculate total time taken
    }

    /**
     * Merges two sorted subarrays into a single sorted subarray.
     * 
     * @param array the original array
     * @param temp the temporary array for merging
     * @param left the starting index of the left subarray
     * @param mid the starting index of the right subarray
     * @param right the ending index of the right subarray
     */
    private void merge(int[] array, int[] temp, int left, int mid, int right) {
        int i = left; // Pointer for the left subarray
        int j = mid;  // Pointer for the right subarray
        int k = left; // Pointer for the merged array

        // Merge the two subarrays
        while (i < mid && j < right) {
            comparisons++; // Increment comparison count
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                swaps++; // Count as a swap since elements are moved
            }
        }

        // Copy remaining elements from the left subarray
        while (i < mid) {
            temp[k++] = array[i++];
        }

        // Copy remaining elements from the right subarray
        while (j < right) {
            temp[k++] = array[j++];
        }

        // Copy the merged subarray back into the original array
        for (i = left; i < right; i++) {
            array[i] = temp[i];
        }
    }

    /**
     * Returns the name of the sorting algorithm.
     * 
     * @return the name of the sorting algorithm
     */
    @Override
    public String getName() {
        return "merge";
    }
}