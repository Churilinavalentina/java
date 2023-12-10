public class Names {
    String firstName;
    String secondName;
    String surname;

    public Names() {}

    public Names(String firstName) {
        this.firstName = firstName;
    }

    public Names(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Names(String firstName, String secondName, String surname) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
    }

    public String fullName(){
        String fullName = (secondName == null  ? "" : secondName + " ") +
                (firstName == null ? "" : firstName + " ") +
                (surname == null ? "" : surname + " ");
        return fullName;
    }

    public static void main(String[] args) {
        Names n1 = new Names("Клеопатра");
        Names n2 = new Names("Александр", "Пушкин", "Сергеевич");
        Names n3 = new Names("Владимир", "Маяковский");
        Names n4 = new Names("Христофор", "Бонифатьевич");

        System.out.println(n1.fullName());
        System.out.println(n2.fullName());
        System.out.println(n3.fullName());
        System.out.println(n4.fullName());
    }

}
