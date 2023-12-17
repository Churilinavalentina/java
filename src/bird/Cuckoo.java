package bird;

import java.util.Random;

public class Cuckoo extends AbstravtBird{
    @Override
    public void singing(){
        Random r = new Random();
        int rn = r.nextInt(10);
        for (int i = 0; i<rn;i++) {
            System.out.println("ку-");
        }
    }
}
