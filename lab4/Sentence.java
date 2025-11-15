package lab4;

import java.util.ArrayList;
import java.util.List;

//Клас, що представляє речення, яке складається зі слів і розділових знаків.
public class Sentence {
    private final List<Object> elements = new ArrayList<>(); // Word або PunctuationMark

    public Sentence(String sentence) {
        String[] parts = sentence.trim().split("(?=[,.!?])|\\s+");
        for (String part : parts) {
            if (part.matches("[,.!?]")) {
                elements.add(new PunctuationMark(part.charAt(0)));
            } else if (!part.isBlank()) {
                elements.add(new Word(part));
            }
        }
    }

    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (Object el : elements) {
            if (el instanceof Word) {
                words.add((Word) el);
            }
        }
        return words;
    }

    //Повертає кількість слів у реченні.
    public int getWordCount() {
        return getWords().size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object el : elements) {
            sb.append(el.toString());
            if (el instanceof Word) sb.append(" ");
        }
        return sb.toString().trim();
    }
}
