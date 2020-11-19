package tech.jarek;

public class BubbleSort {

    public void sort(int[] myArray) {
        boolean isSorted = false;

        while(!isSorted) {
            isSorted = true;

            for(int i = 0; i < myArray.length -1; i++) {
                if(myArray[i] > myArray[i+1]) {
                    isSorted = false;
                    int temp = myArray[i];
                    myArray[i] = myArray[i+1];
                    myArray[i+1] = temp;
                }
            }
        }
    }
}
