package IOhw;
import java.io.*;

public class randomAccessFindString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    
        String filePath = "N:\\Coding\\Java assignment\\IOhw\\t1.txt";

        System.out.print("Enter the search string: ");
        String searchString = reader.readLine();

        System.out.print("Enter the replacement string: ");
        String replaceString = reader.readLine();

        boolean found = false;

        // Open the file in read/write mode
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");

        long filePointer = 0;
        String line = null;

        while ((line = file.readLine()) != null) {
            if (line.contains(searchString)) {
                found = true;
                break;
            }
            filePointer = file.getFilePointer();
        }

        if (found) {
            String newLine = line.replace(searchString, replaceString);
            byte[] lineBytes = newLine.getBytes();
            file.seek(filePointer);
            file.write(lineBytes);
        } else {
            System.out.println("Not found");
        }

        file.close();
    }
}
