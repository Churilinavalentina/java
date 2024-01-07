package edu.mipt.kozub.geometry.line;

import edu.mipt.kozub.numbers.Fraction;

import java.util.Objects;

public class Point implements Cloneable{
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "("+x+";"+y+")";
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

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
