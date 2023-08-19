import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort execute = new MergeSort();

        int[] studyCase = {12,3,7,9,14,6,11,2};
        int[] studyCaseExpectedResult = {2,3,6,7,9,11,12,14};
        int[] studyCaseResult = execute.sort(studyCase, 0, studyCase.length - 1);

        System.out.println("Study case result = " + Arrays.equals(studyCaseExpectedResult, studyCaseResult));

        int[] bestCase = {6,7,8,9,10,11,12};
        int[] bestCaseExpectedResult = {6,7,8,9,10,11,12};
        int[] bestCaseResult = execute.sort(bestCase, 0, bestCase.length - 1);

        System.out.println("Best case result = " + Arrays.equals(bestCaseExpectedResult, bestCaseResult));

        int[] worstCase = {90,80,70,60,50,40,30,20,10};
        int[] worstCaseExpectedResult = {10,20,30,40,50,60,70,80, 90};
        int[] worstCaseResult = execute.sort(worstCase, 0, worstCase.length - 1);


        System.out.println("Worst case result = " + Arrays.equals(worstCaseExpectedResult, worstCaseResult));
    }

    public int[] sort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            array = sort(array, leftIndex, middleIndex);
            array = sort(array, middleIndex + 1, rightIndex);

            merge(array, leftIndex, middleIndex, rightIndex);
        }
        return array;
    }

    public void merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {
        int leftArraySize = middleIndex - leftIndex + 1;
        int rightArraySize = rightIndex - middleIndex;

        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        for (int i = 0; i < leftArraySize; i++) {
            leftArray[i] = array[leftIndex + i];
        }
        for (int j = 0; j < rightArraySize; j++) {
            rightArray[j] = array[middleIndex + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = leftIndex;

        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArraySize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArraySize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

}
