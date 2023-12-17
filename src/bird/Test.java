package bird;

public class Test {
    public static void sing(Sing... birds){
        for (Sing s: birds){
            s.singing();
        }
    }
    public static void main(String[] arg){
        //1.5
        Sing s1 = new Sparrow();
        Sing p1 = new Parrot("кар");
        Sing c1 = new Cuckoo();

        sing(s1, p1, c1);
    }
}
