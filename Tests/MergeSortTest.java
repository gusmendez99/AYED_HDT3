import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void mergeSort() {
        Number num2 = new Number(3);
        Number num1 = new Number(1);
        Number num3 = new Number(2);
        Number[] numbers = new Number[3];
        numbers[0] = num1;
        numbers[1] = num2;
        numbers[2] = num3;
        Number[] expected = new Number[3];
        expected[0]= num1;
        expected[1] = num3;
        expected[2]=num2;
        MergeSort.mergeSort(numbers);
        assertEquals(expected[0].getValue(),numbers[0].getValue());
    }
}