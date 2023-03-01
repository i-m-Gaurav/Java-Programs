package IO;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class inputstreamreader {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("N:\\Coding\\Java assignment\\IO\\new.txt");
            InputStreamReader isr = new InputStreamReader(fin);
            
            int i = isr.read();
            while (i != -1) {
                System.out.print((char) i);
                i = isr.read();
            }
            isr.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
