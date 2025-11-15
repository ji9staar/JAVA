package lab4;
//Клас, що представляє розділовий знак.
public class PunctuationMark {
    private final char mark;

    public PunctuationMark(char mark) {
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return String.valueOf(mark);
    }
}
