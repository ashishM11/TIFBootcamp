package pracs.code.odd_even_example;

public class Printer {

    private boolean isOddTurn = true;

    public synchronized void printEven(int num) throws InterruptedException {
        while (isOddTurn) {
            wait();
        }
        System.out.println("Even : " + num);
        isOddTurn = true;
        notify();
    }

    public synchronized void printOdd(int num) throws InterruptedException {
        while (!isOddTurn) {
            wait();
        }
        System.out.println("Odd : " + num);
        isOddTurn = false;
        notify();
    }

}
