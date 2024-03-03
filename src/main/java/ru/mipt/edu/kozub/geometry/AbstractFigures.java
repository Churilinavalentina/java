package ru.mipt.edu.kozub.geometry;

import ru.mipt.edu.kozub.geometry.line.Point;

abstract public class AbstractFigures implements Groupable {
    private Point startPoint;

    public AbstractFigures(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    abstract public Double area();

    @Override
    public void move(int x, int y){
        startPoint.move(x,y);
    };
}
