#!/bin/bash

# filepath: /Users/terescoj/class/algorithms/385-siena/SortingStudy/run_sorting_study.sh

# Define the sorting algorithms, input sizes, input types, and number of trials
ALGORITHMS=("bubble" "selection" "insertion" "quick" "quick-rand" "quick-m3" "merge" "heap")
INPUT_SIZES=(10 20 40 80 160 320 640 1280 2560 5120 10240 20480 40960 81920)
INPUT_TYPES=("random" "sorted" "nearly-sorted" "reverse")
TRIALS=5

# Compile the Java program (optional, if not already compiled)
javac *.java
if [ $? -ne 0 ]; then
    echo "Compilation failed. Exiting."
    exit 1
fi

# Run the SortingDriver for each combination of algorithm, input size, and input type
for algorithm in "${ALGORITHMS[@]}"; do
    for input_type in "${INPUT_TYPES[@]}"; do
        for size in "${INPUT_SIZES[@]}"; do            
            #echo "Running: java SortingDriver $algorithm $size $input_type $TRIALS"
            java SortingDriver "$algorithm" "$size" "$input_type" "$TRIALS"
        done
    done
done