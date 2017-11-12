package it.sevenbits.formatter.ioFile;

import it.sevenbits.formatter.io.ioFiles.InFile;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InFileTest {

    @Test
    public void openAndReadTest() throws Exception {
        InFile f = new InFile("/home/jigsaw/src/main/java/formatter/src/test/java/it/sevenbits/formatter/ioFile/in.test");//{test()}

        StringBuilder sb = new StringBuilder();
        while (f.readNext()) {
            sb.append(f.getChar());
        }
        f.close();
        assertEquals("{test()}" , sb.toString());
    }

}
