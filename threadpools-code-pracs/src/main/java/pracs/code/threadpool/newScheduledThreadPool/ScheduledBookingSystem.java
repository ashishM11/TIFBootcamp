package pracs.code.threadpool.newScheduledThreadPool;

import java.util.concurrent.*;

/*
    Simulate:

        ✅ Send booking reminder after a delay.

        ❌ Auto-cancel unconfirmed booking if payment not received in time.

        📊 Daily report generation (simulated with a fixed-rate repeating task).

*/

public class ScheduledBookingSystem {

    public static void main(String[] args) {
        // Create a ScheduledThreadPool with 2 threads
        try (ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2)) {

            String customer = "Alice";

            // Schedule a reminder after 3 seconds
            ScheduledFuture<String> reminder = scheduler.schedule(
                    new ReminderTask(customer), 3, TimeUnit.SECONDS);

            // Schedule auto-cancel after 5 seconds
            ScheduledFuture<String> cancel = scheduler.schedule(
                    new CancelTask(customer), 5, TimeUnit.SECONDS);

            // Schedule a periodic report every 4 seconds (initial delay 2s)
            scheduler.scheduleAtFixedRate(new ReportTask(), 2, 4, TimeUnit.SECONDS);

            // Print results of scheduled Callables
            System.out.println(reminder.get());
            System.out.println(cancel.get());

            // Let the periodic task run a few times
            try {
                Thread.sleep(12000); // Let report run ~3 times
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            scheduler.shutdown();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
