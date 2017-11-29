package it.sevenbits.formatter.io.reader.implementation;

import it.sevenbits.app.io.reader.implementation.FileReader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    @Test
    public void openAndReadTest() throws Exception {
        FileReader f = new FileReader("src/test/resources/in.test");//{test()}

        StringBuilder sb = new StringBuilder();
        while (f.readNext()) {
            sb.append(f.getChar());
        }
        f.close();
        assertEquals("{test()}" , sb.toString());
    }

}
