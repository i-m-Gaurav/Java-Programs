package Thread;

public class Threading2 implements Runnable {

  
    public void run() {

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "Counts " + i );
        }
        
    }

    public static void main(String[] args) {

        Threading2 t2 = new Threading2();
        
        Thread t1 = new Thread(t2);

        t1.setName("My new Thread ");


        t1.start();
        
    }
    
}
