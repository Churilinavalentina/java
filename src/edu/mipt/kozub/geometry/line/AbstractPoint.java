package edu.mipt.kozub.geometry.line;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractPoint {
    private List<Atribute> atribute = new ArrayList<>();

    public AbstractPoint(List<Atribute> atribute) {
        for (Atribute a: atribute){
            setAtribute(a.name, a.value);
        }
    }

    public Object getAtribute(String name) {
        for(Atribute at: atribute){
            if(at.name.equals(name)) return at.value;
        }
        return null;
    }

    public void setAtribute(String name, Object value) {
        atribute.add(new Atribute(name, value));
    }
}

class Atribute{
    String name;
    Object value;

    public Atribute(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
