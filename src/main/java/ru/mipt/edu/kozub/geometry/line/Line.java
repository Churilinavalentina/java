package ru.mipt.edu.kozub.geometry.line;

import ru.mipt.edu.kozub.geometry.Groupable;
import ru.mipt.edu.kozub.geometry.ToLine;

import java.util.Arrays;
import java.util.Objects;

public class Line<T extends Point> implements Length, ToLine, Cloneable, Groupable {
    private T start, end;

    public Line(T start, T end) {
        this.start = start;
        this.end = end;
    }

    public static  Line<Point> of(int xStart, int yStart, int xEnd, int yEnd) {
        return  new Line<>(new Point(xStart, yStart), new Point(xEnd, yEnd));
    }

    public T getStart() {
        return (T) start.clone();
    }

    public T getEnd() {
        return (T) end.clone();
    }

    public void setStart(T start) {
        this.start = (T) start.clone();
    }

    public void setEnd(Point end) {
        this.end = (T) end.clone();
    }

    @Override
    public  String toString(){
        return "Линия от " + start.toString()+ " до "+ end.toString();
    }

    public Double length(){
        return start.length(end);
    }
    public BrokenLine getPolygonalLine(){
        return new BrokenLine(Arrays.asList(start, end));
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(getStart(), line.getStart()) && Objects.equals(getEnd(), line.getEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStart(), getEnd());
    }

    public Line<T> clone(){
        try {
            Line line = (Line) super.clone();
            line.start = line.start.clone();
            line.end = line.end.clone();

            return line;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void move(int x, int y) {
        start.move(x,y);
        end.move(x,y);
    }
}
