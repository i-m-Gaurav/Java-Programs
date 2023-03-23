import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class findAndReplace {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        String path = "C:\\Users\\Gaurav kumar\\Desktop\\Java\\2ndAssignment\\replace.txt";
        
        try (RandomAccessFile raf = new RandomAccessFile(path, "rw")) {
            System.out.print("Enter the string to search: ");
            String searchString = scanner.nextLine();
            
            System.out.print("Enter the string to replace: ");
            String replaceString = scanner.nextLine();
            
            boolean found = false;
            long pos = 0;
            while (raf.getFilePointer() < raf.length()) {
                String line = raf.readLine();
                if (line.contains(searchString)) {
                    found = true;
                    String newLine = line.replaceAll(searchString, replaceString);
                    raf.seek(pos);
                    raf.writeBytes(newLine);
                    break;
                }
                pos = raf.getFilePointer();
            }
            
            if (found) {
                System.out.println("String replaced successfully.");
            } else {
                System.out.println("String not found in file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
