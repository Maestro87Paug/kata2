package software.ulpgc.kata2.io;

import java.io.IOException;
import java.io.OutputStream;

public interface LaptopWriter {
    void write(String content, OutputStream output) throws IOException;
}