package edu.mipt.kozub.geometry;
import edu.mipt.kozub.geometry.line.Point;

abstract public class AbstractFigures {
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
}
