package edu.mipt.kozub.geometry.line;

import edu.mipt.kozub.geometry.ToLine;

import java.util.Objects;

import static java.lang.Math.sqrt;

public class Line<T extends Point> implements Length, ToLine, Cloneable {
    private T start, end;

    public Line(T start, T end) {
        this.start = (T) start.clone();
        this.end = (T) end.clone();
    }

//    public Line(int xStart, int yStart, int xEnd, int yEnd) {
//        this(new Point(xStart, yStart), new Point(xEnd, yEnd));
//    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
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
        return sqrt((start.x-end.x)*(start.x-end.x) + (start.y - end.y)*(start.y - end.y));
    }
    public BrokenLine getPolygonalLine(){
        return new BrokenLine(start, end);
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

    public Line clone(){
        try {
            Line line = (Line) super.clone();
            line.start = line.start.clone();
            line.end = line.end.clone();

            return line;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
