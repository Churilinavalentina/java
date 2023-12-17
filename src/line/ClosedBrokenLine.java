package line;

import java.util.Arrays;

public class ClosedBrokenLine extends BrokenLine{
    public ClosedBrokenLine(Point...point) {
        if(Arrays.asList(point).size() < 3) throw new IllegalArgumentException();
        for(Point p:point) {
            super.brokenLine.add(p);
        }
    }


    @Override
    public Double length(){
        return super.length() + (new Line(brokenLine.getFirst(), brokenLine.getLast()).length());
    }

    public static void main(String[] args) {
        ClosedBrokenLine l1 = new ClosedBrokenLine(new Point(1,5), new Point(2,8), new Point(5,3));
        System.out.println(l1.length());

    }
}


