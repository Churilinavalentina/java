package edu.mipt.kozub.geometry.line;

import edu.mipt.kozub.geometry.ToLine;

import java.util.Objects;

import static java.lang.Math.sqrt;

public class Line implements Length, ToLine, Cloneable {
    private Point start, end;

    public Line(Point start, Point end) {
        this.start = new Point(start.x, start.y);
        this.end = new Point(end.x, end.y);
    }

    public Line(int xStart, int yStart, int xEnd, int yEnd) {
        this(new Point(xStart, yStart), new Point(xEnd, yEnd));
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public void setStart(Point start) {
        this.start = new Point(start.x, start.y);
    }

    public void setEnd(Point end) {
        this.end = new Point(end.x, end.y);
    }

    @Override
    public  String toString(){
        return "Линия от {"+start.x+ ";"+start.y+"} до {"+end.x+ ";"+end.y+"}";
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

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
