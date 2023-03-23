import java.util.Scanner;

public class PrintTableN {
    static int num = 1;
    static Object lock = new Object();

    public static void main(String[] args) {
        System.out.print("Enter the First Number of the Table = ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Runnable printOdd = () -> {
            while (num < 10) {
                synchronized (lock) {
                    if (num % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " " + num * n);
                    num++;
                    lock.notifyAll();
                }
            }
        };

        Runnable printEven = () -> {
            while (num < 10) {
                synchronized (lock) {
                    if (num % 2 == 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " " + num * n);
                    num++;
                    lock.notifyAll();
                }
            }
        };

        Thread t1 = new Thread(printOdd);
        Thread t2 = new Thread(printEven);

        t1.start();
        t2.start();
    }
}
