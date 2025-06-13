package pracs.code.threadpool.newSingleThreadExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
* Simulating Running a small movie theater. Due to limited staff or system constraints, you have only one ticket agent available at all times.

    All customers must:

    Wait their turn

    Be handled one at a time

    Be processed in order of arrival (FIFO)
* */


public class SingleThreadBooking {

    // Task simulating a booking request
    static class BookingTask implements Callable<String> {
        private final String customerName;

        public BookingTask(String customerName) {
            this.customerName = customerName;
        }

        @Override
        public String call() throws Exception {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is booking for " + customerName);
            Thread.sleep(1000); // Simulate 1s booking time
            return "✅ Booking confirmed for " + customerName + " by " + threadName;
        }
    }

    public static void main(String[] args) throws Exception {
        try (ExecutorService singleAgent = Executors.newSingleThreadExecutor()) {

            String[] customers = {
                    "Alice", "Bob", "Charlie", "Diana", "Ethan"
            };

            List<Future<String>> results = new ArrayList<>();

            // Submit tasks
            for (String customer : customers) {
                results.add(singleAgent.submit(new BookingTask(customer)));
            }

            // Retrieve results
            for (Future<String> result : results) {
                System.out.println(result.get());
            }

            singleAgent.shutdown();
        }
    }

}
