package pracs.code.threadpool.newCachedThreadPool;

import java.util.Random;
import java.util.concurrent.Callable;

public class BookingTask implements Callable<String> {

    private final String customerName;

    public BookingTask(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is booking for " + customerName);
        // Simulate booking time
        Thread.sleep(new Random().nextInt(1000) + 500);
        return "Booking confirmed for " + customerName + " by " + Thread.currentThread().getName();
    }

}
