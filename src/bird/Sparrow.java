package bird;

public class Sparrow extends AbstravtBird implements Sing {
    @Override
    public void singing(){
        System.out.println("чырык");
    }
}
