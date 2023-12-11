public class Square {
    private Point leftApp;
    private int length;

    public Square(Point leftApp, int length) {
        if (length < 0) throw new IllegalArgumentException();
        this.leftApp = leftApp;
        this.length = length;
    }

    public Square(int x, int y, int length) {
        this(new Point(x,y), length);
    }

    public int getLeftApp() {
        return length;
    }

    public void setLength(int length) {
        if (length < 0) throw new IllegalArgumentException();
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString(){
        return "Квадрат в точке "+ leftApp.toString()+" со стороной "+length;
    }

    public BrokenLine toLine(){
        return new BrokenLine(leftApp, new Point(leftApp.x+length, leftApp.y),
                new Point(leftApp.x+length, leftApp.y-length), new Point(leftApp.x, leftApp.y-length), leftApp);
    }

    public static void main(String[] args) {
        Square s1 = new Square(new Point(5,3), 23);
        BrokenLine b1 = s1.toLine();
        System.out.println(b1.toString());
        System.out.println(b1.length());

        b1.removeLast();
        b1.setPoint(new Point(15,25));
        System.out.println(b1.toString());
        System.out.println(b1.length());

//        Square s3 = new Square(new Point(5,3), 23);
//        System.out.println(s3.toString());

        s1.setLength(-2);
        System.out.println(s1.toString());
    }
}
