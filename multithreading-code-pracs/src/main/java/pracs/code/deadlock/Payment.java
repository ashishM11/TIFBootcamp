package pracs.code.deadlock;

class Payment {

    public void makePayment(SeatBooking seatBooking) {

        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + ": Holding Payment lock...");
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}

            System.out.println(Thread.currentThread().getName() + ": Waiting for SeatBooking lock...");
            synchronized (seatBooking) {
                System.out.println(Thread.currentThread().getName() + ": Payment processed and seat booked.");
            }
        }
        
    }

}
