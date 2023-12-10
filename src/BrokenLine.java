import java.util.ArrayList;
import java.util.List;

public class BrokenLine {
    List<Point> brokenLine = new ArrayList<>();

    public BrokenLine(Point...line) {
        for(Point x:line) this.brokenLine.add(x);
    }

    public String brokenLineToString (){
        String result = "Линия ";
        for(Point x:brokenLine) result = result+ x.position();
        return result;
    }

    public static void main(String[] args) {
        BrokenLine l1 = new BrokenLine(new Point(1,5), new Point(2,8), new Point(5,3));
        System.out.println(l1.brokenLineToString());

        BrokenLine l2 = new BrokenLine();
        l2.brokenLine.add(l1.brokenLine.getFirst());
        l2.brokenLine.add(new Point(2,-5));
        l2.brokenLine.add(new Point(4,-8));
        l2.brokenLine.add(l1.brokenLine.getLast());

        l1.brokenLine.add(0, new Point(3,4));
        System.out.println(l1.brokenLineToString());
        System.out.println(l2.brokenLineToString());
    }
}
