package lab3;
// Мороз Олександра IO-33
// Залікова №3316

import java.util.Arrays;
import java.util.Objects;

/**
 * Клас Cosmetic описує об'єкт косметики з характеристиками:
 * назва, бренд, ціна, знижка та рейтинг.
 */
class Cosmetic {
  String name;
  String brand;
  double price;
  int discount;
  int rating;

  /**
   * Конструктор для створення об'єкта Cosmetic з усіма параметрами.
   */
  public Cosmetic(String name, String brand, double price, int discount, int rating) {
    this.name = name;
    this.brand = brand;
    this.price = price;
    this.discount = discount;
    this.rating = rating;
  }

  /**
   * Повертає текстове представлення об'єкта Cosmetic.
   */
  public String toString() {
    return "Cosmetic{" +
        "name='" + name + '\'' +
        ", brand='" + brand + '\'' +
        ", price=" + price +
        ", discount=" + discount +
        ", rating=" + rating +
        '}';
  }

  /**
   * Перевіряє рівність двох об'єктів Cosmetic за всіма властивостями.
   */
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Cosmetic))
      return false;
    Cosmetic cosmetic = (Cosmetic) o;
    return Double.compare(cosmetic.price, price) == 0 &&
        discount == cosmetic.discount &&
        rating == cosmetic.rating &&
        Objects.equals(name, cosmetic.name) &&
        Objects.equals(brand, cosmetic.brand);
  }
}

/**
 * Головний клас LAB3 — демонструє роботу з об’єктами Cosmetic.
 */
public class LAB3 {
  // C11 = 5 – Визначити клас косметика з мінімум 5 полями

  /**
   * Головний метод програми.
   * Створює масив косметики, сортує його та перевіряє наявність елемента.
   */
  public static void main(String[] args) {
    // Створення масиву косметики
    Cosmetic[] cosmetics = {
        new Cosmetic("Пудра", "Paese", 219.0, 5, 4),
        new Cosmetic("Тональний крем", "Estee Lauder", 1487.0, 15, 4),
        new Cosmetic("Тональний крем", "Lumene", 500.0, 20, 3),
        new Cosmetic("Туш", "Maybelline", 180.0, 20, 2),
        new Cosmetic("Туш", "Maybelline", 500.0, 10, 5)
    };

    // Сортування за ціною та рейтингом
    Arrays.sort(cosmetics, (c1, c2) -> {
      int priceCompare = Double.compare(c1.price, c2.price);
      if (priceCompare != 0) {
        return priceCompare;
      } else {
        return Integer.compare(c2.rating, c1.rating);
      }
    });

    // Виведення відсортованих елементів
    System.out.println("Sorted cosmetic:");
    for (Cosmetic c : cosmetics) {
      System.out.println(c);
    }

    // Створення елемента для пошуку
    Cosmetic target = new Cosmetic("Туш", "Maybelline", 500.0, 10, 5);
    boolean found = Arrays.asList(cosmetics).contains(target);

    // Виведення результату пошуку
    System.out.println("\nDo we have " + target + "\nResult: " + found);
  }
}
