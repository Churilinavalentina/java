public class Line {
    Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int xStart, int yStart, int xEnd, int yEnd) {
        this.start = new Point(xStart, yStart);
        this.end = new Point(xEnd, yEnd);
    }

    public  String lineToString(){
        return "Линия от {"+start.x+ ";"+start.y+"} до {"+end.x+ ";"+end.y+"}";
    }

    public static void main(String[] args) {
        Line l1 = new Line(new Point(1,3),new Point(28,8));
        System.out.println(l1.lineToString());

        Line l2 = new Line(new Point(5,10),new Point(28,10));
        System.out.println(l2.lineToString());

        Line l3 = new Line(l1.start, l2.end);
        System.out.println(l3.lineToString());

        l1.start.x = 4;
        l1.start.y = 5;
        l2.end.x = 4;
        l2.end.y = 6;
        System.out.println("");
        System.out.println(l1.lineToString());
        System.out.println(l2.lineToString());
        System.out.println(l3.lineToString());

        l1.start= new Point(9,8);
        System.out.println("");
        System.out.println(l1.lineToString());
        System.out.println(l3.lineToString());
    }
}
