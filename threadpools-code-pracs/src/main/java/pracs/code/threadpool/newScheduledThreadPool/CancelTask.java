package pracs.code.threadpool.newScheduledThreadPool;

import java.util.concurrent.Callable;

// Simulate auto-cancel task
public class CancelTask implements Callable<String> {
    private final String customerName;

    public CancelTask(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String call() {
        return "❌ Booking auto-cancelled for " + customerName + " due to no payment [" + Thread.currentThread().getName() + "]";
    }
}
