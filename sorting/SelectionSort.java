package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {

        for (int i=0; i<input.length;i++){
            int mIndex = i;

            for (int j = 1; j< input.length-1;j++){
                if (input[j] < input[mIndex]){
                    mIndex=j;
                    //not working
                }
            }
        }  








        System.out.println("Selection Sort!!!");
    }
}
