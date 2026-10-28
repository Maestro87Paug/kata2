package software.ulpgc.kata2;

import software.ulpgc.kata2.io.*;
import software.ulpgc.kata2.model.LaptopStatistics;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        LaptopReader reader = new CsvLaptopReader();
        LaptopWriter writer = new TextLaptopWriter();

        try {
            String fileSummary;
            String resourceSummary;

            try (InputStream input = new FileInputStream(
                    "src/main/resources/laptops.csv"
            )) {
                fileSummary = LaptopStatistics.summary(reader.readAll(input));
            }

            try (InputStream input =
                         Main.class.getResourceAsStream("/laptops.csv")) {
                if (input == null) {
                    throw new IOException("No se encuentra laptops.csv");
                }

                resourceSummary =
                        LaptopStatistics.summary(reader.readAll(input));
            }

            if (!fileSummary.equals(resourceSummary)) {
                throw new IOException("Los resúmenes son diferentes");
            }

            writer.write(fileSummary, System.out);

            try (OutputStream output = new FileOutputStream("resultado.txt")) {
                writer.write(fileSummary, output);
            }

        } catch (IOException | UncheckedIOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}