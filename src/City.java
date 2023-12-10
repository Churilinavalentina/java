import java.util.ArrayList;
import java.util.List;

public class City {
    String name;
    List<Road> roads = new ArrayList<>();

    public City(String name, Road...roads) {
        this.name = name;
        for(Road x:roads) this.roads.add(x);
    }

    @Override
    public String toString(){
        return "City: " + name + ", roads: " + roads.toString();
    }

    public static void main(String[] args) {
        City a = new City("a");
        City b = new City("b");
        City c = new City("c");
        City d = new City("d");
        City f = new City("f");
        City e = new City("e");

        a.roads.add(new Road(f,1));
        a.roads.add(new Road(b,5));
        a.roads.add(new Road(d,6));

        b.roads.add(new Road(a,5));
        b.roads.add(new Road(c,3));

        c.roads.add(new Road(b,3));
        c.roads.add(new Road(d,4));

        d.roads.add(new Road(e,2));
        d.roads.add(new Road(a,6));
        d.roads.add(new Road(c,4));

        f.roads.add(new Road(e,2));
        f.roads.add(new Road(b,1));

        e.roads.add(new Road(f,2));

        System.out.println(a.toString());
    }
}

class Road {
    City nameCity;
    int coast;

    public Road(City City, int coast) {
        this.nameCity = City;
        this.coast = coast;
    }

    @Override
    public String toString(){
        return "Road{" + "wayTo=" + nameCity.name + ", cost=" +coast+ "}";
    }
}