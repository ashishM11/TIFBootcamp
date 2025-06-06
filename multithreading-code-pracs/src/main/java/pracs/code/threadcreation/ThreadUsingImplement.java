package pracs.code.threadcreation;

public class ThreadUsingImplement implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("Number Printed via  %s, and Number is %d :%n", Thread.currentThread().getName(), i);
        }
    }

}
