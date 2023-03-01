package IOhw;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.SequenceInputStream;
import java.io.File;
import java.util.Vector;
import java.util.Enumeration;



public class copytxt {
    public static void main(String[] args) throws Exception {
        File dir = new File("N:\\Coding\\Java assignment\\IOhw");

        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".txt"));


        Vector<FileInputStream> streams = new Vector<>();


        for (File file : files) {
            System.out.println(file);

            streams.add(new FileInputStream(file));

        }

        Enumeration<FileInputStream> enumeration = streams.elements();

        SequenceInputStream sequence = new SequenceInputStream(enumeration);

        FileWriter fw = new FileWriter(dir + "\\"+ "output.txt");
    
            int b;
            while ((b = sequence.read()) != -1) {
                fw.write(b);

                if (sequence.available() == 0) {
                    fw.write(" ");
                }

            }
    
            sequence.close();
            fw.close();
               
    }
}
