package software.ulpgc.kata2;

import software.ulpgc.kata2.io.CsvLaptopReader;
import software.ulpgc.kata2.io.LaptopReader;
import software.ulpgc.kata2.io.LaptopWriter;
import software.ulpgc.kata2.io.TextLaptopWriter;
import software.ulpgc.kata2.model.Laptop;
import software.ulpgc.kata2.model.LaptopStatistics;

import java.io.*;
import java.net.URI;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        LaptopReader reader = new CsvLaptopReader();
        LaptopWriter writer = new TextLaptopWriter();

        try {
            List<Laptop> laptopsFromFile;

            try (InputStream input = new FileInputStream(
                    "src/main/resources/laptops.csv"
            )) {
                laptopsFromFile = reader.readAll(input);
            }

            String fileSummary =
                    LaptopStatistics.summary(laptopsFromFile);

            writer.write(fileSummary, System.out);

            try (OutputStream output =
                         new FileOutputStream("resultado.txt")) {
                writer.write(fileSummary, output);
            }

            List<Laptop> laptopsFromUrl;

            try (InputStream input = URI.create(
                    "https://raw.githubusercontent.com/"
                            + "37Degrees/DataSets/master/laptops.csv"
            ).toURL().openStream()) {
                laptopsFromUrl = reader.readAll(input);
            }

            String urlSummary =
                    LaptopStatistics.summary(laptopsFromUrl);

            System.out.println(
                    "\nLos resúmenes coinciden: "
                            + fileSummary.equals(urlSummary)
            );

        } catch (IOException | UncheckedIOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}