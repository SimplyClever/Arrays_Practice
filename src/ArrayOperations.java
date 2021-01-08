public class ArrayOperations {

    public static int[] sortArrayWithUniqueValues(int[] initialArray) {
        int[] copyArray = new int[initialArray.length];

        int index = 0;
        for(int value : initialArray) {
            if(!ArrayOperations.hasValue(copyArray, value)) {
                copyArray[index] = value;
                index++;
            }
        }

        int[] resultArray = new int[index];
        for(int i = 0; i < resultArray.length; i++) {
            resultArray[i] = copyArray[i];
        }

        ArrayOperations.quickSort(resultArray, 0, resultArray.length-1);

        return resultArray;
    }

    private static boolean hasValue(int[] array, int searchValue) {
        for(int value : array) {
            if(value == searchValue) return true;
        }
        return false;
    }

    private static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = separate(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }

    private static int separate(int[] array, int begin, int end) {
        int kernel = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[kernel]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[kernel];
        array[kernel] = array[counter];
        array[counter] = temp;

        return counter;
    }
}
