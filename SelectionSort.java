/**
 * Implementation of the Selection Sort algorithm that extends the SortingAlgorithm
 * abstract class. This class performs an iterative selection sort while counting
 * the number of comparisons and swaps.
 * 
 * @version Spring 2025
 */
public class SelectionSort extends SortingAlgorithm {

    /**
     * Default constructor for the SelectionSort class.
     */
    public SelectionSort() {
        super();
    }

    /**
     * Performs the Selection Sort algorithm on the array.
     */
    @Override
    public void sort() {
        long startTime = System.nanoTime(); // Start timing the sort

        for (int i = 0; i < size - 1; i++) {
            // Find the index of the minimum element in the unsorted portion
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                comparisons++; // Increment comparison count
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted portion
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                swaps++; // Increment swap count
            }
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
        return "selection";
    }

    /**
     * Main method to test the SelectionSort implementation.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        for (int size = 10; size <= 10240; size *= 2) {
            int[] array = new int[size];
            IntArrayGenerator.randomArray(array, 1, 100);
            selectionSort.setArray(array);
            selectionSort.sort();

            // Validate that the array is sorted using the base class method
            if (!SortingAlgorithm.isSorted(array)) {
                System.out.printf("Error: Array is not sorted correctly by %s\n", selectionSort.getName());
                return;
            }

            System.out.printf("SelectionSort - Size: %d, Time: %d ns, Comparisons: %d, Swaps: %d\n",
                    size, selectionSort.getTime(), selectionSort.getComparisons(), selectionSort.getSwaps());
        }
    }
}