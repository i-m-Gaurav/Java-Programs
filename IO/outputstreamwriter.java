package IO;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class outputstreamwriter {
    public static void main(String[] args) {
        try {
            FileOutputStream fout = new FileOutputStream("N:\\Coding\\Java assignment\\IO\\new.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fout,"UTF-8");

            outputStreamWriter.write("The fuck man");
            outputStreamWriter.close();

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
