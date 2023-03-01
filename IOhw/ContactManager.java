package IOhw;

import java.io.BufferedReader;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.InputStreamReader;
import java.lang.StringBuffer;

class test {

    String FILE_PATH = "N:\\Coding\\Java assignment\\IOhw\\contact.txt";

    void DisplayNameAndTotalContactNumber() throws Exception {

        RandomAccessFile raf = new RandomAccessFile(FILE_PATH, "rw");

        String Divider = "##";

        String line = null;
        while ((line = raf.readLine()) != null) {
            String[] lines = line.split(Divider);
            int count = 0;

            for (int i = 0; i < lines.length;) {

                // System.out.print(" " + lines[i]);
                i++;
                if (i == lines.length) {
                    // System.out.println(" ");
                }

                try {

                    // System.out.println(n);
                    int n = Integer.parseInt(lines[i]);

                    count++;

                } catch (Exception e) {

                    System.out.print(lines[0]);

                }

            }
            System.out.println(" Has " + count + " Contacts ");
        }

        raf.close();

    }

    void DisplayAll() throws Exception {

        RandomAccessFile raf = new RandomAccessFile(FILE_PATH, "rw");

        String Divider = "##";

        String line = null;
        while ((line = raf.readLine()) != null) {
            String[] lines = line.split(Divider);

            for (int i = 0; i < lines.length;) {

                System.out.print(lines[i] + " ");
                i++;
                if (i == lines.length) {
                    System.out.println(" ");
                }

            }
        }
        raf.close();
    }

    void AddNewContactToGivenName() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the search string: ");
        String searchString = reader.readLine();

        boolean found = false;

        // Open the file in read/write mode
        RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw");

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

            String Divider = "##";

            String Newline = null;
            while ((Newline = file.readLine()) != null) {
                if (line.contains("##")) {
                    filePointer = file.getFilePointer();
                }

                System.out.println(filePointer);

               

            }
            
            file.seek(filePointer);

          

            System.out.print("Enter the new contact number for this person: ");
            String replaceString = reader.readLine();

                byte[] newDataBytes = replaceString.getBytes();
                file.write(newDataBytes, 0, newDataBytes.length);

           
            

        } else {
            System.out.println("Not found");
        }

        file.close();
    }
}

public class ContactManager {
    public static void main(String[] args) throws Exception {

        test t = new test();

        t.DisplayNameAndTotalContactNumber();
        t.DisplayAll();
        t.AddNewContactToGivenName();

    }
}
