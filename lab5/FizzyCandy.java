package lab5;

// Клас, що описує шипучу цукерку.

public class FizzyCandy extends Candy {
    private final boolean containsSoda; // наявність шипучого порошку

    public FizzyCandy(String name, double weight, double sugarContent, boolean containsSoda) {
        super(name, weight, sugarContent);
        this.containsSoda = containsSoda;
    }

    public boolean hasSoda() {
        return containsSoda;
    }

    @Override
    public double getChocolatePercent() {
        return 0.0;
    }

    @Override
    public String toString() {
        return super.toString() + (containsSoda ? " (шипуча)" : "");
    }
}
