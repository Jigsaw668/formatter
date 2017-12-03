package it.sevenbits.formatter.io.writer.implementation;


import it.sevenbits.app.io.writer.implementation.FileWriter;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class FileWriterTest {

    @Test
    public void simpleWriteTest() throws Exception {
        String ExpectString = "{}test;";
        String filename = "src/test/resources/out.test";
        FileWriter f = new FileWriter(filename);
        for (int i = 0 , n = ExpectString.length(); i < n; i++) {
            f.writeChar(ExpectString.charAt(i));
        }
        f.close();

        String content = Files.readAllLines(Paths.get(filename)).toString();
        assertEquals("[" +  ExpectString + "]", content);
    }
}