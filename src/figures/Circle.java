package figures;

import line.Point;

public class Circle extends AbstractFigures{
    int r;

    public Circle(Point startPoint, int r) {
        super(startPoint);
        this.r = r;
    }

    @Override
    public Double area(){
        return (double) Math.PI*r*r;
    }
}
