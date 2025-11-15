package lab6;

import java.util.Arrays;

public class lab6 {
  public static void main(String[] args) {
        Candy snickers = new ChocolateCandy("Snickers", 50, 45, 70);
        Candy bounty = new ChocolateCandy("Bounty", 45, 40, 60);
        Candy ferrero = new ChocolateCandy("Ferrero Rosher", 35, 55, 80);

        // Порожній список
        CandyLinkedList list1 = new CandyLinkedList();
        list1.add(snickers);
        list1.add(bounty);
        System.out.println("\nКолекція list1:");
        list1.forEach(System.out::println);

        // Список з одним елементом
        CandyLinkedList list2 = new CandyLinkedList(ferrero);
        System.out.println("\nКолекція list2 (один елемент):");
        list2.forEach(System.out::println);

        // Список з колекції
        CandyLinkedList list3 = new CandyLinkedList(Arrays.asList(snickers, bounty, ferrero));
        System.out.println("\nКолекція list3 (з колекції):");
        list3.forEach(System.out::println);

        // Демонстрація базових методів
        System.out.println("\nОтримати елемент [1]: " + list3.get(1));
        list3.remove(0);
        System.out.println("Після видалення першого елемента:");
        list3.forEach(System.out::println);

        System.out.println("Розмір списку: " + list3.size());
    }
}
