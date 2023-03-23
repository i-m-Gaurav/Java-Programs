import java.util.Scanner;

class PrintNumbers implements Runnable {
    private int id;
    private int lower;
    private int higher;

    private static Object lock = new Object();
    private static int current = 1;

    public PrintNumbers(int id, int lower, int higher) {
        this.id = id;
        this.lower = lower;
        this.higher = higher;
        current = lower;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (current <= higher) {
                if (current % 2 == id) {
                    System.out.println(Thread.currentThread().getName() + " prints " + current);
                    current++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            lock.notifyAll();
        }
    }
}

public class question6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the lower limit: ");
        int lower = scanner.nextInt();
        System.out.print("Enter the higher limit: ");
        int higher = scanner.nextInt();

        PrintNumbers evenPrinter = new PrintNumbers(0, lower, higher);
        PrintNumbers oddPrinter = new PrintNumbers(1, lower, higher);

        Thread evenThread = new Thread(evenPrinter, "Even Thread");
        Thread oddThread = new Thread(oddPrinter, "Odd Thread");

        evenThread.start();
        oddThread.start();
    }
}
