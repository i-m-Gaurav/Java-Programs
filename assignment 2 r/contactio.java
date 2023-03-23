

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class contactio {
    //function to show name and contact no.
    public static void nam_no() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            String s;
            int i;
            while ((s = br.readLine()) != null) {
                String[] arr = s.split("##");
                System.out.print(arr[0] + "    ");
                for (i = 1; i < arr.length; i++) {
                    System.out.print(arr[i] + "  ");
                }

                System.out.println();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //function to show name and no of contact
    public static void nam_count() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            String s;
            int i;
            while ((s = br.readLine()) != null) {
                String[] arr = s.split("##");
                System.out.print(arr[0] + "     ");
                System.out.println(arr.length - 1);
            }
        } catch (Exception e) {
            System.out.print("Error in opening in file");
        }
    }

    //function to add new contact 
    /*  public static void cont_add()
    {
        try{
            //BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            RandomAccessFile raf=new RandomAccessFile("test.txt","rw");
            Scanner in =new Scanner(System.in);
            System.out.print("Enter name to add contact");
            String nam=in.next();
            String s,str;
            int i;
            while(true)
            {
                long p=raf.getFilePointer();
                s=raf.readLine();
                if(s==null)
                {
                    break;
                }
                p+=s.length();
                String[] arr=s.split("##");
                if(nam.equalsIgnoreCase(arr[0]))
                {
                    System.out.print("Enter contact: ");
                    str=in.next();
                    raf.seek(p);
                    System.out.println(p);
                    raf.writeBytes(System.getProperty("line.separator"));
                    raf.writeBytes("##");
                    raf.seek(p+2);
                    raf.writeBytes(str);
                   // arr[arr.length-1] += "##";
                   // arr[arr.length-1] += str;
                    //bw.write();
                    break;
                }
                else{
                    //raSystem.out.print("Enter not matched");
                }
            }
        }
        catch(Exception e)
        {
    
        }
    
            
    }*/
    //function to add new contact
    public static void add_contact() {
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter("test.txt", true));
            Scanner in = new Scanner(System.in);
            System.out.print("Enter contact Name :");
            String s = in.next();
            s += "##";
            System.out.print("Enter contact number :");
            String n = in.next();
            s += n;
            br.write("\n" + s);
            br.close();
            System.out.println("Contact added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //function to delete contact
    public static void delete_con()
    {
        // Get the name of the contact to be deleted from the user
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name of the contact to be deleted: ");
        String contactName = in.next();

// Read the contents of the file into an ArrayList
        ArrayList<String> contacts = new ArrayList<String>();
        try {
            File file = new File("test.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.startsWith(contactName + "##")) {
                    continue;  // skip the line that contains the contact to be deleted
                }
                contacts.add(line);
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
            return;
        }

        // Write the updated list of contacts to the file
        try {
            FileWriter fileWriter = new FileWriter("test.txt");
            for (String contact : contacts) {
                fileWriter.write(contact + "\n");
            }
            fileWriter.close();
            System.out.println("Contact deleted successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter Choice");
        System.out.println("1.Show Name and Contact");
        System.out.println("2.Show Name and Number of contacts");
        System.out.println("3.Add contact");
        System.out.println("4.Delete contact");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        switch (n) {
            case 1:
                nam_no();
                break;
            case 2:
                nam_count();
                break;
            case 3:
                add_contact();
                break;
            case 4:
                delete_con();
                break;
            default:
                System.out.println("Enter correct choice");

        }
    }
}