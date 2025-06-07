package pracs.code.deadlock;

class SeatBooking {

    public void bookSeat(Payment payment) {

        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + ": Holding SeatBooking lock...");
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}

            System.out.println(Thread.currentThread().getName() + ": Waiting for Payment lock...");
            synchronized (payment) {
                System.out.println(Thread.currentThread().getName() + ": Seat booked and payment done.");
            }
        }

    }
}