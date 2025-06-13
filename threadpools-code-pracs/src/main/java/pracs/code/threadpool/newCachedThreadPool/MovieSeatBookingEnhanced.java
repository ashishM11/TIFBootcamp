package pracs.code.threadpool.newCachedThreadPool;

import java.util.*;
import java.util.concurrent.*;

public class MovieSeatBookingEnhanced {

    public static void main(String[] args) {
        try (ExecutorService bookingAgents = Executors.newCachedThreadPool()) {

            String[] customers = {
                    "Alice", "Bob", "Charlie", "Diana", "Ethan",
                    "Fiona", "George", "Hannah", "Iris", "Jake"
            };

            Map<String, Future<String>> futureMap = new LinkedHashMap<>();

            for (String customer : customers) {

                Callable<String> task = ()->{
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " started booking for " + customer);

                    // Random delay (some may be long)
                    int delay = new Random().nextInt(2000) + 500;
                    Thread.sleep(delay);

                    // Simulate random failure
                    if (new Random().nextInt(10) < 2) { // ~20% failure rate
                        throw new RuntimeException("❌ Booking failed for " + customer);
                    }

                    return "✅ Booking confirmed for " + customer + " by " + threadName + " (took " + delay + " ms)";
                };
                // Submit tasks
                Future<String> future = bookingAgents.submit(task);
                futureMap.put(customer, future);

                // Random arrival delay
                try {
                    Thread.sleep(new Random().nextInt(800));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Handle results with timeout and exception handling
            for (Map.Entry<String, Future<String>> entry : futureMap.entrySet()) {
                String customer = entry.getKey();
                Future<String> future = entry.getValue();

                try {
                    // Wait max 2 seconds per task
                    String result = future.get(2, TimeUnit.SECONDS);
                    System.out.println(result);
                } catch (TimeoutException e) {
                    future.cancel(true); // Cancel if taking too long
                    System.out.println("⏱️ Booking timed out for " + customer);
                } catch (ExecutionException e) {
                    System.out.println("❗ " + e.getCause().getMessage());
                } catch (InterruptedException e) {
                    System.out.println("⚠️ Booking interrupted for " + customer);
                }
            }
            bookingAgents.shutdown();
        }
    }
}

