
package Thread;

public class Threading4 implements Runnable {

    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "Counts " + i);
        }
    }
    public static void main(String[] args) {

        Threading4 runObj1 = new Threading4();

        Threading4 runObj2 = new Threading4();

        Thread t1 = new Thread(runObj1, "My first thread");

        Thread t2 = new Thread(runObj1, "My second thread");

        Thread t3 = new Thread(runObj2, "My third thread");

        t1.start();

        t2.start();

        t3.start();

    }
}
