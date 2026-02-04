package sorting;

public class InsertionSort implements Sorter {

    public void sort(int[] input) {
        int steps = 0;

        for (int i = 1; i < input.length; i++) {


            int key = input[i];


            int j = i - 1;
            steps++; 



            while (j >= 0 && input[j] > key) {
                steps++; 

                input[j + 1] = input[j];

                j--;
                steps += 2; 
            }

            input[j + 1] = key;


            steps++; 
        }
    }
    
}
