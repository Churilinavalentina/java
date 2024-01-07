package edu.mipt.kozub.city;

import java.util.Objects;

public class Road {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road road)) return false;
        return getCoast() == road.getCoast() && Objects.equals(getToCity().getName(), road.getToCity().getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getToCity(), getCoast());
    }
}
