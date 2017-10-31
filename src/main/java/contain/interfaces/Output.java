package contain.interfaces;

import java.io.IOException;
import java.io.Writer;

public interface Output {
    public void setStream(Writer stream);
    public void WriteChar(char ch) throws IOException;
    public void close() throws IOException;
}
