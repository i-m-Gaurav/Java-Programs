import java.util.Scanner;

public class thread6 {
    public static void main(String[] args) {
        // Get the upper and lower limits from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the lower limit: ");
        int lowerLimit = scanner.nextInt();
        System.out.print("Enter the upper limit: ");
        int upperLimit = scanner.nextInt();
        scanner.close();
        int n=upperLimit-lowerLimit;
        // Create the first thread
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int j=lowerLimit;
                for (int i = 1; i <= n/2; i++) {
                    System.out.println("Thread 1: " +j );
                    j++;
                }
            }
        });

        // Create the second thread
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int j=lowerLimit+n/2;
                for (int i = n/2 ; i <= n; i++) {
                    System.out.println("Thread 2: " + j);
                    j++;
                }
            }
        });

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
