public class SelectionSort {
    public static void selectionSort(Comparable[] numberList) {
        //smallest value
        int min;
        //temporal mutable value
        Comparable temp;

        //takes the min as the lowest number posbile and increments to swap that value later.
        for (int index = 0; index < numberList.length - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < numberList.length; scan++)
                if (numberList[scan].compareTo(numberList[min]) <= 0)
                    min = scan;

            // Swap the values
            temp = numberList[min];
            numberList[min] = numberList[index];
            numberList[index] = temp;
        }
    }
}
