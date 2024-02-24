package edu.mipt.kozub.city;

import edu.mipt.kozub.reflection.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class City extends Entity {
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

//    @Override
//    public String toString(){
//        return "City: " + name + ", roads: " + roads.toString();
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(getRoads(), city.getRoads());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRoads());
    }
}