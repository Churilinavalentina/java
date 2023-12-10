public class Cat {
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

    public static void main(String[] args) {
        Cat c = new Cat("Барсик");
        System.out.println(c.meow(1));
        System.out.println(c.meow(3));
    }
}
