package it.sevenbits.app.stateMachine.formatter.implementation;

import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.stateMachine.ContextException;
import it.sevenbits.app.stateMachine.formatter.IContext;

/**
 *
 */
public class Context implements IContext {

    private final IWriter writer;
    private int indentLevel = 0;

    /**
     * @param writer writer
     */
    Context(final IWriter writer) {
        this.writer = writer;
    }

    @Override
    public void writeLexeme(final String lexeme) throws ContextException {
        try {
            for (char c : lexeme.toCharArray()) {
                writer.writeChar(c);
            }
        } catch (WriterException e) {
            throw new ContextException(e);
        }
    }

    @Override
    public void writeNewLine() throws ContextException {
        try {
            writer.writeChar('\n');
        } catch (WriterException e) {
            throw new ContextException(e);
        }
    }

    @Override
    public void writeIndent() throws ContextException {
        try {
            for (int i = 0; i < INDENT * indentLevel; i++) {
                writer.writeChar(' ');
            }
        } catch (WriterException we) {
            throw new ContextException(we);
        }
    }

    @Override
    public void incrementIndent() {
        indentLevel++;
    }

    @Override
    public void decrementIndent() {
        indentLevel--;
    }
}