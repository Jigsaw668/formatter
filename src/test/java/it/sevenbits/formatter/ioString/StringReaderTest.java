package it.sevenbits.formatter.ioString;

import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.reader.implementation.StringReader;
import it.sevenbits.app.io.reader.IReader;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringReaderTest {
    @Test
    public void getSingleCharTest() throws ReaderException {

        char ch = '1';
        IReader in = new StringReader("" + ch);
        assertTrue(in.readNext());
        assertEquals(ch, in.getChar());
    }

    @Test
    public void getManyCharsTest() throws ReaderException {
        String st = "string";
        StringReader in = new StringReader(st);

        for (int i = 0, n = st.length(); i < n; i++) {
            in.readNext();
            assertEquals(st.charAt(i), in.getChar());
        }
    }
}
