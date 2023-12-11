import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class City {
    private String name;
    private List<Road> roads = new ArrayList<>();

    public City(String name, Road...roads) {
        this(name, Arrays.asList(roads));
    }

    public City(String name, List<Road> roads) {
        this.name = name;
        for(Road x:roads) {
            for (Road y: this.roads){
                if (x.nameCity.getName() == y.nameCity.getName()) {
                    System.out.println("Город уже добавлен");
                    throw new IllegalArgumentException();
                }
            }
            this.roads.add(x);
        }
    }

    public String getName() {
        return name;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoads(List<Road> roads) {
        for(Road x:roads) {
            for (Road y: this.roads){
                if (x.nameCity.getName() == y.nameCity.getName()) {
                    System.out.println("Город уже добавлен");
                    throw new IllegalArgumentException();
                }
            }
            this.roads.add(new Road(x.nameCity, x.coast));
        }
    }

    public void dropRoads(Road road) {
        this.roads.remove(road);
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

        e.setRoads(Arrays.asList(new Road(f, 2)));
    }
}

class Road {
    City nameCity;
    int coast;

    public Road(City city, int coast) {
        this.nameCity = new City(city.getName(), city.getRoads());
        this.coast = coast;
    }

    @Override
    public String toString(){
        return "Road{" + "wayTo=" + nameCity.getName() + ", cost=" +coast+ "}";
    }
}