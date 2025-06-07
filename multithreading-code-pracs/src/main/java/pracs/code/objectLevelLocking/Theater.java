/*

Definition:
    When a thread locks an object instance using synchronized on non-static methods or a synchronized block on this, it is object-level locking. 
    Only one thread can access the synchronized method/block per instance at a time.

Use Case:
    You have multiple screens (each screen is a separate instance of Theater). Each screen manages its own seats independently.
 
 */

package pracs.code.objectLevelLocking;

class Theater {

    int availableSeats = 10;

    // Object-level lock
    public synchronized void bookSeat(String customer, int seats) {
        if (seats <= availableSeats) {
            System.out.println(customer + " booked " + seats + " seat(s).");
            availableSeats -= seats;
        } else {
            System.out.println(customer + " could not book. Not enough seats.");
        }
    }
}