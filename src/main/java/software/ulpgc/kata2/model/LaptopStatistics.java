
package software.ulpgc.kata2.model;

import java.util.List;
import java.util.ArrayList;

public class LaptopStatistics {

    public static String summary(List<Laptop> laptops) {
        List<String> categories = new ArrayList<>();
        List<Integer> amounts = new ArrayList<>();

        for (Laptop laptop : laptops) {
            String category = laptop.category();

            if (categories.contains(category)) {
                int position = categories.indexOf(category);
                amounts.set(position, amounts.get(position) + 1);
            } else {
                categories.add(category);
                amounts.add(1);
            }
        }

        String result = "Total laptops: " + laptops.size() + "\n";
        result += "Laptops by category:\n";

        StringBuilder resultBuilder = new StringBuilder(result);
        for (int i = 0; i < categories.size(); i++) {
            resultBuilder.append(categories.get(i)).append(": ").append(amounts.get(i)).append("\n");
        }
        result = resultBuilder.toString();

        return result;
    }
}
