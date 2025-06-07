package pracs.code.classLevelLocking;

public class Main {
    public static void main(String[] args) {
        Theater screen1 = new Theater();
        Theater screen2 = new Theater();

        Thread t1 = new Thread(() -> Theater.bookSeat("Alice", 20));
        Thread t2 = new Thread(() -> Theater.bookSeat("Bob", 25));
        Thread t3 = new Thread(() -> Theater.bookSeat("Charlie", 10));

        t1.start();
        t2.start();
        t3.start();
    }
}

/*
 * Even though you may have multiple Theater instances, all threads share the same lock for the bookSeat method.
 */