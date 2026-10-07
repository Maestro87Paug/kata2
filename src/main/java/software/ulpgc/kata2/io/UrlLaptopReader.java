package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Laptop;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UrlLaptopReader implements LaptopReader {
    private final URL url;

    public UrlLaptopReader(URL url) {
        this.url = url;
    }

    @Override
    public List<Laptop> readAll() {
        try {
            return loadFrom(url.openStream());
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
        // fields[0] = Manufacturer, fields[1] = Model Name, fields[2] = Category
        return new Laptop(fields[0], fields[1], fields[2]);
    }
}