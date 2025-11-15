package lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Клас, що представляє дитячий подарунок із цукерками.

public class Gift {
    private final List<Candy> candies = new ArrayList<>();

    // Додає цукерку до подарунку.
    public void addCandy(Candy candy) {
        if (candy == null) {
            throw new IllegalArgumentException("Цукерка не може бути null.");
        }
        candies.add(candy);
    }

    //Повертає загальну вагу подарунку.
    public double getTotalWeight() {
        return candies.stream().mapToDouble(Candy::getWeight).sum();
    }

    //Сортує цукерки за вагою, цукром або шоколадом.

    public void sortByParameter(String parameter) {
        switch (parameter.toLowerCase()) {
            case "вага":
                candies.sort(Comparator.comparingDouble(Candy::getWeight));
                break;
            case "цукор":
                candies.sort(Comparator.comparingDouble(Candy::getSugarContent));
                break;
            case "шоколад":
                candies.sort(Comparator.comparingDouble(Candy::getChocolatePercent));
                break;
            default:
                throw new IllegalArgumentException("Невідомий параметр сортування: " + parameter);
        }
    }

    //Знаходить цукерки у діапазоні вмісту шоколаду.
    public List<Candy> findByChocolateRange(double min, double max) {
        if (min < 0 || max > 100 || min > max) {
            throw new IllegalArgumentException("Невірний діапазон вмісту шоколаду.");
        }
        return candies.stream()
                .filter(c -> c.getChocolatePercent() >= min && c.getChocolatePercent() <= max)
                .collect(Collectors.toList());
    }

    public void printCandies() {
        candies.forEach(System.out::println);
    }
}
