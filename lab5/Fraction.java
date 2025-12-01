package lab5;

public class Fraction implements FractionInterface {
    //  доступны в этом классе и классах наследниках
    protected int numerator, denominator;

    // Cоздаём обьект дроби
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть 0");
        }
        if (denominator < 0) {
            throw new IllegalArgumentException("Знаменатель не может быть отрицательным");
        }
        this.numerator = numerator; //this обращается к полю обьекта
        this.denominator = denominator;
    }

    @Override
    public double getRealValue() {
        return (double) numerator / denominator;
    }   // Приведение к double для точного деления

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть 0");
        }
        if (denominator < 0) {
            throw new IllegalArgumentException("Знаменатель не может быть отрицательным");
        }
        this.denominator = denominator;
    }
    // возвращает строковое представление дроби
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        // instanceof проверяет наследование и реализацию интерфейсов
        if (!(obj instanceof Fraction)) return false; // разные типы - не равны
        // приводим Object к Fraction для доступа к полям
        Fraction f = (Fraction) obj;
        return numerator == f.numerator && denominator == f.denominator;
    }
}