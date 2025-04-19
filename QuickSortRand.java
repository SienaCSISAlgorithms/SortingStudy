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
}