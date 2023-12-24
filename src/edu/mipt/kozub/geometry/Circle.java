package edu.mipt.kozub.geometry;

import edu.mipt.kozub.geometry.line.Point;

public class Circle extends AbstractFigures implements Area{
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
