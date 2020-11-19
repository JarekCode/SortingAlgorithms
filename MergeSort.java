package tech.jarek;

public class MergeSort {

    public int[] sort(int[] myArray) {
        // Recursive base case
        if(myArray.length <= 1) {
            return myArray;
        }

        // Midpoint
        int midpoint = myArray.length / 2;

        // Left and Right arrays
        int[] left = new int[midpoint];
        int[] right = myArray.length % 2 == 0 ? new int[midpoint] : new int[midpoint + 1];

        // Populate left array
        for(int i = 0; i < midpoint; i++) {
            left[i] = myArray[i];
        }

        // Populate right array
        for(int i = 0; i < right.length; i++) {
            right[i] = myArray[midpoint + i];
        }

        // Result array to be returned
        int[] result;

        // Recursively call left and right
        left = sort(left);
        right = sort(right);

        // Merge left and right
        result = merge(left, right);

        // Return result array
        return result;
    }

    private int[] merge(int[] left, int[] right) {
        // Result array to be returned
        int[] result = new int[left.length + right.length];
        // Pointers fot left, right and result arrays
        int leftPointer = 0, rightPointer = 0, resultPointer = 0;

        // While there is an item in left OR right
        while(leftPointer < left.length || rightPointer < right.length) {
            // If there are elements in left AND right arrays
            if(leftPointer < left.length && rightPointer < right.length) {
                // If the item in left array is smaller, append it to the result array and update pointers
                if(left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                }
                // Else, append the item in the right array to the result array and update pointers
                else {
                    result[resultPointer++] = right[rightPointer++];
                }
            }
            // If there are elements left in left array, append them to result and update pointers
            else if(leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            }
            // If there are elements left in right array, append them to result and update pointers
            else if(rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        // Return result array
        return result;
    }
}
