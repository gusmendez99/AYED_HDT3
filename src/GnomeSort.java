public class GnomeSort {
    public static void gnomeSort(Comparable[] numberList) {
        for (int index = 1; index < numberList.length; ) {
            if (numberList[index - 1].compareTo(numberList[index]) <= 0) {
                ++index;
            } else {
                Comparable tempVal = numberList[index];
                numberList[index] = numberList[index - 1];
                numberList[index - 1] = tempVal;
                --index;
                if (index == 0) {
                    index = 1;
                }
            }
        }
    }
}
