import java.util.Scanner;

class bin_fact_ncr_prime {

    // Variable to store the current index while checking if a number is prime
    int i = 2;

    // Method to convert an integer number to binary
    long changeTobinary(long n) {
        if (n == 0) {
            return 0;
        }
        // Recursively divide the number by 2 and add the remainder to the result
        return (n % 2 + 10 * changeTobinary(n / 2));
    }

    // Method to find the factorial of a number
    long facto(long n) {
        if (n == 0) {
            return 1;
        } else {
            // Recursively find the factorial of n-1 and multiply it with n
            return  n * facto(n - 1);
            // return factNum;
        }
    }

    // Method to find nCr using recursion
    long ncr(long n, long r) {
        // Calculate nCr using the formula n! / (n-r)! * r!
        return facto(n) / facto(n - 1) * facto(r);
    }

    // Method to check if a number is prime using recursion
    boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        if (i == n/2+1) {
            return true;
        }
        if (n % i == 0) {
            return false;
        }
        // Increment i and check the next number
        i++;
        return isPrime(n); 
    }
}

class Gaurav2 {
    public static void main(String[] args) {

        // Create an instance of the bin_fact_ncr_prime class
        bin_fact_ncr_prime obj = new bin_fact_ncr_prime();

        // Create a Scanner object to read input from the user
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number : ");
        long number = s.nextLong();
        int n, r;

        // Print a blank line
        System.out.println();

        // Check if the number is prime and print the result
        if (obj.isPrime(number)) {
            System.out.println(number + " is " + " Prime Number");
            System.out.println();
        } else {
            System.out.println(number + " is" + " Not Prime");
            System.out.println();
        }

        // Read n and r from the user
        System.out.print("Enter the N and R :");
        n = s.nextInt();
        r = s.nextInt();
        System.out.println();

        // Print the factorial of n
        System.out.println("Factorial of " + n + " is : " + obj.facto(n));
        System.out.println();

        // Print nCr
        System.out.println("NCR of " + n + " And "+ r + " is : " +obj.ncr(n, r));
        System.out.println();

        // Print the binary representation of number
        System.out.println("Binary of " + number + " is : " + obj.changeTobinary(number)); 
    }
}





