import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class Contactmanager {
    //function to show name and contact no.
    public static void nam_no() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("contact.txt"));
            String s;
            int i;
            while ((s = br.readLine()) != null) {
                String[] arr = s.split("##");
                System.out.print(arr[0] + "----");
                for (i = 1; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }

                System.out.println();
            }
            br.close();
        } catch (Exception e) {
            System.out.print("Error in opening file");
        }
    }

    //function to show name and no of contact
    public static void nam_count() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("contact.txt"));
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

    // FUNCTION TO ADD NEW CONTACT IF THE NAME IS ALREADY PRESENT
            
    public static void add_contact() {  
        try {
            BufferedReader br = new BufferedReader(new FileReader("contact.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("contact_temp.txt", true));
            Scanner in = new Scanner(System.in);
            System.out.print("Enter contact Name: ");
            String name = in.next();
            System.out.print("Enter contact number: ");
            String number = in.next();
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("##");
                if (parts[0].equals(name)) {
                    // Contact already exists, append the new phone number
                    line += "," + number;
                    found = true;
                }
                bw.write(line + "\n");
            }
            br.close();
            if (!found) {
                // Contact doesn't exist, create a new entry
                bw.write(name + "##" + number + "\n");
            }
            bw.close();
            // Rename the temporary file to the original file
            File file = new File("contact.txt");
            file.delete();
            new File("contact_temp.txt").renameTo(file);
            System.out.println("Contact added");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    


    //function to delete contact
    public static void delete_con() {
        // Get the name of the contact to be deleted from the user
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name of the contact to be deleted: ");
        String contactName = in.next();

        // Read the contents of the file into an ArrayList
        ArrayList<String> contacts = new ArrayList<String>();
        try {
            File file = new File("contact.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.startsWith(contactName + "##")) {
                    continue; // skip the line that contains the contact to be deleted
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
            FileWriter fileWriter = new FileWriter("contact.txt");
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