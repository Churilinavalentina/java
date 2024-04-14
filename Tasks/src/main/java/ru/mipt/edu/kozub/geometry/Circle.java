package ru.mipt.edu.kozub.geometry;

import ru.mipt.edu.kozub.geometry.line.Point;

public class Circle extends AbstractFigures implements Area {
    int r;

    public Circle(Point startPoint, int r) {
        super(startPoint);
        this.r = r;
    }

    @Override
    public Double area(){
        return (double) Math.PI*r*r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "startPoint=" + this.getStartPoint() +
                "r=" + r +
                '}';
    }
}
