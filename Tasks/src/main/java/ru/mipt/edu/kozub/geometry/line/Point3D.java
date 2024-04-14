package ru.mipt.edu.kozub.geometry.line;

import ru.mipt.edu.kozub.geometry.Groupable;

import java.util.Objects;

import static java.lang.Math.sqrt;

public class Point3D extends Point implements Groupable {
    int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public Double length(Point3D p){
        return sqrt((x-p.x)*(x-p.x) + (y - p.y)*(y - p.y) + (z - p.z)*(z - p.z));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point3D point3D)) return false;
        if (!super.equals(o)) return false;
        return z == point3D.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }

    @Override
    public String toString(){
        return "("+x+";"+y+";"+z+")";
    }
}
