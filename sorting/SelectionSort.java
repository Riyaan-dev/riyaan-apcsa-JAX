package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {

        for (int i=0; i<input.length;i++){
            int mIndex = i;

            for (int j = i+1; j< input.length;j++){
                if (input[j] < input[mIndex]){
                    mIndex=j;
                }
            }
            int t = input[i];
            input[i] = input[mIndex];
            input[mIndex] = t;
        }  








        System.out.println("Selection Sort!!!");
    }
}
