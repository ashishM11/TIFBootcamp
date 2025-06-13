package pracs.code.threadpool.newCachedThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
    Simulating customers arriving to book tickets at random intervals, and each booking task is handled by a thread from the cached thread pool.

    What This Code Does:

       1. Simulates 10 customers arriving randomly.

       2. Each customer is served by a thread (like a ticket agent).

       3. Threads are reused if idle, otherwise new threads are created.

       4. Tasks are short-lived (500ms–1500ms).

       5. Uses Executors.newCachedThreadPool() to demonstrate thread reuse and creation.

 */

public class MovieSeatBookingWithCallable  {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        try (ExecutorService bookingAgents = Executors.newCachedThreadPool()) {

            String[] customers = {
                    "Alice", "Bob", "Charlie", "Diana", "Ethan",
                    "Fiona", "George", "Hannah", "Iris", "Jake"
            };

            Random rand = new Random();
            List<Future<String>> futures = new ArrayList<>();

            for (String customer : customers) {
                try {
                    Thread.sleep(rand.nextInt(800)); // simulate random arrival
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Future<String> result = bookingAgents.submit(new BookingTask(customer));
                futures.add(result);
            }

            // Retrieve booking confirmations
            for (Future<String> future : futures) {
                System.out.println("✅ " + future.get()); // blocks until result is available
            }

            bookingAgents.shutdown();
        }

    }

}
