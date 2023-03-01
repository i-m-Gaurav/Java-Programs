package IO;

import java.io.FileWriter;

public class filewriter {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("N:\\Coding\\Java assignment\\IO\\new.txt");
            fw.write("hello ji");
            fw.close();
            
        } catch (Exception e) {

        }
    }
}
