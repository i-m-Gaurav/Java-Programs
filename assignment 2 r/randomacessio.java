import java.io.*;
import java.util.Scanner;

 class randomaccessio {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a String to match: ");
        String str = in.next();
        System.out.print("Enter String which you want to replace: ");
        String replace = in.next();
        RandomAccessFile raf = new RandomAccessFile("R:\\classwork\\text.txt", "rw");
        int n = 0;
        while (true) {
            long p = raf.getFilePointer();
            String s = raf.readLine();
            if (s == null) {
                // System.out.println("hii");
                break;
            }
            String[] arr = s.split(" ");

            for (int i = 0; i < arr.length; i++) {
                // System.out.println(arr[i]);
                if (arr[i].equals(str)) {
                    raf.seek(p);
                    raf.writeBytes(replace);
                    n = 1;
                    break;
                }
                p += arr[i].length() + 1;
            }

        }
        if (n == 1) {
            System.out.println("Replaced Successfully");
        } else {
           System.out.println("Word Not Found");
        }
        raf.close();
        in.close();
    }
}
