package ru.mipt.edu.kozub.cat;

public class Cat implements Meow {
    String name;

    public Cat(String name) {
        this.name = name;
    }
    @Override
    public  String toString(){
        return "кот: "+ name;
    }

    public String meow(int count) {
        String meow = name +": ";
        for(int i=0; i<count-1;i++){
            meow = meow + "мяу-";
        }
        meow = meow + "мяу!";
        return meow;
    }

    public String meow() {
        return meow(0);
    }

}
