package pracs.code.callableInterface;


//Runnable – "Just Do It, No Feedback Needed"

public class RunnableExample {

    public static void main(String[] args) {

        // Runnable is used when you just want the task to be done — you don’t care about any result, and you don’t expect any return value.
        Runnable task = () ->{
            String bookingId = "BKID" + (int)(Math.random() * 10000);
            System.out.println(Thread.currentThread().getName()+" (Runnable) is booking a ticket..."+bookingId);
            // No return value
        };

        Thread customer1 = new Thread(task,"Cust1");
        Thread customer2 = new Thread(task,"Cust2");
        Thread customer3 = new Thread(task,"Cust3");

        customer1.start();
        customer2.start();
        customer3.start();

    }

}
