import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static String UNSORTED_FILE_PATH = "generated.txt";

    public static void main(String args[]){

        //TODO: remove this part, it's just for tests.
        /*Number num1 = new Number(2);
        Number num2 = new Number(1);
        Number num3 = new Number(3);
        Number num4 = new Number(3);
        Number num5 = new Number(4);
        Number[] numberss = new Number[5];
        numberss[0] = num1;
        numberss[1] = num2;
        numberss[2] = num3;
        numberss[3] = num4;
        numberss[4] = num5;

        for (int i = 0; i < 5; i++){
            System.out.println(numberss[i].getValue().toString());
        }*/
        writeFile();
        Number[] numberList;
        try {
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
