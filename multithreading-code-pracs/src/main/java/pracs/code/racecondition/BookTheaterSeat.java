package pracs.code.racecondition;

public class BookTheaterSeat {

    int total_seat = 10;

    public void bookMySeat(int seats) {
        if (total_seat >= seats) {
            System.out.printf(" No. of Seats Booked Successfully : %d\n", seats);
            total_seat = total_seat - seats;
            System.out.printf(" No. of Seats Left for Booking : %d\n", total_seat);
        } else {
            System.out.println(" Seats cannot be booked.");
            System.out.printf(" Seats Left : %d\n", total_seat);
        }
    }
}
