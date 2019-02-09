import java.io.*;
import java.util.Random;

public class Main {

    public static String UNSORTED_FILE_PATH = "generated.txt";

    public static void main(String args[]){

        //TODO: remove this part, it's just for tests.
        Number num1 = new Number(2);
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
        SelectionSort.selectionSort(numberss);
        for (int i = 0; i < 5; i++){
            System.out.println(numberss[i].getValue().toString());
        }
        writeFile();
        Number[] numberList;
        try {
            numberList = readFile();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    private static Number[] readFile() throws IOException {
        File f = new File(UNSORTED_FILE_PATH);
        FileReader fr = null;
        try {
            fr = new FileReader(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br  = new BufferedReader(fr);

        Number[] numberList = new Number[3000];
        int counter = 0;

        while ((br.readLine()) != null) {
            numberList[counter] = new Number(Integer.parseInt(br.readLine()));
            counter++;
        }

        br.close();

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
                ((BufferedWriter) writer).newLine();
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
