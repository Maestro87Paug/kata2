package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Laptop;

import java.util.List;

public interface LaptopReader {
    List<Laptop> readAll();
}
