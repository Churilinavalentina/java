public class Name {
    private String firstName;
    private String secondName;
    private String surname;

    public Name() {}

    public Name(String firstName) {
        this.firstName = firstName;
    }

    public Name(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Name(String firstName, String secondName, String surname) {
        this(firstName, secondName);
        if ((firstName==null || firstName=="") && (secondName==null || secondName=="") && (surname==null || surname=="")) throw new IllegalArgumentException();
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString(){
        String fullName = (secondName == null  ? "" : secondName + " ") +
                (firstName == null ? "" : firstName + " ") +
                (surname == null ? "" : surname + " ");
        return fullName;
    }

    public static void main(String[] args) {
        Name n1 = new Name("Клеопатра");
        Name n2 = new Name("Александр", "Пушкин", "Сергеевич");
        Name n3 = new Name("Владимир", "Маяковский");
        Name n4 = new Name("Христофор", "Бонифатьевич");

        System.out.println(n1.toString());
        System.out.println(n2.toString());
        System.out.println(n3.toString());
        System.out.println(n4.toString());

        Name n5 = new Name("", "", null);
    }

}
