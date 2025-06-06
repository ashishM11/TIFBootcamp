package pracs.code.odd_even_example;

public class OddEvenMain {

    public static void main(String[] args) {

        Printer printer = new Printer();
        int max = 10;

        Runnable oddRun = () -> {
            for (int i = 1; i <= max; i += 2) {
                try {
                    printer.printOdd(i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable evenRun = () -> {
            for (int i = 2; i <= max; i += 2) {
                try {
                    printer.printEven(i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };


        Thread oddThread = new Thread(oddRun);
        Thread evenThread = new Thread(evenRun);

        oddThread.start();
        evenThread.start();

    }

}
