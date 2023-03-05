import java.util.HashSet;

public class question5 {
    public static void main(String[] args) {
        // create a shared object to hold the printed numbers
        PrintedNumbers printedNumbers = new PrintedNumbers();

        // get input from the user
        int num = Integer.parseInt(System.console().readLine("Enter a number to print its table : "));
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter a number: ");
        // int num = scanner.nextInt();

        // create two threads to print the table of the input number
        Thread thread1 = new Thread(new PrintTable(num, printedNumbers));
        Thread thread2 = new Thread(new PrintTable(num, printedNumbers));

        // start the threads
        thread1.start();
        thread2.start();
    }
}

class PrintTable implements Runnable {
    private int num;
    private PrintedNumbers printedNumbers;

    public PrintTable(int num, PrintedNumbers printedNumbers) {
        this.num = num;
        this.printedNumbers = printedNumbers;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            // synchronize the block to ensure that the numbers are not repeated
            synchronized(printedNumbers) {
                // calculate the current number in the table
                int currentNum = i * num;
                // check if the number has already been printed
                while (printedNumbers.isPrinted(currentNum)) {
                    // if the number has already been printed, wait and try again
                    try {
                        printedNumbers.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // if the number has not been printed, print it and mark it as printed
                System.out.println(currentNum);
                printedNumbers.addPrinted(currentNum);
                // notify the other threads that a number has been printed
                printedNumbers.notifyAll();
            }
        }
    }
}

class PrintedNumbers {
    private HashSet<Integer> printedNumbers;

    public PrintedNumbers() {
        printedNumbers = new HashSet<>();
    }

    public synchronized void addPrinted(int num) {
        printedNumbers.add(num);
    }

    public synchronized boolean isPrinted(int num) {
        return printedNumbers.contains(num);
    }
}
