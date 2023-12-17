package bird;

public abstract class AbstravtBird {
    public abstract void singing();

    public static void main(String[] arg){
        //1.5
        Sparrow s1 = new Sparrow();
        s1.singing();

        Parrot p1 = new Parrot("кар");
        p1.singing();
    }
}
