package figures;

import bird.Cuckoo;
import bird.Parrot;
import bird.Sing;
import bird.Sparrow;
import line.BrokenLine;
import line.Point;

public class Test {
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
    public static void main(String[] arg){
        //1.5
        Area s1 = new Square(1,2,5);
        Area r1 = new Rectangle(new Point(2, 3), 4, 5);
        Area c1 = new Circle(new Point(5,6), 3);
        Area t1 = new Triangle(new Point(5,6), new Point(1,2), new Point(8,9));


        System.out.println(area(s1, r1, c1, t1));
    }
}
