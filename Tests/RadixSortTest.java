import org.junit.Test;

import static org.junit.Assert.*;

public class RadixSortTest {

    @Test
    public void getMax() {
        RadixSort myRadix = new RadixSort();
        Number num2 = new Number(3);
        Number num1 = new Number(1);
        Number num3 = new Number(2);
        Number[] numbers = new Number[3];
        numbers[0] = num1;
        numbers[1] = num2;
        numbers[2] = num3;
        myRadix.radixSort(numbers,numbers.length);
        Number[] expected = new Number[3];
        expected[0]= num1;
        expected[1] = num3;
        expected[2]=num2;
        assertEquals(expected[0].getValue(),numbers[0].getValue());

    }
}