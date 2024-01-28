package edu.mipt.kozub.other;

import edu.mipt.kozub.storage.Basket;
import edu.mipt.kozub.bird.Sing;
import edu.mipt.kozub.geometry.*;
import edu.mipt.kozub.geometry.line.*;
import edu.mipt.kozub.storage.Storage;

import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class SomeStaticClass {
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

//    public static Line<?> shift(Line<?> l){
//        Line<?> l2 = new Line<>(l.getStart().clone().shift(10), l.getEnd().clone().shift(10));
//        return l2;
//    }

    public static double maxStor(Storage<? extends Number>...s){
        double max = (double) 0;
        Number n = 0;

        for (Storage<? extends Number> i:s){
            Double objStor = i.getObject(null).doubleValue();
            if (max < objStor) {
                max = objStor;
            }
        }
        return max;
    }

    public static Basket<?> addBasket(Basket<? super Point3D> b){
        b.setElement(new Point3D(2, 3, 4));
        return b;
    }

    public static List<?> addList(List<? super Integer> l){
        for(int i=0; i<100; i++){
            l.add(i);
        }
        return l;
    }


//    public static void main(String[] args) throws CloneNotSupportedException {
//
//        Basket<Integer> b1 = new Basket<>();
//        b1.setElement(3);
//        System.out.println(b1.chekEmpty());
//
//        Storage<Integer> s1 = new Storage<>(null);
//        System.out.println(s1.getObject(0)+1);
//
//        Storage<Integer> s2 = new Storage<>(99);
//        System.out.println(s2.getObject(-1));
//
//        Storage<String> s3 = new Storage<>(null);
//        System.out.println(s3.getObject("Default"));
//
//        Storage<String> s4 = new Storage<>("hello");
//        System.out.println(s4.getObject("hello world"));
//
//        Student st1 = new Student("Vasy", 3, 4, 5);
//        Student st2 = new Student("Pety", 5, 5, 5);
//        System.out.println(st1.Comparable(st2));
//
//        Line<Point3D> line1 = new Line<>(new Point3D(2, 3, 4), new Point3D(6, 7, 8));
//        System.out.println(line1);
//
//        System.out.println(shift(line1).toString());
//
//        System.out.println(maxStor(s1, s2));
//
//        System.out.println(addBasket(new Basket<>()));
//
//        System.out.println(addList(new ArrayList<>()));
//
//        System.out.println("");
//        System.out.println("Задачи 5.3");
//        System.out.println("");
//        // Задачи 5.3
//
//
//        List<String> str = Arrays.asList("qwerty", "asdfg", "zx");
//        System.out.println(Utils.map(str, x->x.length()>3));
//
//        List<Integer> integ = Arrays.asList(1, -3, 7);
//        System.out.println(Utils.map(integ, x->x>0));
//
//        Integer[] a1 = new Integer[2];
//        a1[0] = 1;
//        a1[1] = 5;
//
//        Integer[] a2 = new Integer[2];
//        a2[0] = 3;
//        a2[1] = 54;
//
//        Integer[] a3 = new Integer[2];
//        a3[0] = -3;
//        a3[1] = -54;
//
//        List<Integer[]> arr = Arrays.asList(a1, a2, a3);
//        System.out.println(Utils.map(arr, x->x.length*2));
//    }

}