import java.io.*;
import java.util.Random;

public class Main {

    public static String UNSORTED_FILE_PATH = "generated.txt";

    public static void main(String args[]){

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
