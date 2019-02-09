package Sorts;

public class GnomeSort {
    public static void gnomeSort(Comparable[] list) {
        for (int index = 1; index < list.length; ) {
            if (list[index - 1].compareTo(list[index]) <= 0) {
                ++index;
            } else {
                Comparable tempVal = list[index];
                list[index] = list[index - 1];
                list[index - 1] = tempVal;
                --index;
                if (index == 0) {
                    index = 1;
                }
            }
        }
    }
}
