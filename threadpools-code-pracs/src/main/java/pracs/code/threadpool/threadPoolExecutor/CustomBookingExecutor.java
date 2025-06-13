package pracs.code.threadpool.threadPoolExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/*
*
*   You're managing a movie theater where:

    You want full control over ticketing operations.

    You decide how many agents are always on duty, how many you can scale up to, and how many customers can wait in line.
*/

public class CustomBookingExecutor {

    // Simulate a booking task
    static class BookingTask implements Callable<String> {
        private final String customerName;

        public BookingTask(String customerName) {
            this.customerName = customerName;
        }

        @Override
        public String call() throws Exception {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is booking for " + customerName);
            Thread.sleep(1000); // Simulate booking time
            return "✅ Booking confirmed for " + customerName + " by " + threadName;
        }
    }

    public static void main(String[] args) throws Exception {
        int corePoolSize = 2;
        int maxPoolSize = 4;
        long keepAliveTime = 5; // seconds
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);

        // Create custom thread pool executor
        ThreadPoolExecutor customExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                queue
        );

        String[] customers = {
                "Alice", "Bob", "Charlie", "Diana", "Ethan",
                "Fiona", "George", "Hannah", "Iris", "Jake"
        };

        List<Future<String>> results = new ArrayList<>();

        // Submit booking tasks
        for (String customer : customers) {
            Future<String> result = customExecutor.submit(new BookingTask(customer));
            results.add(result);
        }

        // Get results
        for (Future<String> result : results) {
            System.out.println(result.get());
        }

        customExecutor.shutdown();
    }

}
