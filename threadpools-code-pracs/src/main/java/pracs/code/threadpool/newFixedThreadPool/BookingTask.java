package pracs.code.threadpool.newFixedThreadPool;

// Task representing a customer's seat booking
public class BookingTask implements Runnable {

    private final String customerName;

    public BookingTask(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started booking for " + customerName);
        try {
            // Simulate time taken to book a seat
            Thread.sleep(2000); // 2 seconds per booking
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + " finished booking for " + customerName);
    }

}
