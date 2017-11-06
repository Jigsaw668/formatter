package contain.ioString;

import contain.exceptions.OutputException;
import contain.io.ioString.OutputString;

import org.junit.Test;
import static org.junit.Assert.*;

public class OutputStringTest {
    @Test
    public void WriteSingleCharTest() throws Exception {
        OutputString out = new OutputString();
        out.writeChar('1');
        assertEquals("1", out.getSt());
    }

    @Test
    public void WriteSomeCharsTest() throws OutputException {
        String st = "string";
        OutputString out = new OutputString();

        for (int i = 0, n = st.length(); i < n; i++) {
            out.writeChar(st.charAt(i));
        }
        assertEquals(out.getSt(), st);
    }

}
