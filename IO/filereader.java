package IO;

import java.io.FileReader;



public class filereader {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("N:\\Coding\\Java assignment\\IO\\new.txt");
            int i = fileReader.read();
            while (i != -1) {
                System.out.print((char) i);
                i = fileReader.read();
                
            }
            fileReader.close();
    
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
}

