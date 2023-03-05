

public class question6 {
    public static void main(String[] args) {
        // get user input for lower and upper limits
        int lowerLimit = Integer.parseInt(System.console().readLine("Enter lower limit: "));
        int upperLimit = Integer.parseInt(System.console().readLine("Enter upper limit: "));

        // create two objects to print numbers
        PrintNumbers pn1 = new PrintNumbers(lowerLimit, upperLimit/2);
        PrintNumbers pn2 = new PrintNumbers(upperLimit/2 + 1, upperLimit);

        // create two threads and start them
        Thread thread1 = new Thread(pn1);
        Thread thread2 = new Thread(pn2);

        thread1.start();
        thread2.start();
    }
}

class PrintNumbers implements Runnable {
    
    
    private int lowerLimit;
    private int upperLimit;

    public PrintNumbers(int lowerLimit, int upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public void run() {
        for (int num = lowerLimit; num <= upperLimit; num++) {
            System.out.println(num);
        }
    }

}
