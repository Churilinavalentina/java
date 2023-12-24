package edu.mipt.kozub.numbers;

public final class Fraction extends Number{
    private int numerator, denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String toString(){
        if (denominator <=0) throw new IllegalArgumentException();
        return numerator+"/"+denominator;
    }

    public Fraction sumF(Fraction f2) {
        return new Fraction(numerator * f2.denominator + f2.numerator * denominator, denominator * f2.denominator);
    }
    public Fraction diff(Fraction f2) {
        return new Fraction(numerator * f2.denominator - f2.numerator * denominator, denominator * f2.denominator);
    }
    public Fraction mult(Fraction f2) {
        return new Fraction(numerator * f2.numerator, denominator * f2.denominator);
    }
    public Fraction div(Fraction f2) {
        return new Fraction(numerator*f2.denominator, denominator* f2.numerator);
    }

    @Override
    public int intValue() {
        return numerator/denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator/denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator/denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator/denominator;
    }

}
