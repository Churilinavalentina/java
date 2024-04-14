package ru.mipt.edu.kozub.geometry.line;

import ru.mipt.edu.kozub.geometry.Groupable;

import java.util.Objects;

import static java.lang.Math.sqrt;

public class Point implements Cloneable, Groupable {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString(){
        return "("+x+";"+y+")";
    }

    public Point move(Integer n){
        this.x = this.x+n;
        this.y = this.y+n;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null && this!=null) return false;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    public Double length(Point p){
        return sqrt((x-p.x)*(x-p.x) + (y - p.y)*(y - p.y));
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Point clone(){
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void move(int x, int y) {
        this.x+=x;
        this.y+=y;
    }
}
