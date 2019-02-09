import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * date 02/08/2019
 * @author  Gustavo Andrés, Carné 18500
 * @author  Luis Urbina, Carné 18473
 * This program is designed to run automatically, no user intervention needed.
 * It generates 3000 random numbers and wtrite them into a .txt file
 * After that, it reads the previusly generated .txt file and almacenates each one of
 * the numbers in a list of Number-type Objects.
 * That list is passed to 5 different types of sorts, that sort the numbers.
 */

public class Main {
    //name of the generated txt
    public static String UNSORTED_FILE_PATH = "generated.txt";

    public static void main(String args[]){
        writeFile(); //writes the file locally
        Number[] numberList; //almacenates the Number-type Objects
        try {
            /**
             * numberList gets the value of readFile() Method and all sorts are made one after another.
             */
            numberList = readFile();
            GnomeSort.gnomeSort(numberList);
            QuickSort.quickSort(numberList,0, numberList.length - 1);
            MergeSort.mergeSort(numberList);
            SelectionSort.selectionSort(numberList);

            RadixSort radix = new RadixSort();
            radix.radixSort(numberList, numberList.length);
            radix.getFinalArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();


    }

    /**
     *
     * @return numberList (A Number-Type List)
     * @throws IOException failure in one of the characters of the txt file
     */
    private static Number[] readFile() throws IOException {
        Number[] numberList = new Number[3000];
        final AtomicInteger index = new AtomicInteger();

        try (Stream<String> stream = Files.lines(Paths.get(UNSORTED_FILE_PATH))) {
            stream.forEachOrdered(line -> {
                numberList[index.getAndIncrement()] = new Number(Integer.parseInt(line));
            });

        } catch (IOException e) {
            e.printStackTrace();
        }



        return numberList;

    }

    /**
     * Writes file locally with a for loop until 3000 numbers are written in the file.
     */
    private static void writeFile() {
        Random random = new Random();

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(UNSORTED_FILE_PATH), "utf-8"))) {

            for (int i = 0; i < 3000; i++) {
                // nextInt is normally exclusive of the top value,
                // so add 1 to make it inclusive
                writer.write(String.valueOf(random.nextInt(10000)));
                if(i < 2999)((BufferedWriter) writer).newLine();
            }


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
