package lab5;

public class CacheFract extends Fraction {
    private Double cachedValue;

    public CacheFract(int numerator, int denominator) {
        super(numerator, denominator);
    }

    @Override
    public double getRealValue() {
        if (cachedValue == null) {
            // Вычисляем значение и сохраняем в кэш
            cachedValue = (double) numerator / denominator;
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int numerator) {
        super.setNumerator(numerator);
        cachedValue = null;
    }

    @Override
    public void setDenominator(int denominator) {
        super.setDenominator(denominator);
        cachedValue = null;
    }
}