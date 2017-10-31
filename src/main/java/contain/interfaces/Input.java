package contain.interfaces;

import java.io.IOException;

public interface Input {
    public boolean readNext() throws IOException;
    public char getChar();
    public void close() throws IOException;
}
