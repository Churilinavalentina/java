package ru.mipt.edu.kozub.numbers;

import java.util.Objects;

public final class Fraction extends Number implements Cloneable {
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

    @Override
    public final boolean equals(Object o){
        if(this == o) return  true;
        if(o == null && this!=null) return false;
        if(!(o instanceof Fraction)) return false;
        Fraction f = (Fraction) o;
        if(f.denominator == this.denominator && f.numerator == this.numerator) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }


}
