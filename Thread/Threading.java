package Thread;



public class Threading {
    public static void main(String[] args) {

        Thread t1 = new Thread(){
            @Override
            public void run(){
                
                for (int i = 0; i < 50; i++) {
                    System.out.println(this.getName() + "counts " + i);
                    
                }
            }
        };

        t1.setName("My Brand New Thread ");
        t1.start();

        
        
            
        

        
    }
}
