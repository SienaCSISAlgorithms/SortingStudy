/**
 * Implementation of the Quick Sort algorithm that extends the SortingAlgorithm
 * abstract class. This class performs an iterative quicksort using the first
 * element as the pivot for each partition while counting the number of comparisons
 * and swaps.
 * 
 * Note: Quick Sort is an in-place sorting algorithm.
 * 
 * @author Jim Teresco via Copilot
 * @version Spring 2025
 */
import java.util.Stack;

public class QuickSort extends SortingAlgorithm {

    /**
     * Constructor for the QuickSort class.
     * 
     */
    public QuickSort() {
        super();
    }

    /**
     * Performs the Quick Sort algorithm on the array.
     */
    @Override
    public void sort() {
        long startTime = System.nanoTime(); // Start timing the sort

        // Stack to simulate recursion for iterative quicksort
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] { 0, size - 1 });

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int low = range[0];
            int high = range[1];

            if (low < high) {
                int pivotIndex = partition(array, low, high);

                // Push subarray ranges onto the stack
                stack.push(new int[] { low, pivotIndex - 1 });
                stack.push(new int[] { pivotIndex + 1, high });
            }
        }

        long endTime = System.nanoTime(); // End timing the sort
        time = endTime - startTime; // Calculate total time taken
    }

    /**
     * Partitions the array around the pivot and returns the index of the pivot
     * after partitioning. Subclasses can override this method to implement
     * different pivot selection strategies.
     * 
     * @param array the array to partition
     * @param low the starting index of the partition
     * @param high the ending index of the partition
     * @return the index of the pivot after partitioning
     */
    protected int partition(int[] array, int low, int high) {
        int pivot = array[low]; // Default pivot is the first element
        int i = low + 1;
        int j = high;

        while (i <= j) {
            while (i <= j && array[i] <= pivot) {
                comparisons++;
                i++;
            }
            while (i <= j && array[j] > pivot) {
                comparisons++;
                j--;
            }
            if (i < j) {
                swap(array, i, j);
                swaps++;
            }
        }

        swap(array, low, j);
        swaps++;
        return j;
    }

    /**
     * Swaps two elements in the array.
     * 
     * @param array the array
     * @param i the index of the first element
     * @param j the index of the second element
     */
    protected void swap(int[] array, int i, int j) {
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
        return "quick";
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        for (int size = 10; size <= 10240; size *= 2) {
            int[] array = new int[size];
            IntArrayGenerator.randomArray(array, 1, 100);
            quickSort.setArray(array);
            quickSort.sort();

            // Validate that the array is sorted using the base class method
            if (!SortingAlgorithm.isSorted(array)) {
                System.out.printf("Error: Array is not sorted correctly by %s\n", quickSort.getName());
                return;
            }

            System.out.printf("QuickSort - Size: %d, Time: %d ns, Comparisons: %d, Swaps: %d\n",
                    size, quickSort.getTime(), quickSort.getComparisons(), quickSort.getSwaps());
        }
    }
}