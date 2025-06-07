package pracs.code.deadlock;

public class Main {

    public static void main(String[] args) {
        SeatBooking seatBooking = new SeatBooking();
        Payment payment = new Payment();

        Thread thread1 = new Thread(() -> seatBooking.bookSeat(payment), "Customer-1");
        Thread thread2 = new Thread(() -> payment.makePayment(seatBooking), "Customer-2");

        thread1.start();
        thread2.start();
    }

}
