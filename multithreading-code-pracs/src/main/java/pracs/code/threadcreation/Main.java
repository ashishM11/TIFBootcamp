package pracs.code.threadcreation;


public class Main {


    public static void main(String[] args) {

        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println("Current Thread : "+ Thread.currentThread().getName() + " Started.");
        Thread th1 = new Thread(new ThreadUsingExtend(),"Extended Thread");

        Thread th2 = new Thread(new ThreadUsingImplement(),"Implement Thread");
//        th2.setPriority(Thread.MAX_PRIORITY);

        ThreadUsingLambda threadUsingLambda = new ThreadUsingLambda();
        Thread th3 = threadUsingLambda.runThreadUsingLambda();


        th1.start();
        th2.start();
        th3.start();

        System.out.println("Current Thread : "+ Thread.currentThread().getName() + " Ended.");
    }

}