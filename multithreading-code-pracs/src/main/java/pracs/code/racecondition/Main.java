package pracs.code.racecondition;

public class Main {

    public static void main(String[] args) {

        BookTheaterSeat bookTheaterSeat = new BookTheaterSeat();

        Thread customer1 = new Thread(new BookMovieSeat(5,bookTheaterSeat), "Customer 1 Thread");
        Thread customer2 = new Thread(new BookMovieSeat(4,bookTheaterSeat), "Customer 2 Thread");
        Thread customer3 = new Thread(new BookMovieSeat(6,bookTheaterSeat), "Customer 3 Thread");

        customer3.setPriority(9);

        customer1.start();
        customer3.start();
        customer2.start();

    }

}
