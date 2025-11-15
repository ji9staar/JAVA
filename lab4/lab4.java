package lab4;

import java.util.Comparator;

// Мороз Олксандра IO-33
// Залікова №3316
public class lab4 {

    private static void printSentencesByWordCount(Text text) {
        text.getSentences().stream()
            .sorted(Comparator.comparingInt(Sentence::getWordCount))
            .forEach(sentence ->
                System.out.println(sentence.getWordCount() + " слів: " + sentence)
            );
    }

    public static void main(String[] args) {
        // C3 = 1 - String
        // C17 = 1 - Вивести всі речення заданого тексту в порядку зростання кількості слів у них
        String inputText = "C3 = 1 - String. C17 = 1 - Вивести всі речення заданого тексту в порядку зростання кількості слів у них.";

        Text text = new Text(inputText);

        System.out.println("Відсортовані речення:");
        printSentencesByWordCount(text);
    }
}