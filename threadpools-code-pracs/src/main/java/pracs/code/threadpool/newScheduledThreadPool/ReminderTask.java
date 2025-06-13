package pracs.code.threadpool.newScheduledThreadPool;

import java.util.concurrent.Callable;

// Simulate sending a reminder
class ReminderTask implements Callable<String> {
    private final String customerName;

    public ReminderTask(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String call() {
        return "📧 Reminder sent to " + customerName + " [" + Thread.currentThread().getName() + "]";
    }
}