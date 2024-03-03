package ru.mipt.edu.kozub.geometry;

import java.util.ArrayList;
import java.util.List;

public class Group implements Groupable {
    private List<Groupable> figures = new ArrayList<>();

    public Group(Groupable...elements) {
        for(Groupable el: elements){
            figures.add(el);
        }
    }

    public List<Groupable> getGr() {
        return new ArrayList<>(figures);
    }

    public void setGr(Groupable element) {
        this.figures.add(element);
    }

    @Override
    public String toString() {
        return "Group{" +
                "figures=" + figures +
                '}';
    }

    public void move(int x, int y){
        for(Groupable element: figures){
            element.move(x,y);
        }
    }
}
