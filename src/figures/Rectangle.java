package figures;

import line.BrokenLine;
import line.Point;

import java.util.List;

public class Rectangle extends AbstractFigures implements Area, ToLine{
    int a;
    int b;

    public Rectangle(Point startPoint, int a, int b) {
        super(startPoint);
        this.a = a;
        this.b = b;
    }

    public BrokenLine getPolygonalLine(){
        return new BrokenLine(getStartPoint(), new Point(getStartPoint().x+a, getStartPoint().y),
                new Point(getStartPoint().x+a, getStartPoint().y-b), new Point(getStartPoint().x, getStartPoint().y-b), getStartPoint());
    }

    @Override
    public Double area(){
        return (double) a*b;
    }
}
