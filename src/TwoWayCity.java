import java.util.Arrays;
import java.util.List;

public class TwoWayCity extends City{
    public TwoWayCity(String name, Road... roads) {
        super(name, roads);
    }

    @Override
    public void setRoads(List<Road> roads) {
        for(Road x:roads) {
            for (Road y: super.getRoads()){
                if (x.getToCity() == y.getToCity()) {
                    System.out.println("Город уже добавлен");
                    throw new IllegalArgumentException();
                }
            }
            super.setRoads(Arrays.asList(x));
            Road twoRoad = new Road(this, x.getCoast());
            x.getToCity().setRoads(Arrays.asList(twoRoad));
            System.out.println(x.getToCity().toString());
        }
    }

    public static void main(String[] args) {
        TwoWayCity a = new TwoWayCity("a");
        City b = new City("b");

        Road r1 = new Road(b, 4);
        a.setRoads(Arrays.asList(r1));

        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}
