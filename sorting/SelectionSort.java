package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {

        for (int i=0; i<input.length;i++){
            
            int minimumIndex = i;



            for (int j = i+1; j< input.length;j++){
                if (input[j] < input[minimumIndex]){
                    minimumIndex=j;



                }
            }
            int temp = input[i];
            input[i] = input[minimumIndex];

            input[minimumIndex] = temp;
        }  








        System.out.println("Selection Sort!!!");
    }
}
