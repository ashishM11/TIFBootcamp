package pracs.code.cyclicbarrier;

import java.util.concurrent.*;

/*
* Imagine a group of friends (say 5) want to enter the movie theater together, but:

    Each one is booking their seat individually (handled by separate threads).

    No one should enter the hall until all friends have finished booking.

    Once all 5 have finished, they enter together.
* */

public class BookingWithCyclicBarrier {

    static class FriendBookingTask implements Runnable {
        private final String friendName;
        private final CyclicBarrier barrier;

        public FriendBookingTask(String friendName, CyclicBarrier barrier) {
            this.friendName = friendName;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": " + friendName + " is booking a ticket...");

            try {
                Thread.sleep((int)(Math.random() * 2000)); // Simulate booking time
                System.out.println(threadName + ": " + friendName + " finished booking.");
                barrier.await(); // Wait for others
                System.out.println(threadName + ": " + friendName + " enters the theater 🎥");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int friendCount = 5;

        // Barrier action: Run once all friends reach the barrier
        Runnable onAllBooked = () -> System.out.println("🎉 All friends finished booking — Let's go in together!");

        CyclicBarrier barrier = new CyclicBarrier(friendCount, onAllBooked);

        try (ExecutorService executor = Executors.newFixedThreadPool(friendCount)) {

            String[] friends = {"Alice", "Bob", "Charlie", "Diana", "Ethan"};

            for (String friend : friends) {
                executor.submit(new FriendBookingTask(friend, barrier));
            }

            executor.shutdown();
        }
    }
}
