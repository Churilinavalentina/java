public class Gun {
    private int patron;

    public Gun(int patron) {
        this.patron = patron;
    }
    public Gun() {
        this.patron = 5;
    }

    public void setPatron(int patron) {
        if (patron<0) {
            System.out.println("Пистолет не может содержать отрицательное количество патронов");
            throw new IllegalArgumentException();
        }
        if (patron <= this.patron) this.patron = patron;
        else {
            this.patron = patron;
            System.out.println(patron-this.patron +" патронов оказались лишние");
        }
    }

    public int getPatron() {
        return patron;
    }

    public int getAllPatron() {
        int count = patron;
        patron = 0;
        return count;
    }

    public boolean charged() {
        if (patron>0) return true;
        return false;
    }


    public void shot(int countShot){
        for (int i =0;i<countShot;i++){
            if (patron > 0){
                patron -= 1;
                System.out.println("Бaх!");
            } else {
                System.out.println("Клац!");
            }
        }
    }

    public static void main(String[] args) {
        //1.5
        //Gun g = new Gun(3);
        //g.shot(5);

        //1.6
        Gun g2 = new Gun(7);
        g2.patron = 3;
        g2.shot(5);
        g2.patron = 8;
        g2.shot(2);
        g2.getAllPatron();
        g2.shot(1);
    }
}
