package pracs.code.racecondition;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Main2 {

    private  static int count = 0;
//    private static AtomicInteger count = new AtomicInteger(0);
//    private static final ReentrantLock LOCK = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        //Runnable Task
        Runnable incrementCount = () ->{
           for(int i =1; i<=10000; i++){

//               Approach 1
//               synchronized (Main2.class){
//                   count++;
//               }

//               Approach 2
//               LOCK.lock();
//               try {
//                   count++;
//               }finally {
//                   if(LOCK.isLocked())
//                       LOCK.unlock();
//               }

//               Approach 3
//               count.incrementAndGet();


               count++;
           }
        } ;

        //Creating 2 threads to increment count by 1
        Thread th1 = new Thread(incrementCount);
        Thread th2 = new Thread(incrementCount);

        //Start Both the Threads
        th1.start();
        th2.start();

        //Waiting for Threads to Complete Execution
        th1.join();
        th2.join();

        // Printing final count value
        System.out.println("\nTotal Count value after Thread Execution : "+count);
    }

}
