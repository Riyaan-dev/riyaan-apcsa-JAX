package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {
        int steps = 0;

        for (int i = 0; i < input.length - 1; i++) {
            
            int minIndex = i;

            for (int j = i + 1; j < input.length; j++) {
                steps++;


                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = input[minIndex];
            input[minIndex] = input[i];



            input[i] = temp;



            steps += 3;
        }

    }
}
