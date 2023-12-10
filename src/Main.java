public class Main {
    public static void main(String[] args) {

        Point A = new Point(8, 9);
        System.out.println(A.position());

        Names people2 = new Names();
        people2.firstName = "Клеопатра";
        people2.surname = "Клеопатра";
        System.out.println(people2.fullName());

        Time x = new Time(12005);
        System.out.println(x.time());

        House home = new House(12005);
        System.out.println(home.houseInfo());
    }
}