package edu.mipt.kozub.other;

public class House {
    final int floor;

    public House(int floor) {
        if (floor<0) throw new IllegalArgumentException();
        this.floor = floor;
    }

    @Override
    public String toString(){
        return ("Дом с "+floor + " этажами");
    }
}
