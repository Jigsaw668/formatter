package contain;

import contain.io.ioString.OutputString;
import contain.io.ioString.InputString;
import org.junit.Test;

import static org.junit.Assert.*;

public class StartFormatTest {

    @Test
    public void firstSimpleTest() throws Exception {
        String InputString = "{}";
        String ExpectedString = "{\n}\n";

        InputString in = new InputString(InputString);
        OutputString out = new OutputString();
        Formatter.format(in , out);
        String OutString = out.getSt();
        assertEquals(ExpectedString , OutString);

    }

}