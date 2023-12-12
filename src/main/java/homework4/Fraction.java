package homework4;

import java.util.Objects;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero.");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Fraction fraction = (Fraction) object;
        return this.numerator * fraction.denominator == this.denominator * fraction.numerator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}