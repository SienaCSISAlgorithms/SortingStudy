/**
 * Implementation of the Bubble Sort algorithm that extends the SortingAlgorithm
 * abstract class. This class performs a straightforward iterative bubble sort
 * while counting the number of comparisons and swaps.
 * 
 * @author Jim Teresco via Copilot
 * @version Spring 2025
 */
public class BubbleSort extends SortingAlgorithm {

    /**
     * Constructor for the BubbleSort class.
     * 
     * @param array the array to be sorted
     */
    public BubbleSort() {
        super();
    }

    /**
     * Performs the Bubble Sort algorithm on the array.
     */
    @Override
    public void sort() {
        long startTime = System.nanoTime(); // Start timing the sort

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                comparisons++; // Increment comparison count
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swaps++; // Increment swap count
                }
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
        return "bubble";
    }

    /**
     * Main method to test the BubbleSort implementation.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        for (int size = 10; size <= 10240; size *= 2) {
            int[] array = new int[size];
            IntArrayGenerator.randomArray(array, 1, 100);
            bubbleSort.setArray(array);
            bubbleSort.sort();

            // Validate that the array is sorted
            if (!SortingAlgorithm.isSorted(array)) {
                System.out.printf("Error: Array is not sorted correctly by %s\n", bubbleSort.getName());
                return;
            }

            System.out.printf("BubbleSort - Size: %d, Time: %d ns, Comparisons: %d, Swaps: %d\n",
                    size, bubbleSort.getTime(), bubbleSort.getComparisons(), bubbleSort.getSwaps());
        }
    }
}