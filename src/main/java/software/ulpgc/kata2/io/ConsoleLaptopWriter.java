package software.ulpgc.kata2.io;

import java.io.IOException;
import java.io.OutputStream;

public class ConsoleLaptopWriter implements LaptopWriter {
    @Override
    public void write(String content, OutputStream os) {
        try {
            os.write(content.getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}