package edu.mipt.kozub.geometry.line;

import java.util.Objects;

public class Point implements Cloneable{
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

    public Point shift(Integer n){
        this.x = this.x+n;
        this.y = this.y+n;
        return this;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if(o == null && this!=null) return false;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
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
}
