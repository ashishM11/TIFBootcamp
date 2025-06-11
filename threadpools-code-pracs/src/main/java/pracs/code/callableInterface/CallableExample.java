package pracs.code.callableInterface;

//Callable – "Do It and Tell Me What Happened"

import java.util.concurrent.*;

public class CallableExample {


    public static void main(String[] args) {

        Callable<String> task = ()->{
            // Simulate delay
            Thread.sleep(1000);
            String bookingId = "BKID" + (int)(Math.random() * 10000);
            return "Ticket booked successfully. Booking ID: " + bookingId;
        };


        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {

            Future<String> future = executor.submit(task); // Submit callable

            System.out.println("Booking in progress...");

            // Wait for result
            String result = future.get();
            System.out.println("Confirmation received: " + result);

            executor.shutdown();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
