import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort execute = new InsertionSort();

        int[] studyCase = {5,2,4,6,1,3,2};
        int[] studyCaseExpectedResult = {1,2,2,3,4,5,6};
        int[] studyCaseResult = execute.insertionSort(studyCase);

        System.out.println("Study case result = " + Arrays.equals(studyCaseExpectedResult, studyCaseResult));

        int[] bestCase = {6,7,8,9,10,11,12};
        int[] bestCaseExpectedResult = {6,7,8,9,10,11,12};
        int[] bestCaseResult = execute.insertionSort(bestCase);

        System.out.println("Best case result = " + Arrays.equals(bestCaseExpectedResult, bestCaseResult));

        int[] worstCase = {90,80,70,60,50,40,30,20,10};
        int[] worstCaseExpectedResult = {10,20,30,40,50,60,70,80, 90};
        int[] worstCaseResult = execute.insertionSort(worstCase);

        System.out.println("Worst case result = " + Arrays.equals(worstCaseExpectedResult, worstCaseResult));
    }

    private int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1]  = key;
        }
        return array;
    }

}
