package it.sevenbits.formatter;

import it.sevenbits.formatter.io.ioString.OutString;
import it.sevenbits.formatter.io.ioString.InString;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterTest {

    private Formatter formatter;

    @Before
    public void init() {
        formatter = new Formatter();
    }

    @Test
    public void firstSimpleTest() throws Exception {
        String InputString = "{}";
        String ExpectedString = "{\n}\n";//

        InString in = new InString(InputString);
        OutString out = new OutString();

        formatter.format(in , out);

        String OutString = out.getString();
        assertEquals(ExpectedString , OutString);

    }

    @Test
    public void oneLevelTest() throws Exception {
        String InputString = "{test();}";
        String ExpectedString = "{\n    test();\n}\n";

        InString in = new InString(InputString);
        OutString out = new OutString();

        formatter.format(in , out);

        String OutString = out.getString();
        assertEquals(ExpectedString , OutString);
    }

    @Test
    public void SecondLevelTest() throws Exception {
        String InputString = "{test();{}}";
        String ExpectedString = "{\n    test();\n    {\n    }\n}\n";

        InString in = new InString(InputString);
        OutString out = new OutString();

        formatter.format(in , out);

        String OutString = out.getString();
        assertEquals(ExpectedString , OutString);
    }

    @Test
    public void notValidInputTest() throws Exception {
        String InputString = "{\n  test();\n    {\n    }\n}\n";
        String ExpectedString = "{\n  test();\n    {\n    }\n}\n";

        InString in = new InString(InputString);
        OutString out = new OutString();

        formatter.format(in , out);

        String OutString = out.getString();
        assertEquals(ExpectedString , OutString);
    }
}
