public class Fraction {
    private int numerator, denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String toString(){
        if (denominator <=0) throw new IllegalArgumentException();
        return numerator+"/"+denominator;
    }

    public Fraction sum(Fraction f2) {
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

    public static void main(String[] arg){
        //1.5
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = new Fraction(4, 6);

        System.out.println(f1.toString()+" + "+f2.toString()+" = "+f1.sum(f2).toString());
        System.out.println(f1.toString()+" - "+f2.toString()+" = "+f1.diff(f2).toString());
        System.out.println(f1.toString()+" * "+f2.toString()+" = "+f1.mult(f2).toString());
        System.out.println(f1.toString()+" / "+f2.toString()+" = "+f1.div(f2).toString());
        //System.out.println(f1.sum(f2).div(f3).diff(new Fraction(5, 0)).toString());

        //1.6
//        Fraction f4 = new Fraction(4, 6);
//        f4.numerator = 5;
//        System.out.println(f4.toString());

        Fraction f5 = new Fraction(4, -6);
        System.out.println(f5.toString());
    }
}
