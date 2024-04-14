package ru.mipt.edu.kozub.geometry;

import ru.mipt.edu.kozub.geometry.line.BrokenLine;
import ru.mipt.edu.kozub.geometry.line.Point;

import java.util.Arrays;

public class Rectangle extends AbstractFigures implements Area, ToLine {
    int a;
    int b;

    public Rectangle(Point startPoint, int a, int b) {
        super(startPoint);
        this.a = a;
        this.b = b;
    }

    public BrokenLine getPolygonalLine(){
        return new BrokenLine(Arrays.asList(getStartPoint(), new Point(getStartPoint().x+a, getStartPoint().y),
                new Point(getStartPoint().x+a, getStartPoint().y-b), new Point(getStartPoint().x, getStartPoint().y-b), getStartPoint()));
    }

    @Override
    public Double area(){
        return (double) a*b;
    }
}
