package IO;

import java.io.FileOutputStream;

public class fileoutputstream{
    public static void main(String[] args) {
        try {
            
            FileOutputStream fout = new FileOutputStream("N:\\Coding\\Java assignment\\IO\\new.txt");
            fout.write("I am Gaurav".getBytes());
            fout.close();


        } catch (Exception e) {

        }
       

    }
}
