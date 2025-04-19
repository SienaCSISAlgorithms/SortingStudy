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

    public QuickSortM3(int[] array) {
        super(array);
    }

    @Override
    protected int partition(int[] array, int low, int high) {
        // Median-of-three pivot selection
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
}