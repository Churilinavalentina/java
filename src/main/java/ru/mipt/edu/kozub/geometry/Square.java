package ru.mipt.edu.kozub.geometry;
import ru.mipt.edu.kozub.annotation.Default;
import ru.mipt.edu.kozub.geometry.line.BrokenLine;
import ru.mipt.edu.kozub.geometry.line.Point;

import java.util.Arrays;

public class Square extends AbstractFigures implements Area, ToLine {
    private int length;

    public Square(Point startPoint, int length) {
        super(startPoint);
        this.length = length;
    }

    public Square(int x, int y, int length) {
        this(new Point(x,y), length);
    }

    public void setLength(int length) {
        if (length < 0) throw new IllegalArgumentException();
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString(){
        return "Квадрат в точке "+ getStartPoint().toString()+" со стороной "+length;
    }

    public BrokenLine getPolygonalLine(){
        return new BrokenLine(Arrays.asList(getStartPoint(), new Point(getStartPoint().x+length, getStartPoint().y),
                new Point(getStartPoint().x+length, getStartPoint().y-length), new Point(getStartPoint().x, getStartPoint().y-length), getStartPoint()));
    }

    @Override
    public Double area(){
        return (double) length*length;
    }
}