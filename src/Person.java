public class Person {
    Names name;
    int height;
    Person father;

    public Person(Names name) {
        this.name = name;
    }

    public Person(String name, int height) {
        this.name = new Names(name);
        this.height = height;
    }

    public Person(String name, int height, Person father) {
        this(name, height);
        this.father = father;
    }

    public Person(Names name, int height, Person father) {
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

    public String personInfo(){
        if (father != null) {
            if (name.secondName == null && father.name.secondName != null) {
                name.secondName = father.name.secondName;
            }

            if (name.surname == null && father.name.firstName != null) {
                name.surname = father.name.firstName + "ович";
            }
        }
        return ("Человек с именем " + name.fullName());
    }

    public String personInfoHeight(){
        return ("Человек с именем " + name.fullName()+"и ростом "+height);
    }


    public static void main(String[] args) {
        //1.2.2
        Person people21 = new Person(new Names());
        people21.name.firstName = "Клеопатра";
        people21.height = 152;
        System.out.println(people21.personInfoHeight());

        Person people22 = new Person(new Names());
        people22.name.firstName = "Александр";
        people22.name.secondName = "Пушкин";
        people22.name.surname = "Сергеевич";
        people22.height = 167;
        System.out.println(people22.personInfoHeight());

        Person people23 = new Person(new Names());
        people23.name.firstName = "Владимир";
        people23.name.secondName = "Маяковский";
        people23.height = 189;
        System.out.println(people23.personInfoHeight());


        //1.2.3
        Person people31 = new Person(new Names());
        people31.name.firstName = "Иван";
        people31.name.secondName = "Чудов";

        Person people32 = new Person(new Names());
        people32.name.firstName = "Петр";
        people32.name.secondName = "Чудов";
        people32.father = people31;

        Person people33 = new Person(new Names());
        people33.name.firstName = "Борис";
        people33.father = people32;

        System.out.println("");
        System.out.println(people31.personInfo());
        System.out.println(people32.personInfo());
        System.out.println(people33.personInfo());


        //1.4.6
        Person people61 = new Person("Лев", 170);
        Person people62 = new Person(new Names("Сергей", "Пушкин"), 168, people61);
        Person people63 = new Person("Александр", 167, people62);

        System.out.println("");
        System.out.println(people61.personInfo());
        System.out.println(people62.personInfo());
        System.out.println(people63.personInfo());
    }
}
