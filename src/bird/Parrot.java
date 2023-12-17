package bird;

import java.util.Random;

public class Parrot extends AbstravtBird implements Sing {
    private String text;

    public Parrot(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void singing(){
        Random r = new Random();
        int rn = r.nextInt(text.length());
        for (int i = 0; i<=rn;i++) {
            System.out.print(text.charAt(i));
        }
        System.out.println("");
    }
}