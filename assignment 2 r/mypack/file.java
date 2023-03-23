package mypack.file;
import java.io.*;
public class file {
    public String findRplace(String find,String replace,String address) throws IOException
    {
                RandomAccessFile raf = new RandomAccessFile(address, "rw");
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
                        if (arr[i].equals(find)) {
                            raf.seek(p);
                            raf.writeBytes(replace);
                            n = 1;
                            break;
                        }
                        p += arr[i].length() + 1;
                    }
        
                }
                String str;
                if (n == 1) {
                  str =  "Replaced Successfully";
                } else {
                   str="Word Not Found";
                }
                raf.close();
                return str;
    }
 }
        
 
    
    

