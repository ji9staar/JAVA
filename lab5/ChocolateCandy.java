package lab5;

//Клас, що описує шоколадну цукерку.
public class ChocolateCandy extends Candy {
    private final double chocolatePercent;

    public ChocolateCandy(String name, double weight, double sugarContent, double chocolatePercent) {
        super(name, weight, sugarContent);
        if (chocolatePercent < 0 || chocolatePercent > 100) {
            throw new IllegalArgumentException("Вміст шоколаду повинен бути в межах 0–100%.");
        }
        this.chocolatePercent = chocolatePercent;
    }

    @Override
    public double getChocolatePercent() {
        return chocolatePercent;
    }
}
