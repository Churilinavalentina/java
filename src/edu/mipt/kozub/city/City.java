package edu.mipt.kozub.city;

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
        setRoads(roads);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Road> getRoads() {
        return new ArrayList<>(roads);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoads(List<Road> roads) {
        for(Road x:roads) {
            for (Road y: this.roads){
                if (x.getToCity() == y.getToCity()) {
                    System.out.println("Город уже добавлен");
                    throw new IllegalArgumentException();
                }
            }
            this.roads.add(x);
        }
    }

    public void dropRoads(Road road) {
        this.roads.remove(road);
    }

    @Override
    public String toString(){
        return "City: " + name + ", roads: " + roads.toString();
    }

}

class Road {
    private City toCity;
    private int coast;

    public Road(City city, int coast) {
        this.toCity = new City(city.getName(), city.getRoads());
        this.coast = coast;
    }

    public City getToCity() {
        return toCity;
    }

    public int getCoast() {
        return coast;
    }

    @Override
    public String toString(){
        return "Road{" + "wayTo=" + toCity.getName() + ", cost=" +coast+ "}";
    }
}