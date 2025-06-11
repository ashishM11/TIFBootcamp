package pracs.code.futureInterface;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


//Real-World Analogy: Movie Ticket Booking
//Imagine you go to a ticket counter, place a booking request, and receive a token number. The booking system processes it, and later you can use the token to get your ticket.

public class FutureExample {

    public static void main(String[] args) throws Exception {
        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {

            Callable<String> task = () -> {
                Thread.sleep(2000); // simulate delay
                return "🎫 Booking confirmed! Seat: A12, ID: BKID2025";
            };

            System.out.println("➡ Booking ticket...");
            Future<String> future = executor.submit(task); // Submits task to executor

            System.out.println("🕒 Doing something else while booking...");

            // Optionally check if done
            if (!future.isDone()) {
                System.out.println("⏳ Still processing...");
            }

            // Wait for the result (blocks until done)
            String result = future.get();
            System.out.println("✅ Received confirmation: " + result);

            executor.shutdown();
        }
    }

}
