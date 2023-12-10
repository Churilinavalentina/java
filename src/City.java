import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {
    String name;
    List<Pair> roads = new ArrayList<>();

    public City(String name, Pair...roads) {
        this.name = name;
        for(Pair x:roads) this.roads.add(x);
    }

    public static void main(String[] args) {
        City a = new City("A", new Pair("F", 1), new Pair("B", 5), new Pair("D", 6));
        City b = new City("B", new Pair("A", 5), new Pair("C", 3));
        City c = new City("B", new Pair("B", 3), new Pair("D", 4));
        City d = new City("D", new Pair("E", 2), new Pair("A", 6), new Pair("C", 4));
        City f = new City("F", new Pair("E", 2), new Pair("B", 1));
        City e = new City("E", new Pair("F", 2));
    }
}

class Pair {
    String nameCity;
    int coast;

    public Pair(String nameCity, int coast) {
        this.nameCity = nameCity;
        this.coast = coast;
    }
}