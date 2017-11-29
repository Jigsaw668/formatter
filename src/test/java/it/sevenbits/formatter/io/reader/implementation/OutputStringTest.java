package it.sevenbits.formatter.io.reader.implementation;

import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.io.writer.implementation.StringWriter;

import org.junit.Test;
import static org.junit.Assert.*;

public class OutputStringTest {
    @Test
    public void WriteSingleCharTest() throws Exception {
        StringWriter out = new StringWriter();
        out.write('1');
        assertEquals("1", out.toString());
    }

    @Test
    public void WriteSomeCharsTest() throws WriterException {
        String st = "string";
        StringWriter out = new StringWriter();

        for (int i = 0, n = st.length(); i < n; i++) {
            out.write(st.charAt(i));
        }
        assertEquals(out.toString(), st);
    }

}
