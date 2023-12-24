package edu.mipt.kozub.people;

public class Human {
    private Name name;
    private int height;
    private Human father;

    public Human(Name name) {
        this.name = name;
    }

    public Human(String name, int height) {
        this.name = new Name(name);

        if (height<0 || height>500) throw new IllegalArgumentException();
        this.height = height;
    }

    public Human(String name, int height, Human father) {
        this(name, height);
        this.father = father;
    }

    public Human(Name name, int height, Human father) {
        this.name = name;
        this.height = height;
        this.father = father;
        if (father != null) {
            if (this.name.getSecondName() == null && father.name.getSecondName() != null) {
                this.name.setSecondName(father.name.getSecondName());
            }

            if (this.name.getSurname() == null && father.name.getFirstName() != null) {
                this.name.setSurname(father.name.getFirstName() + "ович");
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Human getFather() {
        return father;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString(){
        if (father != null) {
            if (this.name.getSecondName() == null && father.name.getSecondName() != null) {
                this.name.setSecondName(father.name.getSecondName());
            }

            if (this.name.getSurname() == null && father.name.getFirstName() != null) {
                this.name.setSurname(father.name.getFirstName() + "ович");
            }
        }
        return ("Человек с именем " + name.toString());
    }

    public String personInfoHeight(){
        return ("Человек с именем " + name.toString()+"и ростом "+height);
    }

}
