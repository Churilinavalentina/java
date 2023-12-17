package city;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        TwoWayCity a = new TwoWayCity("a");
        City b = new City("b");

        Road r1 = new Road(b, 4);
        a.setRoads(Arrays.asList(r1));

        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}
