/**
 * Extends the QuickSort class to implement the randomized version of the quicksort algorithm.
 * This version selects a random pivot from the array to improve performance on
 * certain input distributions.
 * 
 * @author Jim Teresco via Copilot
 * @version Spring 2025
 * @see QuickSort
 * @see SortingAlgorithm
 * 
 */

import java.util.Random;

public class QuickSortRand extends QuickSort {

    private static final Random random = new Random();

    public QuickSortRand() {
        super();
    }

    @Override
    protected int partition(int[] array, int low, int high) {
        // Random pivot selection
        int randomIndex = low + random.nextInt(high - low + 1);
        swap(array, low, randomIndex);

        return super.partition(array, low, high);
    }

    @Override
    public String getName() {
        return "quick-rand";
    }

    /**
     * Main method to test the QuickSortRand implementation.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        QuickSortRand quickSortRand = new QuickSortRand();
        for (int size = 10; size <= 10240; size *= 2) {
            int[] array = new int[size];
            IntArrayGenerator.randomArray(array, 1, 100);
            quickSortRand.setArray(array);
            quickSortRand.sort();

            // Validate that the array is sorted using the base class method
            if (!SortingAlgorithm.isSorted(array)) {
                System.out.printf("Error: Array is not sorted correctly by %s\n", quickSortRand.getName());
                return;
            }

            System.out.printf("QuickSortRand - Size: %d, Time: %d ns, Comparisons: %d, Swaps: %d\n",
                    size, quickSortRand.getTime(), quickSortRand.getComparisons(), quickSortRand.getSwaps());
        }
    }
}