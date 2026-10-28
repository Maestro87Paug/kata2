package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Laptop;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvLaptopReader implements LaptopReader {

    @Override
    public List<Laptop> readAll(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(input, StandardCharsets.UTF_8)
        );

        return loadFrom(reader.lines().toList());
    }

    private List<Laptop> loadFrom(List<String> lines) throws IOException {
        List<Laptop> laptops = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            if (!lines.get(i).isBlank()) {
                laptops.add(loadFrom(lines.get(i)));
            }
        }

        return laptops;
    }

    private Laptop loadFrom(String line) throws IOException {
        List<String> fields = splitCsv(line);

        if (fields.size() < 3) {
            throw new IOException("Fila incorrecta: " + line);
        }

        String manufacturer = fields.get(0).trim();
        String modelName = fields.get(1).trim();
        String category = fields.get(2).trim();

        if (manufacturer.isEmpty()
                || modelName.isEmpty()
                || category.isEmpty()) {
            throw new IOException("Fila con datos vacíos: " + line);
        }

        return new Laptop(manufacturer, modelName, category);
    }

    private List<String> splitCsv(String line) throws IOException {
        List<String> fields = new ArrayList<>();
        StringBuilder field = new StringBuilder();
        boolean insideQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char character = line.charAt(i);

            if (character == '"') {
                // Dos comillas dentro de un campo representan una comilla.
                if (insideQuotes && i + 1 < line.length()
                        && line.charAt(i + 1) == '"') {
                    field.append('"');
                    i++;
                } else {
                    insideQuotes = !insideQuotes;
                }
            } else if (character == ',' && !insideQuotes) {
                fields.add(field.toString());
                field.setLength(0);
            } else {
                field.append(character);
            }
        }

        if (insideQuotes) {
            throw new IOException("Fila con comillas sin cerrar: " + line);
        }

        fields.add(field.toString());
        return fields;
    }
}
