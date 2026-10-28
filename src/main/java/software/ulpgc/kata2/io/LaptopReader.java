package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Laptop;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface LaptopReader {
    List<Laptop> readAll(InputStream input) throws IOException;
}