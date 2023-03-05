public class question7 implements Runnable {

    
    
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);
            try {
                Thread.sleep(500); // pause for half a second
            } catch (Exception e) {
               // e.printStackTrace();
            }
        }
        
    }

    public static void main(String[] args) {

        question7 q = new question7();

        Thread thread1 = new Thread(q,"Thread 1: ");
        Thread thread2 = new Thread(q,"Thread 2: ");

        thread1.start();
        thread2.start();
    }
}
