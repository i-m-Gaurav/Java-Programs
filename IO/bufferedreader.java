package IO;

import java.io.BufferedReader;
import java.io.FileReader;

public class bufferedreader {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("N:\\Coding\\Java assignment\\IO\\new.txt");
            BufferedReader bReader = new BufferedReader(fr);

            int i = bReader.read();
            while (i != -1) {
                System.out.print((char) i);
                i = bReader.read();
            }
            bReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
