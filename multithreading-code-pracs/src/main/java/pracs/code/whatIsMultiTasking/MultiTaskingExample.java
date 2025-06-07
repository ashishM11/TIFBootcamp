package pracs.code.whatIsMultiTasking;

import java.io.IOException;

public class MultiTaskingExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Runtime.getRuntime().exec("java ./ProgramA");
        // Runtime.getRuntime().exec("java ./ProgramB");

        Runtime.getRuntime().exec("Calc");
        Runtime.getRuntime().exec("Notepad");
    }

}
