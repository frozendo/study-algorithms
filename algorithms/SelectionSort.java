import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort execute = new SelectionSort();

        int[] studyCase = {5,2,4,6,1,3,2};
        int[] studyCaseExpectedResult = {1,2,2,3,4,5,6};
        int[] studyCaseResult = execute.selectionSort(studyCase);

        System.out.println("Study case result = " + Arrays.equals(studyCaseExpectedResult, studyCaseResult));

        int[] bestCase = {6,7,8,9,10,11,12};
        int[] bestCaseExpectedResult = {6,7,8,9,10,11,12};
        int[] bestCaseResult = execute.selectionSort(bestCase);

        System.out.println("Best case result = " + Arrays.equals(bestCaseExpectedResult, bestCaseResult));

        int[] worstCase = {90,80,70,60,50,40,30,20,10};
        int[] worstCaseExpectedResult = {10,20,30,40,50,60,70,80, 90};
        int[] worstCaseResult = execute.selectionSort(worstCase);


        System.out.println("Worst case result = " + Arrays.equals(worstCaseExpectedResult, worstCaseResult));
    }

    private int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[smallestIndex] > array[j]) {
                    smallestIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[smallestIndex];
            array[smallestIndex] = temp;
        }
        return array;
    }

}
