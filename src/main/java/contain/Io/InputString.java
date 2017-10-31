package contain.Io;

import contain.interfaces.Input;

import java.io.IOException;
import java.lang.String;

public class InputString implements Input {
    public InputString(String str) {
        this.pos = -1;
        this.str = str;
    }

    private String str;
    private int pos;

    public boolean readNext() throws IOException {
        if (this.pos < this.str.length() - 1) {
            pos++;
            return true;
        }
        return false;
    }

    public char getChar() {
        return str.charAt(pos);
    }

    public void close() throws IOException {

    }

    public void reset() {
        pos = -1;
    }
}
