package contain.Io;

import contain.interfaces.Output;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWrite implements Output {
    private OutputStreamWriter output;

    public OutputStreamWrite() {
        output = new OutputStreamWriter(System.out);
    }

    public void setStream(Writer stream) {

    }

    public void WriteChar(char ch) throws IOException {
        output.write(ch);
    }


    public void close() throws IOException {
        output.close();
    }
}