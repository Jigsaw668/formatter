package contain.ioString;

import contain.exceptions.InputException;
import contain.interfaces.InputInterface;
import contain.io.ioString.InputString;

import org.junit.Test;
import static org.junit.Assert.*;

public class InputStringTest {
    @Test
    public void getSingleCharTest() throws InputException {

        char ch = '1';
        InputInterface in = new InputString("" + ch);
        assertTrue(in.readNext());
        assertEquals(ch, in.getChar());
    }

    @Test
    public void getManyCharsTest() throws InputException {
        String st = "string";
        InputString in = new InputString(st);

        for (int i = 0, n = st.length(); i < n; i++) {
            in.readNext();
            assertEquals(st.charAt(i), in.getChar());
        }
    }
}
