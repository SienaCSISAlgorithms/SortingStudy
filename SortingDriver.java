import java.util.List;

/**
    Main driver program for the empirical study of sorting algorithms 

    @author Jim Teresco
    @version Spring 2025
*/

import java.util.List;

public class SortingDriver {

    public static void main(String[] args) {
        
        // check for 4 required command line arguments
        if (args.length != 4) {
            System.out.println("Usage: java SortingDriver <algorithm> <size> <inputtype> <trials>");
            System.exit(1);
        }

        // create a list of the sorting algorithms
        List<SortingAlgorithm> algorithms = List.of(
            new BubbleSort(),
            new SelectionSort(),
            new InsertionSort(),
            new QuickSort(),
            new QuickSortRand(),
            new QuickSortM3(),
            new MergeSort(),
            new HeapSort()
        );

        // parse command line arguments
        String algorithmName = args[0];
        int size = Integer.parseInt(args[1]);
        String inputType = args[2];
        int trials = Integer.parseInt(args[3]);

        // find the algorithm to use
        SortingAlgorithm algorithm = null;
        for (SortingAlgorithm alg : algorithms) {
            if (alg.getName().equalsIgnoreCase(algorithmName)) {
                algorithm = alg;
                break;
            }
        }
        if (algorithm == null) {
            System.out.println("Unknown sorting algorithm: " + algorithmName);
            System.exit(1);
        }
        // check that the size is positive
        if (size <= 0) {
            System.out.println("Size must be positive: " + size);
            System.exit(1);
        }

        // check that the number of trials is positive
        if (trials <= 0) {
            System.out.println("Number of trials must be positive: " + trials);
            System.exit(1);
        }

        // check that the input type is valid
        if (!inputType.equalsIgnoreCase("random") && !inputType.equalsIgnoreCase("sorted")
                && !inputType.equalsIgnoreCase("nearly-sorted") && !inputType.equalsIgnoreCase("reverse")) {
            System.out.println("Unknown input type: " + inputType);
            System.exit(1);
        }

        // run the trials and get the average time, comparisons, and swaps
        long totalTime = 0;
        long totalComparisons = 0;
        long totalSwaps = 0;

        for (int i = 0; i < trials; i++) {
            // create the array to be sorted
            int[] array = new int[size];
            if (inputType.equalsIgnoreCase("random")) {
                IntArrayGenerator.randomArray(array, 1, 100);
            } else if (inputType.equalsIgnoreCase("sorted")) {
                IntArrayGenerator.sorted(array);
            } else if (inputType.equalsIgnoreCase("nearly-sorted")) {
                IntArrayGenerator.nearlySorted(array, 0.1);
            } else if (inputType.equalsIgnoreCase("reverse")) {
                IntArrayGenerator.reverseSorted(array);
            }

            // sort the array
            algorithm.setArray(array);
            algorithm.sort();

            // add the time, comparisons, and swaps to the totals
            totalTime += algorithm.getTime();
            totalComparisons += algorithm.getComparisons();
            totalSwaps += algorithm.getSwaps();
        }
        // calculate the averages
        long averageTime = totalTime / trials;
        long averageComparisons = totalComparisons / trials;
        long averageSwaps = totalSwaps / trials;

        // print the results on a single line, comma-separated
        System.out.printf("%s,%d,%s,%d,%d,%d,%d\n", algorithm.getName(), size, inputType, trials, averageTime,
                averageComparisons, averageSwaps);

    }
}