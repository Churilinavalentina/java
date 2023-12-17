package figures;
import line.Line;
import line.Point;
public class Triangle extends AbstractFigures{
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
}
