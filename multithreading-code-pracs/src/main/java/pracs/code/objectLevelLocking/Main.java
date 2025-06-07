package pracs.code.objectLevelLocking;

public class Main {
    public static void main(String[] args) {
        Theater screen1 = new Theater(); // One screen
        Theater screen2 = new Theater(); // Another screen

        Thread t1 = new Thread(() -> screen1.bookSeat("Alice", 4));
        Thread t2 = new Thread(() -> screen1.bookSeat("Bob", 7));
        Thread t3 = new Thread(() -> screen2.bookSeat("Charlie", 6)); // Different instance

        t1.start();
        t2.start();
        t3.start();
    }
}

/*
 * 
Observation:

    t1 and t2 operate on the same screen (object-level locking applies), but t3 operates on a different instance (screen2) and is not affected.

 * 
 */