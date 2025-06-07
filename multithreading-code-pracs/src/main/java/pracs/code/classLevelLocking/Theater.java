
/*
 * 
Definition:
    When a thread locks a class using synchronized on static methods or by synchronizing on ClassName.class, it is class-level locking. 
    It prevents any thread from entering any static synchronized method of that class across all instances.

Use Case:

    You have a centralized booking system (e.g., across all theaters), and you want to allow only one booking at a time across all screens.
 * 
 */

package pracs.code.classLevelLocking;

public class Theater {

    static int totalSeats = 50;

    // Class-level lock
    public static synchronized void bookSeat(String customer, int seats) {
        if (seats <= totalSeats) {
            System.out.println(customer + " booked " + seats + " seat(s).");
            totalSeats -= seats;
        } else {
            System.out.println(customer + " could not book. Not enough seats.");
        }
    }

}
