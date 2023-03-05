

public class question7alt {
    public static void main(String[] args) {
        
        Runnable run1 = () -> {

            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "Counts of run1 : " + i);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            
            
        };

        Thread t1 = new Thread(run1);
        t1.setName("T1 ");
        t1.start();

        Runnable run2 = () -> {
  
           for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "Counts of run2 : " + i);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        };
        Thread t2 = new Thread(run2);
        t2.setName("T2 ");
        t2.start();
        
    }
}
