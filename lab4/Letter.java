package lab4;
//Клас, що представляє окрему літеру тексту.
public class Letter {
    private final char symbol;

    public Letter(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
