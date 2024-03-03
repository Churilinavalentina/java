package ru.mipt.edu.kozub.geometry.line;

import java.util.Arrays;
import java.util.List;

public class ClosedBrokenLine extends BrokenLine {
    public ClosedBrokenLine(List<Point> point) {
        super(point);
        if(Arrays.asList(point).size() < 3) throw new IllegalArgumentException();
        for(Point p:point) {
            super.brokenLine.add(p);
        }
    }


    @Override
    public Double length(){
        return super.length() + (new Line(brokenLine.getFirst(), brokenLine.getLast()).length());
    }

}


