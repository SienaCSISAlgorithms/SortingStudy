/**
 * Extends the QuickSort class to implement the median-of-three pivot selection strategy.
 * This strategy selects the pivot as the median of the first, middle, and last
 * elements of the array.
 * 
 * @author Jim Teresco via Copilot
 * @version Spring 2025
 * @see QuickSort
 * @see SortingAlgorithm
 */

import java.util.Arrays;

public class QuickSortM3 extends QuickSort {

    public QuickSortM3() {
        super();
    }

    @Override
    protected int partition(int[] array, int low, int high) {
        int mid = low + (high - low) / 2;
        int[] candidates = { array[low], array[mid], array[high] };
        Arrays.sort(candidates);
        int pivot = candidates[1]; // Median value
        if (pivot == array[mid]) {
            swap(array, low, mid);
        } else if (pivot == array[high]) {
            swap(array, low, high);
        }

        return super.partition(array, low, high);
    }

    @Override
    public String getName() {
        return "quick-m3";
    }

    /**
     * Main method to test the QuickSortM3 implementation.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        QuickSortM3 quickSortM3 = new QuickSortM3();
        for (int size = 10; size <= 10240; size *= 2) {
            int[] array = new int[size];
            IntArrayGenerator.randomArray(array, 1, 100);
            quickSortM3.setArray(array);
            quickSortM3.sort();

            // Validate that the array is sorted using the base class method
            if (!SortingAlgorithm.isSorted(array)) {
                System.out.printf("Error: Array is not sorted correctly by %s\n", quickSortM3.getName());
                return;
            }

            System.out.printf("QuickSortM3 - Size: %d, Time: %d ns, Comparisons: %d, Swaps: %d\n",
                    size, quickSortM3.getTime(), quickSortM3.getComparisons(), quickSortM3.getSwaps());
        }
    }
}