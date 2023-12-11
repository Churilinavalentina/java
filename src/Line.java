import static java.lang.Math.sqrt;

public class Line {
    private Point start, end;

    public Line(Point start, Point end) {
        this.start = new Point(start.x, start.y);
        this.end = new Point(end.x, end.y);
    }

    public Line(int xStart, int yStart, int xEnd, int yEnd) {
        this(new Point(xStart, yStart), new Point(xEnd, yEnd));
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public void setStart(Point start) {
        this.start = new Point(start.x, start.y);
    }

    public void setEnd(Point end) {
        this.end = new Point(end.x, end.y);
    }

    @Override
    public  String toString(){
        return "Линия от {"+start.x+ ";"+start.y+"} до {"+end.x+ ";"+end.y+"}";
    }

    public double length(){
        return sqrt((start.x-end.x)*(start.x-end.x) + (start.y - end.y)*(start.y - end.y));
    }

    public static void main(String[] args) {
        Line l1 = new Line(new Point(1,1),new Point(10,15));
        System.out.println(l1.length());

        Line l2 = new Line(l1.start, l1.end);
        System.out.println(l2.toString());

        l1.setStart(l2.end);
        System.out.println(l1.toString());
        System.out.println(l2.toString());
    }
}
