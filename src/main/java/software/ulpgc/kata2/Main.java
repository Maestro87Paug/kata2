package software.ulpgc.kata2;

import software.ulpgc.kata2.io.*;
import software.ulpgc.kata2.model.Laptop;
import software.ulpgc.kata2.model.LaptopStatistics;

import java.io.*;
import java.net.URL;
import java.util.List;

public class Main {
    static void main(String[] args) throws IOException {

        URL url = new URL("https://raw.githubusercontent.com/37Degrees/DataSets/master/laptops.csv");
        LaptopReader urlReader = new UrlLaptopReader(url);
        List<Laptop> laptopsFromUrl = urlReader.readAll();


        LaptopReader fileReader = new FileLaptopReader(new File("src/main/resources/laptops.csv"));



        String resumen = LaptopStatistics.summary(laptopsFromUrl);


        LaptopWriter consoleWriter = new ConsoleLaptopWriter();
        consoleWriter.write(resumen, System.out);


        LaptopWriter fileWriter = new FileLaptopWriter(new File("resultado.txt"));
        fileWriter.write(resumen, new FileOutputStream("resultado.txt"));
    }
}