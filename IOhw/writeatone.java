package IOhw;

import java.io.RandomAccessFile;

public class writeatone {

    public static void main(String[] args) {

        String filePath = "N:\\Coding\\Java assignment\\IOhw\\new.txt";    

        try {

            
            RandomAccessFile file = new RandomAccessFile(filePath, "rw");

            // move the file pointer to position 10
            file.seek(5);

            // read the existing data from the file
            byte[] existingData = new byte[(int) (file.length())-5];
            file.read(existingData);

            // move the file pointer back to position 10
            file.seek(5);

            // write the new data to the file
            String newData = "hello world ";
            byte[] newDataBytes = newData.getBytes();
            file.write(newDataBytes, 0, newDataBytes.length);

            // write the existing data back to the file
            // file.write(existingData);

            // close the file
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
