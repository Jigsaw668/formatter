package it.sevenbits.formatter.ioFile;

import it.sevenbits.app.io.reader.implementation.FileReader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    @Test
    public void openAndReadTest() throws Exception {
        FileReader f = new FileReader("src/test/in.test");//{test()}

        StringBuilder sb = new StringBuilder();
        while (f.readChar()) {
            sb.append(f.hasMoreChars());
        }
        f.close();
        assertEquals("{test()}" , sb.toString());
    }

}
