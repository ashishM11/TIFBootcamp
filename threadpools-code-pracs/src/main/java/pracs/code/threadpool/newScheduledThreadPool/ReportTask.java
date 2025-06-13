package pracs.code.threadpool.newScheduledThreadPool;

// Simulate a periodic task (e.g. daily report)
public class ReportTask implements Runnable {
    @Override
    public void run() {
        System.out.println("📊 Generating booking report... [" + Thread.currentThread().getName() + "]");
    }
}