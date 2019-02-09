public class MergeSort {
    public static void mergeSort(Comparable[] numberList)
    {
        Comparable[] tmp = new Comparable[numberList.length];
        mergeSort(numberList, tmp,  0,  numberList.length - 1);
    }


    private static void mergeSort(Comparable [ ] numberList, Comparable [ ] tmp, int left, int right)
    {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSort(numberList, tmp, left, center);
            mergeSort(numberList, tmp, center + 1, right);
            merge(numberList, tmp, left, center + 1, right);
        }
    }

    private static void merge(Comparable[ ] numberList, Comparable[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(numberList[left].compareTo(numberList[right]) <= 0)
                tmp[k++] = numberList[left++];
            else
                tmp[k++] = numberList[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = numberList[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = numberList[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            numberList[rightEnd] = tmp[rightEnd];
    }
}
