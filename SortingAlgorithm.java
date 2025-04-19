/**
 * Abstract class representing a sorting algorithm that counts the number of
 * comparisons and swaps made during the sort. The time taken to sort is also
 * measured. This class is intended to be subclassed by specific sorting algorithm
 * implementations.
 * 
 * @author Jim Teresco
 * @version Spring 2025
 */

public abstract class SortingAlgorithm {

    // number of comparisons made
    protected long comparisons;

    // number of swaps made
    protected long swaps;

    // time taken to sort
    protected long time;

    // the array to be sorted
    protected int[] array;

    // the size of the array
    protected int size;

    /**
     * Default constructor for the sorting algorithm. Initializes the array and its
     * size.
     */
    public SortingAlgorithm() {
        this.array = null;
        this.size = 0;
        this.comparisons = 0;
        this.swaps = 0;
    }

    /**
     * Set the array to be sorted and reset the size, comparisons, swaps, and time
     * 
     * @param array the array to be sorted
     */
    public void setArray(int[] array) {
        this.array = array;
        this.size = array.length;
        this.comparisons = 0;
        this.swaps = 0;
    }

   /**
     * Abstract method to be implemented by subclasses to perform the sorting
     * algorithm.
     */
    public abstract void sort();


    /** 
     * Abstract method to be implemented by subclasses to return the name of the sorting
     * algorithm.
     */
    public abstract String getName();

/**
     * Returns the number of comparisons made during the sort.
     * 
     * @return the number of comparisons
     */
    public long getComparisons() {
        return comparisons;

    }
/**
     * Returns the number of swaps made during the sort.
     * 
     * @return the number of swaps
     */
    public long getSwaps() {
        return swaps;
    }
/**
     * Returns the time taken to sort the array.
     * 
     * @return the time taken to sort
     */
    public long getTime() {
        return time;
    }
}