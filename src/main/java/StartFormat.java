import contain.Formatter;
import contain.Io.InputString;
import contain.Io.OutputStreamWrite;
import contain.interfaces.Input;
import contain.interfaces.Output;

import java.io.IOException;

/**
 * StartFormat
 */

public class StartFormat {
    public static void main(String[] args) {

        String testString = "a;int a;void(){method;aaaa;if(){if(){}}}";

        Input input = new InputString(testString);
        Output output = new OutputStreamWrite();

        try {
            Formatter.format(input, output);
            output.close();
            input.close();
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
