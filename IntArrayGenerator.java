/*
  Sample IntArrayGenerator code for labs that perform sorting algorithm
  timings.  Based on earlier code by Jim Teresco, The College of Saint Rose,
  Spring 2015.
  
  This code generates random integer arrays of various types, including
  random, sorted, reverse sorted, and nearly sorted.  It is used in
  conjunction with the SortingDriver class to perform empirical
  performance studies of sorting algorithms. 

  @author Jim Teresco
  @version Spring 2025
*/

import java.util.Arrays;
import java.util.Random;

public class IntArrayGenerator {

    /* we'll just create one Random object to use throughout */
    private static final Random r = new Random();

    /* used for sorted, nearly sorted, reverse, to get a slightly
       more interesting distribution */
    private static final int MAX_INCREMENT = 10;

    /* populate array with n random values within a given range */
    public static void randomArray(int[] array, int min, int max) {
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(max - min) + min;
        }
    }

    /* populate array with sorted values */
    public static void sorted(int[] array) {
        array[0] = r.nextInt(MAX_INCREMENT);
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + r.nextInt(MAX_INCREMENT);
        }
    }

    /* populate array with reverse sorted values */
    public static void reverseSorted(int[] array) {
        array[array.length - 1] = r.nextInt(MAX_INCREMENT);
        for (int i = array.length - 2; i >= 0; i--) {
            array[i] = array[i + 1] + r.nextInt(MAX_INCREMENT);
        }
    }

    /* populate array with nearly sorted values, with given probability that any
       element will be swapped out of its sorted position */
    public static void nearlySorted(int[] array, double swapProbability) {
        sorted(array);
        for (int i = 0; i < array.length; i++) {
            if (r.nextDouble() < swapProbability) {
                int swapTo = r.nextInt(array.length);
                int temp = array[i];
                array[i] = array[swapTo];
                array[swapTo] = temp;
            }
        }
    }

    /* and let's try these out */
    public static void main(String[] args) {
        int[] array;

        array = new int[10];
        randomArray(array, 1, 100);
        System.out.println("An array of 10 values in the 1-100 range:");
        System.out.println(Arrays.toString(array));

        array = new int[20];
        randomArray(array, -100, 100);
        System.out.println("An array of 20 values in the -100 to +100 range:");
        System.out.println(Arrays.toString(array));

        array = new int[15];
        sorted(array);
        System.out.println("Sorted array of 15 values:");
        System.out.println(Arrays.toString(array));

        array = new int[15];
        reverseSorted(array);
        System.out.println("Reverse sorted array of 15 values:");
        System.out.println(Arrays.toString(array));

        array = new int[25];
        nearlySorted(array, 0.1);
        System.out.println("Nearly sorted array of 25 values, 10% chance of swap:");
        System.out.println(Arrays.toString(array));

        array = new int[50];
        nearlySorted(array, 0.03);
        System.out.println("Nearly sorted array of 50 values, 3% chance of swap:");
        System.out.println(Arrays.toString(array));

        array = new int[50];
        nearlySorted(array, 0.75);
        System.out.println("\"Nearly\" sorted array of 50 values, 75% chance of swap:");
        System.out.println(Arrays.toString(array));
    }
}
