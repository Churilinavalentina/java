package edu.mipt.kozub.city;

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
        }
    }
}
