package lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Клас, що представляє текст, який складається з речень.
public class Text {
    private final List<Sentence> sentences = new ArrayList<>();

    public Text(String rawText) {
        // Замінюємо кілька пробілів і табуляцій одним пробілом
        String cleaned = rawText.replaceAll("\\s+", " ").trim();

        // Розділяємо на речення за допомогою крапки, знаку питання або оклику
        String[] parts = cleaned.split("(?<=[.!?])\\s*");
        Arrays.stream(parts)
                .filter(s -> !s.isBlank())
                .forEach(s -> sentences.add(new Sentence(s)));
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence s : sentences) {
            sb.append(s.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
