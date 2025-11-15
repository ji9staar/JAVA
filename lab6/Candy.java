package lab6;

//Клас, що описує загальну цукерку. Використовується як батьківський клас для всіх типів солодощів.

public abstract class Candy {
    private final String name;
    private final double weight; // в грамах
    private final double sugarContent; // у відсотках (0–100)

    public Candy(String name, double weight, double sugarContent) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Вага повинна бути більшою за 0.");
        }
        if (sugarContent < 0 || sugarContent > 100) {
            throw new IllegalArgumentException("Вміст цукру повинен бути в діапазоні 0–100.");
        }

        this.name = name;
        this.weight = weight;
        this.sugarContent = sugarContent;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    //Абстрактний метод для отримання частки шоколаду в цукерці.
    public abstract double getChocolatePercent();

    @Override
    public String toString() {
        return String.format("%s [%.1fg, %.1f%% цукру, %.1f%% шоколаду]",
                name, weight, sugarContent, getChocolatePercent());
    }
}
