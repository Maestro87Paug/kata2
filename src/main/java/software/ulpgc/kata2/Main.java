package software.ulpgc.kata2;


import software.ulpgc.kata2.io.*;
import software.ulpgc.kata2.model.Laptop;


import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {
     static void main(String[] args) throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/37Degrees/DataSets/master/laptops.csv");
        LaptopReader reader = new UrlLaptopReader(url);
        List<Laptop> laptops = reader.readAll();
        for (Laptop laptop : laptops){
            System.out.println(laptop);
        }


    }
}
