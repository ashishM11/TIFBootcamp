package pracs.code.countdownlatch;

import java.util.concurrent.*;

/*
* Imagine a movie theater where:

The movie will not start until all customers have booked their seats.

There is one screen manager (main thread) waiting for a signal: “All seats booked!”

Multiple ticket agents (threads) are handling bookings in parallel.

We use a CountDownLatch to make the main thread wait until all bookings are complete.
* */


public class BookingWithCountDownLatch {

    static class BookingTask implements Runnable {
        private final String customerName;
        private final CountDownLatch latch;

        public BookingTask(String customerName, CountDownLatch latch) {
            this.customerName = customerName;
            this.latch = latch;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is booking for " + customerName);
            try {
                Thread.sleep(1000); // Simulate booking time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " finished booking for " + customerName);
            latch.countDown(); // Signal task is done
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int customerCount = 5;
        CountDownLatch latch = new CountDownLatch(customerCount);

        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {// 3 agents

            String[] customers = {"Alice", "Bob", "Charlie", "Diana", "Ethan"};

            // Submit booking tasks
            for (String customer : customers) {
                executor.submit(new BookingTask(customer, latch));
            }

            System.out.println("🎬 Waiting for all bookings to complete...");

            latch.await(); // Main thread waits here

            System.out.println("✅ All bookings completed! Movie starts now! 🍿");

            executor.shutdown();
        }
    }
}
