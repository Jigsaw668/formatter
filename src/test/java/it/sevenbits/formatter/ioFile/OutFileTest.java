package it.sevenbits.formatter.ioFile;


import it.sevenbits.formatter.io.ioFiles.OutFile;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class OutFileTest {

    private String filename = "/home/jigsaw/src/main/java/formatter/src/test/java/it/sevenbits/formatter/ioFile/out.test";

    @Test
    public void simpleWriteTest() throws Exception {
        String ExpectString = "{}test;";
        OutFile f = new OutFile(filename);
        for (int i = 0 , n = ExpectString.length(); i < n; i++) {
            f.writeChar(ExpectString.charAt(i));
        }
        f.close();

        String content = Files.readAllLines(Paths.get(filename)).toString();
        assertEquals("[" +  ExpectString + "]", content);
    }
}