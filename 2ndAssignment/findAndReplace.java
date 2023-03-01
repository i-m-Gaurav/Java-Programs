import java.io.*;

public class findAndReplace {
    public static void main(String[] args) {
        try {
            // Open the file in "rw" mode
            RandomAccessFile file = new RandomAccessFile("filename.txt", "rw");

            // Read the contents of the file into a byte array
            byte[] content = new byte[(int) file.length()];
            file.readFully(content);

            // Convert the byte array to a string
            String text = new String(content);

            // Find and replace the characters/words
            text = text.replaceAll("hola", "newtext");

            // Convert the string back to a byte array
            content = text.getBytes();

            // Reset the file pointer to the beginning of the file
            file.seek(0);

            // Write the modified content back to the file
            file.write(content);

            // Close the file
            file.close();

            System.out.println("Replaced successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
