
public class threading extends Thread {
    
    @Override
    public void run(){
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "Counts" + i);
        }
    
    }

    public static void main(String[] args) {
        
        Thread thread = new Thread();

        thread.start();
    }
}
