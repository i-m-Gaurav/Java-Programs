package IO;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class bufferedwriter {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("N:\\Coding\\Java assignment\\IO\\new.txt");
            BufferedWriter bwriter = new BufferedWriter(fw);

            bwriter.write("Hello kya kar rahe jo ji");
            bwriter.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}
