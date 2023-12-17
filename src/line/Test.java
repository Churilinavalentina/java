package line;

import figures.*;

public class Test {
    public static Double length(Length... figurs){
        Double s = (double) 0;
        for (Length f: figurs){
            s = s + f.length();
        }
        return s;
    }
    public static void main(String[] arg){
        //1.5
        Length l1 = new Line(new Point(2,3), new Point(4,5));
        Length b1 = new BrokenLine(new Point(4,5), new Point(8,9));


        System.out.println(length(l1,b1));
    }
}
