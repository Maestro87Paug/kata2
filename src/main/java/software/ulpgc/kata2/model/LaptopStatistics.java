package software.ulpgc.kata2.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LaptopStatistics {
    public static String summary(List<Laptop> laptops) {
        Map<String, Integer> countByCategory = countByCategory(laptops);
        return format(countByCategory, laptops.size());
    }

    private static Map<String, Integer> countByCategory(List<Laptop> laptops) {
        Map<String, Integer> count = new HashMap<>();
        for (Laptop laptop : laptops) {
            count.put(laptop.category(), count.getOrDefault(laptop.category(), 0) + 1);
        }
        return count;
    }

    private static String format(Map<String, Integer> countByCategory, int total) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Laptops por categoria ===\n");
        for (Map.Entry<String, Integer> entry : countByCategory.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        sb.append("\nTotal: ").append(total).append(" laptops");
        return sb.toString();
    }
}
