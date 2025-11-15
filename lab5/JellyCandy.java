package lab5;

// Клас, що описує желейну цукерку.
public class JellyCandy extends Candy {
    public JellyCandy(String name, double weight, double sugarContent) {
        super(name, weight, sugarContent);
    }

    @Override
    public double getChocolatePercent() {
        return 0.0;
    }
}
