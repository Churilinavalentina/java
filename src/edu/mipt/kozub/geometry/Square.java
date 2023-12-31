package edu.mipt.kozub.geometry;
import edu.mipt.kozub.geometry.line.Point;
import edu.mipt.kozub.geometry.line.BrokenLine;

public class Square extends AbstractFigures implements Area, ToLine{
    private int length;

    public Square(Point startPoint,int length) {
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
        return new BrokenLine(getStartPoint(), new Point(getStartPoint().x+length, getStartPoint().y),
                new Point(getStartPoint().x+length, getStartPoint().y-length), new Point(getStartPoint().x, getStartPoint().y-length), getStartPoint());
    }

    @Override
    public Double area(){
        return (double) length*length;
    }
}