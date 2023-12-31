package edu.mipt.kozub;

import edu.mipt.kozub.bird.Sing;
import edu.mipt.kozub.city.City;
import edu.mipt.kozub.city.Road;
import edu.mipt.kozub.city.TwoWayCity;
import edu.mipt.kozub.employee.Department;
import edu.mipt.kozub.employee.Employee;
import edu.mipt.kozub.geometry.*;
import edu.mipt.kozub.geometry.line.BrokenLine;
import edu.mipt.kozub.geometry.line.Length;
import edu.mipt.kozub.geometry.line.Line;
import edu.mipt.kozub.numbers.Fraction;
import edu.mipt.kozub.geometry.line.Point;

import java.math.BigInteger;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Main {
    public static void sing(Sing... birds){
        for (Sing s: birds){
            s.singing();
        }
    }

    public static Double area(Area... figurs){
        Double s = (double) 0;
        for (Area f: figurs){
            s = s + f.area();
        }
        return s;
    }

    public static BrokenLine polygonalLine(ToLine... figurs){
        BrokenLine b =new BrokenLine();
        for (ToLine f: figurs){
            b.addPoint(f.getPolygonalLine().getBrokenLine());
        }
        return b;
    }

    public static Double length(Length... figurs){
        Double s = (double) 0;
        for (Length f: figurs){
            s = s + f.length();
        }
        return s;
    }

    public static double sum(Number... n){
        Double sum = (double) 0;
        for (Number i :n){
            sum = sum + i.doubleValue();
        }
        return sum;
    }

    public static double mathPow(String x, String y){
        return pow(parseInt(x), parseInt(y));
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println(sum(7, new Fraction(11,3).doubleValue(), 3,21, new BigInteger("12345678912345678912")));
        //System.out.println(mathPow(args[0], args[1]));

        java.awt.Point a = new java.awt.Point(1, 2);
        System.out.println(a);

        Point b = new Point(3, 4);
        System.out.println(b);

        Department it = new Department("IT");
        Department security = new Department("Security");
        Employee e1= new Employee("Vasya", it);
        Employee e2= new Employee("Petya", it);
        Employee e3= new Employee("Lesha", it);
        Employee e4= new Employee("Kirill", security);
        System.out.println(it);
        System.out.println(security.getEmployee());

        it.setBoss(e4);
        System.out.println(it.getEmployee());
        System.out.println(security.getEmployee());
        System.out.println(e4);

        it.removeEmployee(e1);
        System.out.println(it.getEmployee());

        System.out.println(new Fraction(3, 5).equals(new Fraction(3, 5)));
        System.out.println(new BrokenLine(new Point(1, 2), b).equals(new BrokenLine(new Point(1,2),b)));

//        Sing s1 = new Sparrow();
//        Sing p1 = new Parrot("кар");
//        Sing c1 = new Cuckoo();
//        sing(s1, p1, c1);
//
//
//        Area sq1 = new Square(1,2,5);
//        Area rc1 = new Rectangle(new Point(2, 3), 4, 5);
//        Area cr1 = new Circle(new Point(5,6), 3);
//        Area t1 = new Triangle(new Point(5,6), new Point(1,2), new Point(8,9));
//        System.out.println(area(sq1, rc1, cr1, t1));
//
//        Length l1 = new Line(new Point(2,3), new Point(4,5));
//        Length b1 = new BrokenLine(new Point(4,5), new Point(8,9));
//        System.out.println(length(l1,b1));

        City d = new City("d");
        TwoWayCity c = new TwoWayCity("c", new Road(d, 4));
        TwoWayCity f = new TwoWayCity("f", new Road(d, 4));

        System.out.println(c.equals(f));

        Fraction f1 = new Fraction(3, 5);
        Fraction f2 = (Fraction) f1.clone();
        System.out.println(f2);

        Line l1 = new Line(new Point(3,5), new Point(6,7));
        Line l2 = (Line) l1.clone();
        System.out.println(l2);

    }
}