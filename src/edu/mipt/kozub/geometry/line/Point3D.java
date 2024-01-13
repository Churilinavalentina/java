package edu.mipt.kozub.geometry.line;

public class Point3D extends Point{
    int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString(){
        return "("+x+";"+y+";"+z+")";
    }
    public Point shift(Integer n){
        this.x = this.x+n;
        this.y = this.y+n;
        this.z = this.z+n;
        return this;
    }
}
