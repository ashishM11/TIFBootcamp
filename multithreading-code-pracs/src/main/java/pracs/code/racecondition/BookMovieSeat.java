package pracs.code.racecondition;

public class BookMovieSeat implements Runnable{

    private final int noOfSeats;
    private final BookTheaterSeat bookTheaterSeat;

    public BookMovieSeat(int noOfSeats, BookTheaterSeat bookTheaterSeat) {
        this.noOfSeats = noOfSeats;
        this.bookTheaterSeat = bookTheaterSeat;
    }

    @Override
    public void run() {
        bookTheaterSeat.bookMySeat(noOfSeats);
    }
}
