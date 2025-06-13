package pracs.code.threadpool.newFixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    Simulating a fixed number of ticket agents (threads) handling multiple booking requests (tasks), with customers waiting in line (queue) when all agents are busy.

    What This Code Does:

       1. Only 3 threads (agents) work concurrently — pool-1-thread-1, -2, -3.

       2. The rest of the customers wait in a queue.

       3. Once an agent finishes one booking, they immediately take the next from the queue.

       4. No new threads are created beyond 3.

 */

public class MovieSeatBookingFixedThreadPool {

    public static void main(String[] args) {
        // Fixed thread pool with 3 agents (threads)
        try (ExecutorService bookingAgents = Executors.newFixedThreadPool(3)) {

            String[] customers = {
                    "Alice", "Bob", "Charlie", "Diana", "Ethan",
                    "Fiona", "George", "Hannah", "Iris", "Jake"
            };

            System.out.println("🎟️ Movie seat booking started...");

            // Submit booking tasks for each customer
            for (String customer : customers) {
                bookingAgents.submit(new BookingTask(customer));
            }

            // Shut down after submitting all tasks
            bookingAgents.shutdown();
        }
    }
}

