package lab5;

import java.util.List;

// Мороз Олксандра IO-33
// Залікова №3316
public class lab5 {
  public static void main(String[] args) {
        try {
            Gift gift = new Gift();

            // Створюємо цукерки
            Candy snickers = new ChocolateCandy("Snickers", 50, 45, 70);
            Candy bounty = new ChocolateCandy("Bounty", 45, 40, 60);
            Candy ferrero = new ChocolateCandy("Ferrero Rosher", 35, 55, 80);
            Candy bee = new JellyCandy("Весела Бджілка", 25, 60);
            Candy fizzy = new FizzyCandy("Шипучка", 20, 50, true);

            // Додаємо до подарунку
            gift.addCandy(snickers);
            gift.addCandy(bounty);
            gift.addCandy(ferrero);
            gift.addCandy(bee);
            gift.addCandy(fizzy);

            System.out.println("У подарунку:");
            gift.printCandies();

            System.out.printf("%nЗагальна вага подарунку: %.1f г%n", gift.getTotalWeight());

            System.out.println("\nСортування за вмістом шоколаду:");
            gift.sortByParameter("шоколад");
            gift.printCandies();

            System.out.println("\nЦукерки з вмістом шоколаду від 50% до 75%:");
            List<Candy> found = gift.findByChocolateRange(50, 75);
            found.forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}