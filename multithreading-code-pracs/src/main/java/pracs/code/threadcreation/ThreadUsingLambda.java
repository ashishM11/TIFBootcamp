package pracs.code.threadcreation;

public class ThreadUsingLambda {

    public Thread runThreadUsingLambda() {

        Runnable task = () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.printf("Number Printed via  %s, and Number is %d :%n", Thread.currentThread().getName(), i);
            }
        };

        return new Thread(task,"Lambda Thread");
    }

}
