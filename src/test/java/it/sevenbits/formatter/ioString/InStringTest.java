package it.sevenbits.formatter.ioString;

import it.sevenbits.formatter.io.exceptions.InputException;
import it.sevenbits.formatter.io.ioString.InString;
import it.sevenbits.formatter.io.interfaces.InputInterface;

import org.junit.Test;
import static org.junit.Assert.*;

public class InStringTest {
    @Test
    public void getSingleCharTest() throws InputException {

        char ch = '1';
        InputInterface in = new InString("" + ch);
        assertTrue(in.forNext());
        assertEquals(ch, in.getChar());
    }

    @Test
    public void getManyCharsTest() throws InputException {
        String st = "string";
        InString in = new InString(st);

        for (int i = 0, n = st.length(); i < n; i++) {
            in.forNext();
            assertEquals(st.charAt(i), in.getChar());
        }
    }
}
