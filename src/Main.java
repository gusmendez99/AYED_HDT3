import java.io.*;
import java.util.Random;

public class Main {

    public static String UNSORTED_FILE_PATH = "generated.txt";

    public static void main(String args[]){

        writeFile();
        NumberList[] list = readFile();

    }

    private static NumerList[] readFile() throws IOException {
        File f = new File(UNSORTED_FILE_PATH);
        FileReader fr = null;
        try {
            fr = new FileReader(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br  = new BufferedReader(fr);

        NumerList[] list = new NumberList[3000];
        int counter = 0;

        while ((br.readLine())!=null) {
            list[counter] = new Number(Integer.parseInt(br.readLine()));
            counter++;
        }

        br.close();

        return list;

    }

    private static void writeFile(){
        Boolean isDone = true;
        File f = new File(UNSORTED_FILE_PATH);
        FileWriter fr = null;
        Random random = new Random();

        try {
            fr = new FileWriter(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter br  = new BufferedWriter(fr);

        while (isDone) {

            if (!isDone) {
                try {

                    for(int i=0; i < 3000; i++) {
                        // nextInt is normally exclusive of the top value,
                        // so add 1 to make it inclusive
                        br.write(random.nextInt(10000));
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }
    }

}
