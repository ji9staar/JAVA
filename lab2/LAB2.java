package lab2;
// Мороз Олксандра IO-33
// Залікова №3316

import java.util.Arrays;

public class LAB2 {
  // C3 = 1 - String
  // C17 = 1 - Вивести всі речення заданого тексту в порядку зростання кількості
  // слів у них.
  private static void printSentencesByWordCount(String text) {
    String[] sentences = text.split("\\.");

    Arrays.sort(sentences, (s1, s2) -> {
      int words1 = countWords(s1);
      int words2 = countWords(s2);
      return Integer.compare(words1, words2);
    });

    System.out.println("Sorted sentences:");
    for (String s : sentences) {
      if (!s.isEmpty()) {
        System.out.println(countWords(s) + " words: " + s);
      }
    }
  }

  private static int countWords(String sentence) {
    if (sentence.trim().isEmpty())
      return 0;
    return sentence.trim().split("\\s+").length;
  }

  public static void main(String[] args) {
    String text = "C3 = 1 - String. C17 = 1 - Вивести всі речення заданого тексту в порядку зростання кількості слів у них.";

    printSentencesByWordCount(text);
  }
}