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


    public static void main(String[] args) {
        House home = new House(2);
        //home.floor = 35;
        //home.floor = 91;
        System.out.println(home.toString());

        House h2 = new House(-1);
        System.out.println(h2.toString());
    }
}
