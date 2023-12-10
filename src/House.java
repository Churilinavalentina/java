public class House {
    final int floor;

    public House(int floor) {
        this.floor = floor;
    }

    public String houseInfo(){
        return ("Дом с "+floor + " этажами");
    }


    public static void main(String[] args) {
        House home = new House(2);
        //home.floor = 35;
        //home.floor = 91;
        System.out.println(home.houseInfo());
    }
}
