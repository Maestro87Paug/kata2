package software.ulpgc.kata2.io;

import java.io.*;

public class FileLaptopWriter implements LaptopWriter {
    private final File file;

    public FileLaptopWriter(File file) {
        this.file = file;
    }

    @Override
    public void write(String content, OutputStream os) {
        try (OutputStream fileos = new FileOutputStream(file)) {
            fileos.write(content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}