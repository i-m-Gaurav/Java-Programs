package IO;

import java.io.FileInputStream;

public class fileinputstream {
    public static void main(String args[]) {
        try {
            FileInputStream fin = new FileInputStream("N:\\Coding\\Java assignment\\IO\\new.txt");
            
            int i = 0;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);

            }
            
            fin.close();
                


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
