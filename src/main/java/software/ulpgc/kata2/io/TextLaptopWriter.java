package software.ulpgc.kata2.io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class TextLaptopWriter implements LaptopWriter {

    @Override
    public void write(String content, OutputStream output)
            throws IOException {
        output.write(content.getBytes(StandardCharsets.UTF_8));
        output.flush();
    }
}