import java.util.*;
public class RadixSort {
    public Comparable[] finalArray;

    // Radix sort Java implementation

        // A utility function to get maximum value in arr[]
        static int getMax(int arr[], int n)
        {
            int mx = arr[0];
            for (int i = 1; i < n; i++)
                if (arr[i] > mx)
                    mx = arr[i];
            return mx;
        }

        // A function to do counting sort of arr[] according to
        // the digit represented by exp.
        private void countSort(int arr[], int n, int exp)
        {
            int output[] = new int[n]; // output array
            int i;
            int count[] = new int[10];
            Arrays.fill(count,0);

            // Store count of occurrences in count[]
            for (i = 0; i < n; i++)
                count[ (arr[i]/exp)%10 ]++;

            // Change count[i] so that count[i] now contains
            // actual position of this digit in output[]
            for (i = 1; i < 10; i++)
                count[i] += count[i - 1];

            // Build the output array
            for (i = n - 1; i >= 0; i--)
            {
                output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
                count[ (arr[i]/exp)%10 ]--;
            }

            // Copy the output array to arr[], so that arr[] now
            // contains sorted numbers according to curent digit
            Number singleNumber;
            Number[] NumbersArray = new Number[n];
            for (i = 0; i < n; i++){
                arr[i] = output[i];
                singleNumber = new Number(arr[i]);
                NumbersArray[i] = singleNumber;
            }
            finalArray = NumbersArray;
        }

        // The main function to that sorts arr[] of size n using
        // Radix Sort
        private void radixsort(Comparable arrayOfComparables[], int n)
        {
            int[] arr = new int[n];
            for (int i=0; i<n; i++){
                Number number = (Number)arrayOfComparables[i];
                arr[i] = number.getValue();
            }
            // Find the maximum number to know number of digits
            int m = getMax(arr, n);

            // Do counting sort for every digit. Note that instead
            // of passing digit number, exp is passed. exp is 10^i
            // where i is current digit number
            for (int exp = 1; m/exp > 0; exp *= 10)
                countSort(arr, n, exp);
        }

        // A utility function to print an array
        static void print(int arr[], int n)
        {
            for (int i=0; i<n; i++)
                System.out.print(arr[i]+" ");
        }
    }
    /* This code is contributed by Devesh Agrawal */

