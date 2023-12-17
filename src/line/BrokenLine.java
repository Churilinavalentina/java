package line;

import java.util.ArrayList;
import java.util.List;

public class BrokenLine {
    List<Point> brokenLine = new ArrayList<>();

    public BrokenLine(Point...line) {
        for(Point x:line) this.brokenLine.add(x);
    }


    @Override
    public String toString(){
        String result = "Линия ";
        for(Point x:brokenLine) result = result+ x.toString();
        return result;
    }

    public Point removeLast(){
        return brokenLine.removeLast();
    }

    public void setPoint(Point...point){
        for (Point p: point){
            brokenLine.add(p);
        }
    }

    public Double length(){
        Double length = (double)0;
        for (int i=0; i<brokenLine.size()-1; i++){
            length = length + (new Line(brokenLine.get(i), brokenLine.get(i+1)).length());
        }
        return length;
    }

    public static void main(String[] args) {
        BrokenLine l1 = new BrokenLine(new Point(1,5), new Point(2,8), new Point(5,3));
        System.out.println(l1.length());

        l1.setPoint(new Point(5,15), new Point(8, 10));
        System.out.println(l1.length());
    }
}
