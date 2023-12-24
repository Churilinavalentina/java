package edu.mipt.kozub.geometry;
import edu.mipt.kozub.geometry.line.BrokenLine;
import edu.mipt.kozub.geometry.line.Line;
import edu.mipt.kozub.geometry.line.Point;
public class Triangle extends AbstractFigures implements Area, ToLine{
    Point b;
    Point c;

    public Triangle(Point startPoint, Point b, Point c) {
        super(startPoint);
        this.b = b;
        this.c = c;
    }

    @Override
    public Double area(){
        Double lengthA = new Line(getStartPoint(), b).length();
        Double lengthB = new Line(b, c).length();
        Double lengthC = new Line(c, getStartPoint()).length();
        Double p = (lengthA+lengthB+lengthC);
        return (double) Math.sqrt(p*(p-lengthA)*(p-lengthB)*(p-lengthC));
    }

    public BrokenLine getPolygonalLine(){
        return new BrokenLine(getStartPoint(), b, c);
    }
}
