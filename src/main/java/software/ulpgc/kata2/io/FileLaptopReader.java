package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Laptop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileLaptopReader implements LaptopReader {
    private final File file;

    public FileLaptopReader(File file) {
        this.file = file;
    }

    @Override
    public List<Laptop> readAll() {
        try {
            return loadFrom(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Laptop> loadFrom(InputStream is) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            return loadFrom(reader.lines().toList());
        }
    }

    private List<Laptop> loadFrom(List<String> lines) {
        List<Laptop> list = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            list.add(loadFrom(lines.get(i)));
        }
        return list;
    }

    private Laptop loadFrom(String line) {
        return loadFrom(line.split(","));
    }

    private Laptop loadFrom(String[] fields) {
        return new Laptop(fields[0], fields[1], fields[2]);
    }
}