package figures;

import line.Point;

import java.util.List;

public class Rectangle extends AbstractFigures implements Area{
    int a;
    int b;

    public Rectangle(Point startPoint, int a, int b) {
        super(startPoint);
        this.a = a;
        this.b = b;
    }

    @Override
    public Double area(){
        return (double) a*b;
    }
}
