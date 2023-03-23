public class thread7 extends Thread {
    private String message;
    private int delay;

    public thread7(String message, int delay) {
        this.message = message;
        this.delay = delay;
    }

    public void run() {
        int i=0;
        try {
            while (i<10) {
                System.out.println(message);
                Thread.sleep(delay);
                i++;
            }
        } catch (InterruptedException e) {
            // Thread interrupted
        }
    }

    public static void main(String[] args) {
        thread7 thread1 = new thread7("Hello from Thread 1!", 1000);
        thread7 thread2 = new thread7("Hello from Thread 2!", 2000);
        thread1.start();
        thread2.start();
    }
}
