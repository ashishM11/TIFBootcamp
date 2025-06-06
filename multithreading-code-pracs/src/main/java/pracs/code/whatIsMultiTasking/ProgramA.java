package pracs.code.whatIsMultiTasking;

public class ProgramA {

    public static void main(String[] args) {

        int counter = 0;

        while (counter < 10) {

            System.out.println("Program A is running");

            try {

                Thread.sleep(1000);

            } catch (InterruptedException ignored) {

            }
            counter++;
        }
    }

}
