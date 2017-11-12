package it.sevenbits.formatter.ioString;

import it.sevenbits.formatter.io.exceptions.OutputException;
import it.sevenbits.formatter.io.ioString.OutString;

import org.junit.Test;
import static org.junit.Assert.*;

public class OutputStringTest {
    @Test
    public void WriteSingleCharTest() throws Exception {
        OutString out = new OutString();
        out.writeChar('1');
        assertEquals("1", out.getString());
    }

    @Test
    public void WriteSomeCharsTest() throws OutputException {
        String st = "string";
        OutString out = new OutString();

        for (int i = 0, n = st.length(); i < n; i++) {
            out.writeChar(st.charAt(i));
        }
        assertEquals(out.getString(), st);
    }

}
