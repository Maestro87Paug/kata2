package software.ulpgc.kata2;

import software.ulpgc.kata2.io.*;
import software.ulpgc.kata2.model.LaptopStatistics;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        LaptopReader reader = new CsvLaptopReader();
        LaptopWriter writer = new TextLaptopWriter();
        Path path = Path.of("src/main/resources/laptops.csv");

        try {
            String fileSummary;
            String memorySummary;

            try (InputStream input = Files.newInputStream(path)) {
                fileSummary = LaptopStatistics.summary(reader.readAll(input));
            }

            try (InputStream input = new ByteArrayInputStream(
                    Files.readAllBytes(path)
            )) {
                memorySummary = LaptopStatistics.summary(reader.readAll(input));
            }

            if (!fileSummary.equals(memorySummary)) {
                throw new IOException("Los resúmenes son diferentes");
            }

            writer.write(fileSummary, System.out);

            try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
                writer.write(fileSummary, output);

                System.out.println("\nResumen guardado en memoria:");
                System.out.print(output.toString(StandardCharsets.UTF_8));
            }

        } catch (IOException | UncheckedIOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}