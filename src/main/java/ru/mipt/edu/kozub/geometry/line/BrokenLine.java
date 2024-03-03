package ru.mipt.edu.kozub.geometry.line;

import ru.mipt.edu.kozub.geometry.Groupable;
import ru.mipt.edu.kozub.geometry.ToLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BrokenLine implements Length, ToLine, Groupable {
    List<Point> brokenLine = new ArrayList<>();

    public BrokenLine(List<Point> line) {
        for(Point x:line) this.brokenLine.add(x);
    }


    @Override
    public String toString(){
        String result = "Линия ";
        for(Point x:brokenLine) result = result+ x.toString();
        return result;
    }

    public void setPoint(Point...point){
        addPoint(Arrays.asList(point));
    }

    public void addPoint(List<Point> point){
        for (Point p: point){
            brokenLine.add(p);
        }
    }

    public List<Point> getBrokenLine() {
        return brokenLine;
    }

    public BrokenLine getPolygonalLine() {
        return this;
    }

    public Double length(){
        Double length = (double)0;
        for (int i=0; i<brokenLine.size()-1; i++){
            length = length + (new Line(brokenLine.get(i), brokenLine.get(i+1)).length());
        }
        return length;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrokenLine that)) return false;
        return Objects.equals(getBrokenLine(), that.getBrokenLine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrokenLine());
    }

    @Override
    public void move(int x, int y) {
        for(Point p: brokenLine){
            p.move(x,y);
        }
    }
}
