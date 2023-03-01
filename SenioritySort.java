import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Define the class Person with age and name attributes
class Person {
    int age;
    String name;

    // Getter method to return the name of a person
    public String getName() {
        return name;
    }

    // Getter method to return the age of a person
    public int getAge() {
        return age;
    }

}

// Main class
public class SenioritySort {
    public static void main(String[] args) throws Exception {

        // Create an ArrayList of type Person to store people objects
        ArrayList<Person> people = new ArrayList<>();

        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of people
        System.out.println("Enter the number of people: ");

        // Read the number of people
        int numOfPeople = scanner.nextInt();
        // scanner.nextLine();

        System.out.println("Enter the Name and Age in one line separated with space.");

        // Read the ages and names of people and add them to the ArrayList

        for (int i = 0; i < numOfPeople; i++) {
            Person person = new Person();
            person.age = scanner.nextInt();
            person.name = scanner.nextLine();

            people.add(person);
        }

        
        scanner.close();

        // Sort the people in the ArrayList based on their age using a lambda expression
        Collections.sort(people, (person1, person2) -> person1.getAge() - person2.getAge());

        // Display the sorted list of people along with their names and ages
        System.out.println("Ages of all people: ");
        for (Person p : people) {

            System.out.println(p.getName() + " " + "(" + p.getAge() + ")");

        }

    }
}






























/*
         * This code is written in Java and it sorts a list of "people" objects based on
         * the age of each person. It uses the Collections.sort() method, which is a
         * static method in the java.util.Collections class that sorts elements in a
         * list.
         * 
         * The Collections.sort() method takes two arguments in this code:
         * 
         * people: The list of people objects that needs to be sorted.
         * (person1, person2) -> person1.getAge() - person2.getAge(): A lambda
         * expression that defines the sorting order.
         * The lambda expression compares two people, person1 and person2, and returns
         * the difference between their ages. The ages are obtained by calling the
         * getAge() method on each person object. The result of the lambda expression
         * determines the sorting order of the people in the list. If the result is
         * negative, person1 will come before person2, and if it's positive, person2
         * will come before person1.
         * 
         * After calling Collections.sort(people, ...), the list of people will be
         * sorted in ascending order based on their age.
         * 
         */

        // Close the Scanner object