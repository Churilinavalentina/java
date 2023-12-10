public class Gun {
    int patron;

    public Gun(int patron) {
        this.patron = patron;
    }
    public Gun() {
        this.patron = 5;
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
        Gun g = new Gun(3);
        g.shot(5);
    }
}
