package it.sevenbits.app.io.closeable;

/**
 * A ICloseable is a source or destination of data that can be closed.
 * The close method is invoked to release resources that the object is holding (such as open files).
 */
public interface ICloseable extends AutoCloseable {

    @Override
    void close() throws CloseableException;
}
