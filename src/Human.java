public class Human {
    Name name;
    int height;
    Human father;

    public Human(Name name) {
        this.name = name;
    }

    public Human(String name, int height) {
        this.name = new Name(name);
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
            if (this.name.secondName == null && father.name.secondName != null) {
                this.name.secondName = father.name.secondName;
            }

            if (this.name.surname == null && father.name.firstName != null) {
                this.name.surname = father.name.firstName + "ович";
            }
        }
    }

    @Override
    public String toString(){
        if (father != null) {
            if (name.secondName == null && father.name.secondName != null) {
                name.secondName = father.name.secondName;
            }

            if (name.surname == null && father.name.firstName != null) {
                name.surname = father.name.firstName + "ович";
            }
        }
        return ("Человек с именем " + name.toString());
    }

    public String personInfoHeight(){
        return ("Человек с именем " + name.toString()+"и ростом "+height);
    }


    public static void main(String[] args) {
        //1.2.2
        Human people21 = new Human(new Name());
        people21.name.firstName = "Клеопатра";
        people21.height = 152;
        System.out.println(people21.personInfoHeight());

        Human people22 = new Human(new Name());
        people22.name.firstName = "Александр";
        people22.name.secondName = "Пушкин";
        people22.name.surname = "Сергеевич";
        people22.height = 167;
        System.out.println(people22.personInfoHeight());

        Human people23 = new Human(new Name());
        people23.name.firstName = "Владимир";
        people23.name.secondName = "Маяковский";
        people23.height = 189;
        System.out.println(people23.personInfoHeight());


        //1.2.3
        Human people31 = new Human(new Name());
        people31.name.firstName = "Иван";
        people31.name.secondName = "Чудов";

        Human people32 = new Human(new Name());
        people32.name.firstName = "Петр";
        people32.name.secondName = "Чудов";
        people32.father = people31;

        Human people33 = new Human(new Name());
        people33.name.firstName = "Борис";
        people33.father = people32;

        System.out.println("");
        System.out.println(people31.toString());
        System.out.println(people32.toString());
        System.out.println(people33.toString());


        //1.4.6
        Human people61 = new Human("Лев", 170);
        Human people62 = new Human(new Name("Сергей", "Пушкин"), 168, people61);
        Human people63 = new Human("Александр", 167, people62);

        System.out.println("");
        System.out.println(people61.toString());
        System.out.println(people62.toString());
        System.out.println(people63.toString());
    }
}
